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

import cs.unicam.it.vectorrally.api.model.strategies.*;
import cs.unicam.it.vectorrally.api.model.track.Track;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StrategyManager implements Manager<MovementStrategy> {

    private final Track track;
    private final String pathToFile;
    private final Map<Strategy, MovementStrategyFactory> strategyFactories;

    public StrategyManager(String pathToFile, Track track) {
        this.pathToFile = pathToFile;
        this.track = track;

        this.strategyFactories = new HashMap<>();
        this.strategyFactories.put(Strategy.SIMPLE, SimpleMovementStrategy::new);
    }

    @Override
    public MovementStrategy load() {
        try {
            File myFile = new File(this.pathToFile);
            Scanner myReader = new Scanner(myFile);

            // Skip Agent lines
            Strategy strategy = Strategy.fromValue(myReader.nextInt());

            MovementStrategy movementStrategy = strategyFactories.get(strategy).create();

            return movementStrategy;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return new SimpleMovementStrategy();
    }
}
