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

/**
 * A functional interface representing a factory for creating instances of
 * {@link MovementStrategy}.
 * <p>
 * Implementations of this interface are responsible for instantiating specific
 * types of {@link MovementStrategy} objects. This interface is typically used
 * in conjunction with a {@code Map} that associates a {@link Strategy} enum value
 * with the corresponding factory, allowing for flexible and dynamic creation
 * of different movement strategies.
 * </p>
 *
 * <h2>Example Usage</h2>
 * <pre>
 * {@code
 * Map<Strategy, MovementStrategyFactory> strategyFactories = new HashMap<>();
 * strategyFactories.put(Strategy.SIMPLE, SimpleMovementStrategy::new);
 * strategyFactories.put(Strategy.MEDIUM, () -> new MediumMovementStrategy(track));
 *
 * MovementStrategy strategy = strategyFactories.get(Strategy.SIMPLE).create();
 * }
 * </pre>
 *
 * @see MovementStrategy
 * @see Strategy
 */

public interface MovementStrategyFactory {

    /**
     * Creates a new instance of a {@link MovementStrategy}.
     * <p>
     * Implementations of this method should return a fully constructed instance
     * of a specific {@link MovementStrategy} implementation. This method is typically
     * used to abstract away the creation logic from the client code, allowing for
     * flexibility in how movement strategies are instantiated.
     * </p>
     *
     * @return a new instance of a {@link MovementStrategy}
     */
    MovementStrategy create();
}
