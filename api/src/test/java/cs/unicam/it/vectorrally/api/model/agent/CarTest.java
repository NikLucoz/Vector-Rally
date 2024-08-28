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
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void TestCarConstructor() {
        Car car = new BotCar(1, new Position(1,1), (char) 41);
        assertEquals((char) 41, car.getSymbol());
        assertEquals(new Position(1,1), car.getPosition());
        assertEquals( 1, car.getId());
    }

    @Test
    void TestGetId() {
        Car car = new BotCar(1, new Position(1,1), (char) 41);
        assertEquals(car.getSymbol(), (char) 41);
    }
    @Test
    void TestGetSymbol() {
        Car car = new BotCar(1, new Position(1,1), (char) 41);
        assertEquals((char) 41, car.getSymbol());
    }

    @Test
    void TestGetPosition() {
        Car car = new BotCar(1, new Position(1,1), (char) 41);
        assertEquals(new Position(1,1), car.getPosition());
    }

    @Test
    void TestSetPosition() {
        Car car = new BotCar(1, new Position(1,1), (char) 41);
        car.setPosition(new Position(2,2));
        assertEquals(new Position(2,2), car.getPosition());
    }

    @Test
    void TestSetAcceleration() {
        Car car = new BotCar(1, new Position(1,1), (char) 41);
        car.setAcceleration(new Acceleration(2,2));
        assertEquals(new Acceleration(2,2), car.getAcceleration());
    }

    @Test
    void TestGetAcceleration() {
        Car car = new BotCar(1, new Position(1,1), (char) 41);
        car.setAcceleration(new Acceleration(2,2));
        assertEquals(new Acceleration(2,2), car.getAcceleration());
    }

    @Test
    void TestIsInRace() {
        Car car = new BotCar(1, new Position(1,1), (char) 41);
        assertTrue(car.isInRace());
    }

    @Test
    void TestSetIsInRace() {
        Car car = new BotCar(1, new Position(1,1), (char) 41);
        car.setIsInRace(false);
        assertFalse(car.isInRace());
    }
}