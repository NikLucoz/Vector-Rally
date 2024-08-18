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

package cs.unicam.it.vectorrally.api.model.loader;

import cs.unicam.it.vectorrally.api.model.agent.Agent;
import cs.unicam.it.vectorrally.api.model.agent.BotCar;
import cs.unicam.it.vectorrally.api.model.utlis.Position;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AgentManager implements Manager<Agent[]> {
    private final String pathToFile;

    public AgentManager(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public Agent[] load() {
        try {
            File myFile = new File(this.pathToFile);
            Scanner myReader = new Scanner(myFile);

            // First line (Players) - Second line (Bots)
            int numPlayer = Integer.parseInt(myReader.nextLine());
            int numBots = Integer.parseInt(myReader.nextLine());

            Agent[] agents = new Agent[numPlayer + numBots];

            for (int i = 0; i < numBots; i++) {
                agents[i] = new BotCar(i, new Position(0,0), Character.forDigit(i, 10));
            }

//            for (int i = 0; i < numPlayer; i++) {
//                agents[i + numBots] = new BotCar(i, new Position(0,0), Character.forDigit(i + numBots, 10));
//            }

            myReader.close();

            return agents;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;

    }
}
