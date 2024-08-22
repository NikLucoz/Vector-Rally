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

package cs.unicam.it.vectorrally.api.controller;

import cs.unicam.it.vectorrally.api.model.agent.Agent;
import cs.unicam.it.vectorrally.api.model.track.Track;
import cs.unicam.it.vectorrally.api.view.Color;
import cs.unicam.it.vectorrally.api.view.TextUtils;
import cs.unicam.it.vectorrally.api.view.UserInterface;

public class GameEngine implements Engine{
    private final Track track;
    private final Agent[] agents;
    private final UserInterface UI;
    private boolean playing = true;
    private final int simulationTime = 2000;

    public GameEngine(Track track, Agent[] agents, UserInterface ui) {
        this.track = track;
        this.agents = agents;
        this.UI = ui;
        setPlayersOnTrack();
    }

    /**
     * Places all the agents onto the track by calling the track.addAgents method.
     * This method is called in the constructor to initialize the game state with the agents positioned correctly on the track.
     */
    private void setPlayersOnTrack() {
        track.addAgents(agents);
    }

    @Override
    public void run() throws InterruptedException {
        this.gameLoop();
    }

    /**
     * Runs the main game loop which updates the game state and checks for winners.
     * It updates the UI, processes each agent's move, and checks if any agent has won or if all agents are disqualified.
     * This loop continues running until a winner is found or all agents are disqualified.
     *
     * @throws InterruptedException if the thread is interrupted during sleep
     */
    private void gameLoop() throws InterruptedException {
        UI.update(agents, track);
        Thread.sleep(simulationTime);

        while(playing) {
            updateActors();
            UI.update(agents, track);
            checkForWinner();
        }
    }

    /**
     * Updates the state of each agent. Each agent's next move is determined and executed.
     * Agents that move out of the track are disqualified.
     */
    private void updateActors() {
        for (Agent agent : agents) {
            if (agent.isInRace()) {
                agent.nextMove(); // ask each actor for a move

                // Check if agent is out of track and disqualify it if true
                if (track.isAgentOutOfTrack(agent)) {
                    agent.setIsInRace(false);
                    TextUtils.printCustomlnText(agent.getSymbol() + " disqualified!");
                }
            }
        }
    }

    /**
     * Checks if there is a winner among the agents. If an agent is found to be on the finish line,
     * the game ends, the winner is displayed, and the `playing` flag is set to false.
     * If no agents are still in the race, the game ends with all agents disqualified.
     */
    private void checkForWinner() {
        // Check for winners, if true set playing to false
        // update playing value
        if (checkIfAllDisqualified()) return;

        for (Agent agent : agents) {
            if (!agent.isInRace()) continue;
            if (track.isAgentOnFinishLine(agent)) {
                playing = false;
                UI.showWinner(agent);
                return;
            }
        }

    }

    /**
     * Checks if all agents have been disqualified from the race.
     * This method iterates through all agents and verifies if they are still in the race.
     * If no agents are still in the race, a message indicating that all cars are disqualified
     * is displayed, and the `playing` flag is set to `false`.
     *
     * @return true if all agents are disqualified, false otherwise
     */
    private boolean checkIfAllDisqualified() {
        boolean allDisqualified = true;

        for (Agent agent : agents) {
            if (agent.isInRace()) {
                allDisqualified = false;
                break;
            }
        }

        if (allDisqualified) {
            TextUtils.printCustomText("All agents are disqualified!", Color.RED_UNDERLINED);
            playing = false;
        }

        return allDisqualified;
    }
}
