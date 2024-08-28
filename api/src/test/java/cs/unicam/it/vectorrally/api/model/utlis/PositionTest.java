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

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for the Position class.
 *
 * @version 1.0
 * @since 2024-08-15
 */
public class PositionTest {

    @Test
    public void testConstructorAndGetters() {
        Position position = new Position(5, -3);
        assertEquals(5, position.x());
        assertEquals(-3, position.y());
    }

    @Test
    public void testGetNextPositionWithPositiveAcceleration() {
        Position position = new Position(10, 20);
        Acceleration acceleration = new Acceleration(3, 4);
        Position nextPosition = position.getNextPosition(acceleration);
        assertEquals(13, nextPosition.x());
        assertEquals(24, nextPosition.y());
    }

    @Test
    public void testGetNextPositionWithNegativeAcceleration() {
        Position position = new Position(10, 20);
        Acceleration acceleration = new Acceleration(-3, -4);
        Position nextPosition = position.getNextPosition(acceleration);
        assertEquals(7, nextPosition.x());
        assertEquals(16, nextPosition.y());
    }

    @Test
    public void testGetNextPositionWithZeroAcceleration() {
        Position position = new Position(10, 20);
        Acceleration acceleration = new Acceleration(0, 0);
        Position nextPosition = position.getNextPosition(acceleration);
        assertEquals(10, nextPosition.x());
        assertEquals(20, nextPosition.y());
    }

    @Test
    public void testToString() {
        Position position = new Position(7, 14);
        assertEquals("Position [x=7, y=14]", position.toString());
    }
}