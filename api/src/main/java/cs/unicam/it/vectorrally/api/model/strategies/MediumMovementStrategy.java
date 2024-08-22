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

package cs.unicam.it.vectorrally.api.model.strategies;

import cs.unicam.it.vectorrally.api.model.agent.Agent;
import cs.unicam.it.vectorrally.api.model.track.Track;
import cs.unicam.it.vectorrally.api.model.track.TrackTile;
import cs.unicam.it.vectorrally.api.model.utlis.Acceleration;
import cs.unicam.it.vectorrally.api.model.utlis.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MediumMovementStrategy implements MovementStrategy {
    private final Track track;

    public MediumMovementStrategy(Track track) {
        this.track = track;
    }

    @Override
    public void nextMove(Agent agent) {
        Acceleration currentAcceleration = agent.getAcceleration();
        Position agentPosition = agent.getPosition();
        Position nextPosition = agentPosition.getNextPosition(currentAcceleration);

        List<Position> validMovements = getValidMovements(nextPosition);
        if (!validMovements.isEmpty()) {
            return;
        }

        Position selectedPosition = selectRandomPosition(validMovements);

        Acceleration nextAcceleration = calculateNextAcceleration(currentAcceleration, nextPosition, selectedPosition);

        agent.setAcceleration(nextAcceleration);
        agent.setPosition(selectedPosition);
    }

    private List<Position> getValidMovements(Position nextPosition) {
        Position[] nextPositions = getAllNeighbors(nextPosition);
        List<Position> validMovements = new ArrayList<>();

        for (Position position : nextPositions) {
            if (track.isAgentOutOfTrack(position)) {
                return null;
            }

            if (track.getTrackTileAt(position.x(), position.y()) != TrackTile.WALL) {
                validMovements.add(position);
            }
        }

        return validMovements;
    }

    private Position selectRandomPosition(List<Position> validMovements) {
        Random rand = new Random();
        int idx = rand.nextInt(validMovements.size());
        return validMovements.get(idx);
    }

    private Acceleration calculateNextAcceleration(Acceleration currentAcceleration, Position nextPosition, Position selectedPosition) {
        int deltaX = nextPosition.x() - selectedPosition.x();
        int deltaY = nextPosition.y() - selectedPosition.y();
        return new Acceleration(currentAcceleration.x() + deltaX, currentAcceleration.y() + deltaY);
    }
}