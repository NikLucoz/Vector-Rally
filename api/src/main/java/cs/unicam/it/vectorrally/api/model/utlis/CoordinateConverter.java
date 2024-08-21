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

package cs.unicam.it.vectorrally.api.model.utlis;

/**
 * Provides utility methods for converting between map coordinates and agent coordinates.
 *
 * @version 1.0
 * @since 2024-08-15
 * @author Niccolò Lucozzi
 **/
public interface CoordinateConverter {

    /**
     * Converts map coordinates to agent coordinates.
     *
     * @param mapX the x-coordinate on the map.
     * @param mapY the y-coordinate on the map.
     * @return a {@link Position} representing the equivalent agent coordinates.
     * */
    static Position mapToAgentPosition(int mapX, int mapY) {
        // Trasformazione delle coordinate della mappa in coordinate agenti
        return agentToMapPosition(mapX, mapY);
    }

    /**
     * Converts agent coordinates to map coordinates.
     *
     * @param agentX the x-coordinate of the agent.
     * @param agentY the y-coordinate of the agent.
     * @return a {@link Position} representing the equivalent map coordinates.
     */
    static Position agentToMapPosition(int agentX, int agentY) {
        int mapX = agentY; // Convert agent Y to map X
        int mapY = agentX; // Convert agent X to map Y

        return new Position(mapX, mapY);
    }

    /**
     * Converts agent coordinates to map coordinates using a {@link Position} object.
     *
     * @param agentPos the {@link Position} of the agent.
     * @return a {@link Position} representing the equivalent map coordinates.
     */
    static Position agentToMapPosition(Position agentPos) {
        return agentToMapPosition(agentPos.x(), agentPos.y());
    }

    /**
     * Converts map coordinates to agent coordinates using a {@link Position} object.
     *
     * @param mapPos the {@link Position} on the map.
     * @return a {@link Position} representing the equivalent agent coordinates.
     */
    static Position mapToAgentPosition(Position mapPos) {
        return mapToAgentPosition(mapPos.x(), mapPos.y());
    }
}
