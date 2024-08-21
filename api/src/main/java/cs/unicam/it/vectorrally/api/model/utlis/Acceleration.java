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
/**
 * Represents acceleration in a 2D space with x and y components. Implements the {@link Vector} interface.
 *
 * @version 1.0
 * @since 2024-08-15
 * @author Niccolò Lucozzi
 **/
public class Acceleration implements Vector {
    private int x;
    private int y;

    /**
     * Constructs an {@code Acceleration} object with the specified x and y components.
     *
     * @param x the x-component of the acceleration.
     * @param y the y-component of the acceleration.
     */
    public Acceleration(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Retrieves the x-component of the acceleration.
     *
     * @return the x-component of the acceleration.
     */
    @Override
    public int x() {
        return x;
    }

    /**
     * Retrieves the y-component of the acceleration.
     *
     * @return the y-component of the acceleration.
     */
    @Override
    public int y() {
        return y;
    }

    /**
     * Sets the x-component of the acceleration.
     *
     * @param x the new x-component of the acceleration.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Sets the y-component of the acceleration.
     *
     * @param y the new y-component of the acceleration.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Determines the direction of the acceleration based on the x and y components.
     *
     * @return the {@link Direction} corresponding to the acceleration vector.
     * @throws IllegalStateException if the direction cannot be determined.
     */
    @Override
    public Direction getDirection() {
        int xSign = Integer.signum(x);
        int ySign = Integer.signum(y);

        // Determina la direzione basata sui segni di x e y
        return switch (xSign * 10 + ySign) {
            case 10 -> Direction.UP;
            case 11 -> Direction.UP_RIGHT;
            case 0 -> Direction.RIGHT;
            case -10 -> Direction.DOWN;
            case -11 -> Direction.DOWN_LEFT;
            case -1 -> Direction.LEFT;
            case 1 -> Direction.UP_LEFT;
            case -9 -> Direction.DOWN_RIGHT;
            default -> Direction.MIDDLE;  // Gestisce il caso in cui x == 0 e y == 0
        };
    }

    /**
     * Returns a string representation of the acceleration, displaying the x and y components.
     *
     * @return a string in the format "[x= x, y=y]".
     */
    @Override
    public String toString() {
        return "[x= " + x + ", y=" + y + "]";
    }
}
