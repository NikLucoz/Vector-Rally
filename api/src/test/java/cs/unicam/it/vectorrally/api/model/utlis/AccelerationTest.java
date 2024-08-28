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

class AccelerationTest {
    @Test
    public void testConstructorAndGetters() {
        Acceleration acceleration = new Acceleration(5, -3);
        assertEquals(5, acceleration.x());
        assertEquals(-3, acceleration.y());
    }

    @Test
    public void testSetters() {
        Acceleration acceleration = new Acceleration(0, 0);
        acceleration.setX(7);
        acceleration.setY(-2);
        assertEquals(7, acceleration.x());
        assertEquals(-2, acceleration.y());
    }

    @Test
    public void testToString() {
        Acceleration acceleration = new Acceleration(3, 4);
        assertEquals("[x= 3, y=4]", acceleration.toString());
    }

}