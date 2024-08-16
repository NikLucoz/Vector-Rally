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
import cs.unicam.it.api.model.TrackTile;
import cs.unicam.it.api.model.Vector;
import cs.unicam.it.api.model.interfaces.Agent;
import cs.unicam.it.api.model.interfaces.MovementStrategy;
import cs.unicam.it.api.model.interfaces.Track;
import cs.unicam.it.api.view.interfaces.TextUtils;

import java.util.ArrayList;
import java.util.Random;

public class MediumMovementStrategy implements MovementStrategy {

    @Override
    public void nextMove(Agent agent, Track track) {
        Vector vector = agent.getPosition().getVector();
        Vector accelerationVector = calculateAcceleration(vector);

        ArrayList<Vector> possibleMoves = new ArrayList<Vector>();
        for (int x = -1; x < 1; x++) {
            for (int y = -1; y < 1; y++) {
                possibleMoves.add(new Vector(accelerationVector.x() + x, accelerationVector.y() + y));
            }
        }

        possibleMoves.removeIf(move -> track.getTrackTileAt(move.y(), move.x()) == TrackTile.WALL);
        TextUtils.printCustomlnText(String.valueOf(possibleMoves.size()) + " ->" + agent.getId());

        if (possibleMoves.isEmpty()) {
            agent.setPosition(new Position(
                    accelerationVector.x(),
                    accelerationVector.y()
            ));
            return;
        }

        Random rng = new Random();
        Vector randomMove = possibleMoves.get(rng.nextInt(possibleMoves.size()));

        agent.setPosition(new Position(
                randomMove.x(),
                randomMove.y()
        ));
    }
}
