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

package cs.unicam.it.vectorrally.api.model.agent;

import cs.unicam.it.vectorrally.api.model.utlis.Acceleration;
import cs.unicam.it.vectorrally.api.model.utlis.Position;
import cs.unicam.it.vectorrally.api.model.track.Track;

import java.util.Objects;

public abstract class Car implements Agent {
    protected int id;
    protected char symbol;
    protected Position position;
    protected Acceleration acceleration;
    protected boolean inRace;

    public Car(int id, Position position, char symbol) {
        this.id = id;
        this.symbol = symbol;
        this.position = position;
        this.inRace = true;
        this.acceleration = new Acceleration(0, 0);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setPosition(Position position) {
        if (position == null) throw new IllegalArgumentException("Position cannot be null");
        this.position = position;
    }

    @Override
    public void setAcceleration(Acceleration acceleration) {
        if (acceleration == null) throw new IllegalArgumentException("Acceleration cannot be null");
        this.acceleration = acceleration;
    }

    @Override
    public Acceleration getAcceleration() {
        return acceleration;
    }

    @Override
    public char getSymbol() {
        return symbol;
    }

    @Override
    public void nextMove() {
    }

    @Override
    public boolean isInRace() {
        return inRace;
    }

    @Override
    public void setIsInRace(boolean inRace) {
        this.inRace = inRace;
    }
}
