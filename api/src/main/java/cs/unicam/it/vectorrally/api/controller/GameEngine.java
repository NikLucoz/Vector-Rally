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

public class GameEngine {
    private final Track track;
    private final Agent[] agents;
    private final UserInterface UI;
    private boolean playing = true;
    private final int simulationTime = 3000;

    public GameEngine(Track track, Agent[] agents, UserInterface ui) {
        this.track = track;
        this.agents = agents;
        this.UI = ui;
        setPlayersOnTrack();
    }

    private void setPlayersOnTrack() {
        track.addAgents(agents);
    }

    public void run() throws InterruptedException {
        this.gameLoop();
    }

    private void gameLoop() throws InterruptedException {
        UI.update(agents, track);
        Thread.sleep(simulationTime);

        while(playing) {
            updateActors();
            UI.update(agents, track);
            checkForWinner();
            Thread.sleep(simulationTime);
        }
    }

    private void updateActors() {
        for (Agent agent : agents) {
            if (agent.isInRace()) {
                agent.nextMove(track); // ask each player for a move

                // Check if agent is out of track and disqualify it if true
                if (track.isAgentOutOfTrack(agent)) {
                    agent.setIsInRace(false);
                    TextUtils.printCustomlnText(agent.getSymbol() + " disqualified!");
                }
            }
        }
    }

    private boolean checkForWinner() {
        // Check for winners, if true set playing to false
        // update playing value
        if (checkIfAllDisqualified()) return false;

        for (Agent agent : agents) {
            if (!agent.isInRace()) continue;
            if (track.isAgentOnFinishLine(agent)) {
                playing = false;
                return true;
            }
        }

        return false;
    }

    private boolean checkIfAllDisqualified() {
        int agentsNumber = agents.length;
        for (Agent agent : agents) {
            if(!agent.isInRace()) {
                agentsNumber--;
            }
        }

        if(agentsNumber == 0) {
            TextUtils.printCustomText("All cars are disqualified!", Color.RED_UNDERLINED);
            playing = false;
            return true;
        }

        return false;
    }
}
