/*
 * Copyright <2024> <Niccolò Lucozzi>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the “Software”), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 *
 */

package cs.unicam.it.model;

import cs.unicam.it.model.interfaces.Agent;
import cs.unicam.it.model.interfaces.Track;

public class RaceTrack implements Track {
    private final TrackTiles[][] track;
    private final int width;
    private final int height;

    public RaceTrack(TrackTiles[][] track) {
        if (track == null || track.length == 0 || track[0].length == 0) throw new IllegalArgumentException("Invalid track");
        this.track = track;
        this.width = track[0].length;
        this.height = track.length;
    }

    public TrackTiles[][] getTrack() {
        return track;
    }

    @Override
    public TrackTiles getTrackTileAt(int x, int y) {
        return null;
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
        Position agentPos = agent.getPosition();
        return track[agentPos.getX()][agentPos.getY()] == TrackTiles.WALL;
    }

    @Override
    public void addAgent(Agent agent) {
        // TODO implement later, this method has to put the agent on the track start line
    }

}
