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

package cs.unicam.it;

import cs.unicam.it.api.controller.GameEngine;
import cs.unicam.it.api.model.AgentManager;
import cs.unicam.it.api.model.RaceConfigLoader;
import cs.unicam.it.api.model.TrackManager;
import cs.unicam.it.api.model.interfaces.FileLoader;
import cs.unicam.it.api.view.TextUserInterface;
import cs.unicam.it.api.view.interfaces.UserInterface;

public class TerminalApp {

    public boolean test() {
        return true;
    }

    public static void main(String[] args) {
        try {
            UserInterface ui = new TextUserInterface();

            RaceConfigLoader loader = new RaceConfigLoader();
            String filePath = loader.getRaceConfigFilePath();
            TrackManager trackManager = new TrackManager(filePath);
            AgentManager agentManager = new AgentManager(filePath);

            GameEngine gameEngine = new GameEngine(trackManager.load(), agentManager.load(), ui);

            ui.setup();
            gameEngine.run();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


}
