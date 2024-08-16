/*
 * Copyright <2024> <Niccolò Lucozzi>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 *
 */

package cs.unicam.it.api.model;

import cs.unicam.it.api.model.interfaces.Agent;
import cs.unicam.it.api.model.interfaces.Track;

import java.util.ArrayList;

public class RaceTrack implements Track {
    private final TrackTile[][] track;
    private final int width;
    private final int height;

    public RaceTrack(TrackTile[][] track) {
        if (track == null || track.length == 0 || track[0].length == 0) throw new IllegalArgumentException("Invalid track");
        this.track = track;
        this.width = track[0].length;
        this.height = track.length;
    }

    public TrackTile[][] getTrack() {
        return track;
    }

    @Override
    public TrackTile getTrackTileAt(int x, int y) {
        return track[x][y];
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public boolean isAgentOutOfTrack(Agent agent) {
        if (agent == null) throw new IllegalArgumentException("Agent is null");

        Position agentPos = agent.getPosition();
        if (agentPos.getY() < 0 || agentPos.getY() >= width) return true;
        if (agentPos.getX() < 0 || agentPos.getX() >= height) return true;

        return track[agentPos.getX()][agentPos.getY()] == TrackTile.WALL;
    }

    public boolean isAgentOnFinishLine(Agent agent) {
        if (agent == null) throw new IllegalArgumentException("Agent is null");

        Position agentPos = agent.getPosition();
        ArrayList<Position> startingTiles = getFinishLine();
        if (startingTiles.isEmpty()) return false;

        return startingTiles.contains(agentPos);
    }

    @Override
    public void addAgents(Agent[] agents) {
        if (agents == null || agents.length == 0) throw new IllegalArgumentException("No agents passed");

        ArrayList<Position> startingTiles = getStartingLine();
        if (startingTiles.isEmpty()) return;
        if (startingTiles.size() < agents.length) throw new IllegalArgumentException("Invalid number of agents, too much for the starting line");

        for (int i = 0; i < agents.length; i++) {
            agents[i].setPosition(startingTiles.get(i));
        }
    }

    private ArrayList<Position> getAllTilesOfTrack(TrackTile trackTile) {
        ArrayList<Position> tiles = new ArrayList<>();

        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                if (track[x][y] == trackTile) {
                    tiles.add(new Position(x, y));
                }
            }
        }

        return tiles;
    }

    public ArrayList<Position> getStartingLine() {
        return getAllTilesOfTrack(TrackTile.START);
    }

    public ArrayList<Position> getFinishLine() {
        return getAllTilesOfTrack(TrackTile.FINISH);
    }

}
