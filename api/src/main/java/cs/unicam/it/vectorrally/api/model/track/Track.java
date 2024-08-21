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

package cs.unicam.it.vectorrally.api.model.track;

import cs.unicam.it.vectorrally.api.model.utlis.Position;
import cs.unicam.it.vectorrally.api.model.agent.Agent;
import java.util.ArrayList;

/**
 * Represents the racetrack in this game.
 *
 * @version 1.0
 * @since 2024-08-15
 * @author Niccolò Lucozzi
 **/
public interface Track {

    /**
     * Retrieves the entire track layout represented as a 2D array of {@link TrackTile}.
     *
     * @return a 2D array of {@link TrackTile} representing the track.
     */
    TrackTile[][] getTrack();

    /**
     * Checks if the specified agent is out of the boundaries of the track.
     *
     * @param agent the agent to be checked.
     * @return {@code true} if the agent is out of the track, {@code false} otherwise.
     */
    boolean isAgentOutOfTrack(Agent agent);

    /**
     * Checks if the specified agent is currently on the finish line.
     *
     * @param agent the agent to be checked.
     * @return {@code true} if the agent is on the finish line, {@code false} otherwise.
     */
    boolean isAgentOnFinishLine(Agent agent);

    /**
     * Retrieves the {@link TrackTile} at the specified coordinates on the track.
     *
     * @param x the x-coordinate of the tile.
     * @param y the y-coordinate of the tile.
     * @return the {@link TrackTile} located at the specified coordinates.
     */
    TrackTile getTrackTileAt(int x, int y);

    /**
     * Retrieves the width of the track, measured in the number of tiles.
     *
     * @return the width of the track.
     */
    int getWidth();

    /**
     * Retrieves the height of the track, measured in the number of tiles.
     *
     * @return the height of the track.
     */
    int getHeight();

    /**
     * Sets all the specified agents on the starting line and adds them to the map.
     *
     * @param agents an array of {@link Agent} objects to be placed on the starting line.
     */
    void addAgents(Agent[] agents);

    /**
     * Retrieves the positions of the starting line on the track.
     *
     * @return an {@link ArrayList} of {@link Position} objects representing the starting line.
     */
    ArrayList<Position> getStartingLine();

    /**
     * Retrieves the positions of the finish line on the track.
     *
     * @return an {@link ArrayList} of {@link Position} objects representing the finish line.
     */
    ArrayList<Position> getFinishLine();
}
