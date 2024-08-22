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

import java.util.Scanner;

public class TextUserInterface implements UserInterface {
    private final Scanner scanner;

    public TextUserInterface() {
        this.scanner = new Scanner(System.in);
    }

    public void setup() {
        TextUtils.printGameLogo();
        TextUtils.printCustomlnText("Welcome to Vector Rally v1.0", Color.RED_UNDERLINED);
        TextUtils.printCustomText("Are you ready to start? (y/n): ", Color.YELLOW_UNDERLINED);

        String input = scanner.nextLine();
        if (!input.equalsIgnoreCase("y")) {
            System.exit(0);
        }
    }

    @Override
    public void showWinner(Agent agent) {
        TextUtils.printCustomlnText("The winner is Bot" + agent.getId() + "!", Color.RED_UNDERLINED);
        TextUtils.printCustomText("Thanks for playing!", Color.RED);
    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void showMenu() {
        TextUtils.printCustomlnText("-----MENU-----");
    }

    @Override
    public void update(Agent[] agents, Track track) {
        System.out.flush();
        for (int y = 0; y < track.getHeight(); y++) {
            for (int x = 0; x < track.getWidth(); x++) {
                boolean isAgentAtPos = false;

                // Controlla se c'è un agente in questa posizione
                for (Agent agent : agents) {
                    if (!agent.isInRace()) continue;
                    if (agent.getPosition().x() == x && agent.getPosition().y() == y) {
                        // Stampa il simbolo dell'agente
                        TextUtils.printCustomText(String.valueOf(agent.getSymbol()));
                        isAgentAtPos = true;
                        break; // Esce dal ciclo degli agenti
                    }
                }

                if (!isAgentAtPos) {
                    TextUtils.printCustomText(String.valueOf(track.getTrackTileAt(x, y).getSymbol()));
                }
            }

            TextUtils.printCustomlnText(""); // New line
        }
    }

}
