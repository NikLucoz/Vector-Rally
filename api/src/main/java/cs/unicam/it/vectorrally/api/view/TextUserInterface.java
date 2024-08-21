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
import cs.unicam.it.vectorrally.api.model.utlis.CoordinateConverter;
import cs.unicam.it.vectorrally.api.model.utlis.Position;

import java.util.Scanner;

public class TextUserInterface implements UserInterface {
    private final Scanner scanner;

    public TextUserInterface() {
        this.scanner = new Scanner(System.in);
    }

    public void setup() {
        //TODO: implement later
        TextUtils.printGameLogo();
    }

    @Override
    public void showWinners() {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void showMenu() {
        TextUtils.printCustomlnText("-----MENU-----");
    }

    public void update(Agent[] agents, Track track) {
        for (int i = 0; i < track.getHeight(); i++) {
            for (int j = 0; j < track.getWidth(); j++) {
                boolean isAgentAtPos = false;

                Position mapPos = CoordinateConverter.mapToAgentPosition(i, j);
                // Controlla se c'è un agente in questa posizione
                for (Agent agent : agents) {
                    if (!agent.isInRace()) continue;
                    if (agent.getPosition().x() == mapPos.x() && agent.getPosition().y() == mapPos.y()) {
                        // Stampa il simbolo dell'agente
                        TextUtils.printCustomText(String.valueOf(agent.getSymbol()));
                        isAgentAtPos = true;
                        break; // Esce dal ciclo degli agenti
                    }
                }

                if (!isAgentAtPos) {
                    TextUtils.printCustomText(String.valueOf(track.getTrackTileAt(i, j).getSymbol()));
                }
            }

            TextUtils.printCustomlnText(""); // New line
        }
    }

}
