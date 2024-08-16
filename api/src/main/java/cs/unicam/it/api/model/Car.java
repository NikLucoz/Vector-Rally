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

package cs.unicam.it.api.model;

import cs.unicam.it.api.model.interfaces.Agent;
import cs.unicam.it.api.model.interfaces.Track;

public class Car implements Agent {
    protected int id;
    protected char symbol;
    protected Position position;
    protected boolean inRace;

    public Car(int id, Position position, char symbol) {
        this.id = id;
        this.symbol = symbol;
        this.position = position;
        this.inRace = true;
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
        this.position = position;
    }

    @Override
    public char getSymbol() {
        return symbol;
    }

    @Override
    public void nextMove(Track track) {}

    @Override
    public boolean isInRace() {
        return inRace;
    }

    @Override
    public void setIsInRace(boolean inRace) {
        this.inRace = inRace;
    }
}
