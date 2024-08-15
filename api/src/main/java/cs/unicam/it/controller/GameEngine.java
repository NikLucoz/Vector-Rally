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

package cs.unicam.it.controller;

import cs.unicam.it.model.interfaces.Agent;
import cs.unicam.it.model.interfaces.Track;
import cs.unicam.it.view.interfaces.UserInterface;

public class GameEngine {
    private final Track track;
    private final Agent[] agents;
    private final UserInterface UI;
    private boolean playing = true;

    public GameEngine(Track track, Agent[] agents, UserInterface ui) {
        this.track = track;
        this.agents = agents;
        this.UI = ui;
        setPlayersOnTrack();
    }

    private void setPlayersOnTrack() {
        // TODO implement later, this method has to put all agents on the track start line
        for (Agent agent : agents) {
            track.addAgent(agent);
        }
    }

    public void run() {
        // TODO implement later
        //UI setup
        UI.setup(agents, track);

        while(playing){

            // ask each player for a move
            // check if the move is valid
            // move players
            // check for crash
            for (Agent agent : agents) {
                if(agent.isInRace()) {
                    agent.nextMove();
                }
            }

            // print track
            UI.update();

            // Check for winners, if true set playing to false
            // update playing value
        }

        // show winners
        // UI.showWinner();
    }
}
