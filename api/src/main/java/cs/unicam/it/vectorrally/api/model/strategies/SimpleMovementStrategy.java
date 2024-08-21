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

package cs.unicam.it.vectorrally.api.model.movement;

import cs.unicam.it.vectorrally.api.model.agent.Agent;
import cs.unicam.it.vectorrally.api.model.track.Track;
import cs.unicam.it.vectorrally.api.model.utlis.Acceleration;
import cs.unicam.it.vectorrally.api.model.utlis.Movement;
import cs.unicam.it.vectorrally.api.model.utlis.Position;
import cs.unicam.it.vectorrally.api.view.TextUtils;

import java.util.Random;

public class SimpleMovementStrategy implements MovementStrategy {
    @Override
    public void nextMove(Agent agent, Track track) {
        Acceleration currentAcceleration = agent.getAcceleration();

        Position randomNeighbor = getRandomNeighbor();

        Acceleration nextAcceleration = new Acceleration(
                currentAcceleration.x() + randomNeighbor.x(),
                currentAcceleration.y() + randomNeighbor.y()
        );

        Position nextPosition = Movement.getNextPosition(nextAcceleration, agent.getPosition());

        // aggiorna l'accelerazione del player
        agent.setAcceleration(nextAcceleration);
        // aggiorno la nuova posizione del player
        agent.setPosition(nextPosition);

        TextUtils.printCustomlnText("Agent " + agent.getId() + " moved " + currentAcceleration.getDirection().toString());

        //TextUtils.printCustomlnText("Agent " + agent.getId() + " moved from " + agent.getPosition().toString() + " to " + nextPosition.toString() + " with acceleration " + nextAcceleration.toString());
    }

    private Position getRandomNeighbor() {
        Random rand = new Random();
        int min = -1;
        int max = 1;
        int x =  rand.nextInt(max - min + 1) + min;
        int y =  rand.nextInt(max - min + 1) + min;

        return new Position(x, y);
    }
}