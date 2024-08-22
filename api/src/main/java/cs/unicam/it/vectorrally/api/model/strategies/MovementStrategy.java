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

package cs.unicam.it.vectorrally.api.model.strategies;

import cs.unicam.it.vectorrally.api.model.agent.Agent;
import cs.unicam.it.vectorrally.api.model.track.Track;
import cs.unicam.it.vectorrally.api.model.utlis.Position;

import java.util.Random;

/**
 * Defines a strategy for determining the next move of an agent in the game. Implementations of this interface
 * use specific algorithms or rules to decide how an agent should move on the racetrack.
 *
 * @version 1.0
 * @since 2024-08-15
 * @author Niccolò Lucozzi
 **/
public interface MovementStrategy {
    /**
     * Execute agent next move using agent and map data based on the strategy
     * @param agent the {@link Agent} that needs to execute a move.
     */
    void nextMove(Agent agent);

    /**
     * Provides a random neighboring position relative to the agent's next position using the eight-neighbor rule.
     *
     * <p>The method selects a random offset from a predefined set of possible movements. This set includes
     * cardinal directions (left, right, up, down) and diagonal directions (top-left, top-right, bottom-left,
     * bottom-right), corresponding to the eight-neighbor rule.</p>
     *
     * @return a {@link Position} representing a random neighboring location relative to the next position.
     */
    default Position getRandomNeighbor() {
        Random rand = new Random();
        int[][] offsets = {
                {0, 0}, {1, 0}, {-1, 0}, {0, 1}, {0, -1},
                {1, 1}, {-1, -1}, {-1, 1}, {1, -1}
        };

        int idx = rand.nextInt(offsets.length);

        return new Position(offsets[idx][0], offsets[idx][1]);
    }

    /**
     * Provides all the neighboring position relative to the agent's next position using the eight-neighbor rule.
     *
     * <p>The method iterates all the offsets from a predefined set of possible movements. This set includes
     * cardinal directions (left, right, up, down) and diagonal directions (top-left, top-right, bottom-left,
     * bottom-right), corresponding to the eight-neighbor rule.</p>
     *
     * @return a {@link Position[]} representing all neighboring location relative to the next position.
     */
    default Position[] getAllNeighbors(Position nextPosition) {
        Position[] neighbors = new Position[9];
        int[][] offsets = {
                {0, 0}, {1, 0}, {-1, 0}, {0, 1}, {0, -1},
                {1, 1}, {-1, -1}, {-1, 1}, {1, -1}
        };

        for (int i = 0; i < offsets.length; i++) {
            neighbors[i] = new Position(nextPosition.x() + offsets[i][0], nextPosition.y() + offsets[i][1]);
        }

        return neighbors;
    }
}
