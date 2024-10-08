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
 * Represents a position in a 2D space with x and y coordinates.
 *
 * @param x the x-coordinate of the position.
 * @param y the y-coordinate of the position.
 * @version 1.0
 * @since 2024-08-15
 * @author Niccolò Lucozzi
 **/
public record Position(int x, int y) implements Vector {

    /**
     * Calculates the next position based on the given acceleration.
     *
     * @param acceleration the {@link Acceleration} to apply to the current position.
     * @return a new {@link Position} representing the next position after applying the acceleration.
     */
    public Position getNextPosition(Acceleration acceleration) {
        return new Position(
                x + acceleration.x(),
                y + acceleration.y()
        );
    }

    /**
     * Returns a string representation of the position, displaying the x and y coordinates.
     *
     * @return a string in the format "Position [x=x, y=y]".
     */
    @Override
    public String toString() {
        return "Position [x=" + x + ", y=" + y + "]";
    }
}
