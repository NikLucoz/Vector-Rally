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

package cs.unicam.it.vectorrally.api.view;

import cs.unicam.it.vectorrally.api.model.agent.Agent;
import cs.unicam.it.vectorrally.api.model.track.Track;
import cs.unicam.it.vectorrally.api.model.utlis.Position;

/**
 * Defines the methods for a user interface to interact with the game. Implementations of this interface
 * handle the display and update of game information to the user.
 *
 * @version 1.0
 * @since 2024-08-15
 * @author Niccolò Lucozzi
 **/
public interface UserInterface {

    /**
     * Updates the user interface with the current state of agents and the track.
     *
     * @param agents an array of {@link Agent} objects representing the current agents in the game.
     * @param track  the {@link Track} object representing the current state of the racetrack.
     */
    void update(Agent[] agents, Track track);

    /**
     * Sets up the user interface, preparing it for interaction. This might include initializing components,
     * setting up layouts, or displaying introductory messages.
     */
    void setup();

    /**
     * Displays information about the winners of the game. This method is called when the game has ended to
     * show the results to the user.
     */
    void showWinners();

    /**
     * Displays a message to the user. This could be used for notifications, alerts, or general communication.
     *
     * @param message the message to be displayed to the user.
     */
    void showMessage(String message);

    /**
     * Displays the main menu of the user interface, allowing the user to navigate to different sections or options
     * of the game.
     */
    void showMenu();
}