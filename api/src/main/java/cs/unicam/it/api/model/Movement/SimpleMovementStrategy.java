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

package cs.unicam.it.api.model.Movement;

import cs.unicam.it.api.model.Position;
import cs.unicam.it.api.model.Vector;
import cs.unicam.it.api.model.interfaces.Agent;
import cs.unicam.it.api.model.interfaces.MovementStrategy;
import cs.unicam.it.api.model.interfaces.Track;

import java.util.Random;

public class SimpleMovementStrategy implements MovementStrategy {
    @Override
    public void nextMove(Agent agent, Track track) {
        Vector vector = agent.getPosition().getVector();
        Vector accelerationVector = calculateAcceleration(vector);

        Random rand = new Random();
        int minX = accelerationVector.x() - 1;
        int maxX = accelerationVector.x() + 1;
        int x =  rand.nextInt(maxX - minX + 1) + minX;

        int minY = accelerationVector.y() - 1;
        int maxY = accelerationVector.y() + 1;
        int y =  rand.nextInt(maxY - minY + 1) + minY;

        agent.setPosition(new Position(x, y));
    }
}
