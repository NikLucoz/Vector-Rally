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

package cs.unicam.it.vectorrally.api.model.agent;

import cs.unicam.it.vectorrally.api.model.strategies.MovementStrategy;
import cs.unicam.it.vectorrally.api.model.strategies.Strategy;
import cs.unicam.it.vectorrally.api.model.utlis.Acceleration;
import cs.unicam.it.vectorrally.api.model.utlis.Position;
import cs.unicam.it.vectorrally.api.model.track.Track;

/**
 * Represents an agent moving on the map. This interface provides methods to manage
 * the agent postion, acceleration, symbol ecc...
 *
 * @version 1.0
 * @since 2024-08-15
 * @author Niccolò Lucozzi
 **/
public interface Agent {

    /**
     * Retrieves the id associated to the agent
     **/
    int getId();

    /**
     * Retrieves the current position of the agent.
     *
     * @return the current {@link Position} of the agent
     **/
    Position getPosition();

    /**
     * Retrieves the current acceleration of the agent.
     *
     * @return the current {@link Acceleration} of the agent
     **/
    Acceleration getAcceleration();

    /**
     * Sets a new acceleration.
     *
     * @param acceleration the new {@link Acceleration}
     * @throws IllegalArgumentException if the new acceleration is null
     **/
    void setAcceleration(Acceleration acceleration);

    /**
     * Sets a new position.
     *
     * @param position the new {@link Position}
     * @throws IllegalArgumentException if the new position is null
     **/
    void setPosition(Position position);

    /**
     * Sets a new strategy.
     *
     * @param movementStrategy the new {@link MovementStrategy}
     * @throws IllegalArgumentException if the new movement strategy is null
     **/
    void setMovementStrategy(MovementStrategy movementStrategy);

    /**
     * Retrieves the symbol associated with the agent.
     * The symbol is used to distinguish the agent on the map.
     *
     * @return the symbol associated with the agent.
     **/
    char getSymbol();

    /**
     * Ask the agent to make a move.
     */
    void nextMove();

    /**
     * Checks if the agent is still racing or if it is disqualified.
     *
     * @return the state of the agent
     */
    boolean isInRace();

    /**
     * Sets the racing state of the agent.
     *
     * @param inRace the new racing state
     */
    void setIsInRace(boolean inRace);
}
