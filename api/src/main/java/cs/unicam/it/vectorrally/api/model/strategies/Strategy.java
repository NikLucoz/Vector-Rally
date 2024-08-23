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

public enum Strategy {
    SIMPLE(0);

    private final int value;

    Strategy(int value) {
        this.value = value;
    }

    /**
     * Returns the Strategy value
     * @return the value associated to the strategy
     */
    public int getValue() {
        return value;
    }

    /**
     * Returns the {@link Strategy} corresponding to the specified integer value.
     * <p>
     * This method iterates through all the available {@link Strategy} enum values
     * and returns the one that matches the provided integer value. If no matching
     * strategy is found, an {@link IllegalArgumentException} is thrown.
     * </p>
     *
     * @param value the integer value representing a specific {@link Strategy}
     * @return the {@link Strategy} corresponding to the specified value
     * @throws IllegalArgumentException if no {@link Strategy} with the specified
     * value exists
     */
    public static Strategy fromValue(int value) {
        for (Strategy strategy : Strategy.values()) {
            if (strategy.getValue() == value) {
                return strategy;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value);
    }

}
