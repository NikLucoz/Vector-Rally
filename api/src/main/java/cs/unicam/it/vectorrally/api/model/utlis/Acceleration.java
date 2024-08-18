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

package cs.unicam.it.vectorrally.api.model.utlis;

public class Acceleration implements Vector {
    private int x;
    private int y;

    public Acceleration(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int x() {
        return x;
    }

    @Override
    public int y() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public Direction getDirection() {
        return switch (Integer.signum(x) + 3 * Integer.signum(y)) {
            case 3 -> Direction.UP;
            case 4 -> Direction.UP_RIGHT;
            case -2 -> Direction.DOWN_RIGHT;
            case -3 -> Direction.DOWN;
            case -4 -> Direction.DOWN_LEFT;
            case -1 -> Direction.LEFT;
            case 2 -> Direction.UP_LEFT;
            case 1 -> Direction.RIGHT;
            case 0 -> Direction.MIDDLE;
            default -> throw new IllegalStateException("Cannot get direction");
        };
    }

    @Override
    public String toString() {
        return "[x= " + x + ", y=" + y + "]";
    }

}
