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

package cs.unicam.it.vectorrally.api.model.track;

import cs.unicam.it.vectorrally.api.model.agent.Agent;
import cs.unicam.it.vectorrally.api.model.agent.BotCar;
import cs.unicam.it.vectorrally.api.model.utlis.Position;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RaceTrackTest {

    @Test
    void testRaceTrack() {
        TrackTile[][] track = new TrackTile[2][2];
        RaceTrack raceTrack = new RaceTrack(track);

        assertNotNull(raceTrack);
        assertEquals(track, raceTrack.getTrack());
        assertEquals(track.length, raceTrack.getHeight());
        assertEquals(track[0].length, raceTrack.getWidth());
    }

    @Test
    void testGetTrack() {
        TrackTile[][] track = new TrackTile[2][2];
        RaceTrack raceTrack = new RaceTrack(track);
        assertEquals(track, raceTrack.getTrack());
    }

    @Test
    void testGetHeight() {
        TrackTile[][] track = new TrackTile[2][2];
        RaceTrack raceTrack = new RaceTrack(track);
        assertEquals(track.length, raceTrack.getHeight());
    }

    @Test
    void testGetWidth() {
        TrackTile[][] track = new TrackTile[2][2];
        RaceTrack raceTrack = new RaceTrack(track);
        assertEquals(track.length, raceTrack.getWidth());
    }

    @Test
    void TestGetTrackTileAt() {
        TrackTile[][] track = new TrackTile[][] {
                { TrackTile.FINISH, TrackTile.ROAD },
                { TrackTile.ROAD, TrackTile.ROAD }
        };

        RaceTrack raceTrack = new RaceTrack(track);
        assertEquals(TrackTile.FINISH, raceTrack.getTrackTileAt(0,0));
    }

    @Test
    void TestIsAgentOutOfTrack() {
        TrackTile[][] track = new TrackTile[2][2];
        RaceTrack raceTrack = new RaceTrack(track);
        BotCar car = new BotCar(1, new Position(-12, -12), (char) 41);
        assertTrue(raceTrack.isAgentOutOfTrack(car));
    }

    @Test
    void TestIsAgentOnFinishLine() {
        TrackTile[][] track = new TrackTile[][] {
                { TrackTile.FINISH, TrackTile.ROAD },
                { TrackTile.ROAD, TrackTile.ROAD }
        };
        RaceTrack raceTrack = new RaceTrack(track);
        BotCar car = new BotCar(1, new Position(0, 0), (char) 41);
        assertTrue(raceTrack.isAgentOnFinishLine(car));
    }

    @Test
    void TestAddAgents() {
        TrackTile[][] track = new TrackTile[][] {
                { TrackTile.START, TrackTile.ROAD },
                { TrackTile.ROAD, TrackTile.ROAD }
        };
        RaceTrack raceTrack = new RaceTrack(track);

        BotCar car = new BotCar(1, new Position(0, 0), (char) 41);
        Agent[] agents = new Agent[1];
        agents[0] = car;

        ArrayList<Position> startingTilesPositions =  raceTrack.getStartingLine();

        raceTrack.addAgents(agents);

        assertTrue(startingTilesPositions.contains(car.getPosition()));
    }

    @Test
    void TestGetStratingLine() {
        TrackTile[][] track = new TrackTile[][] {
                { TrackTile.START, TrackTile.ROAD },
                { TrackTile.ROAD, TrackTile.ROAD }
        };
        RaceTrack raceTrack = new RaceTrack(track);
        ArrayList<Position> pos = new ArrayList<Position>();
        pos.add(new Position(0, 0));
        assertEquals(pos, raceTrack.getStartingLine());
    }

    @Test
    void TestGetFinishLine() {
        TrackTile[][] track = new TrackTile[][] {
                { TrackTile.FINISH, TrackTile.ROAD },
                { TrackTile.ROAD, TrackTile.ROAD }
        };
        RaceTrack raceTrack = new RaceTrack(track);
        ArrayList<Position> pos = new ArrayList<Position>();
        pos.add(new Position(0, 0));

        assertEquals(pos, raceTrack.getFinishLine());
    }
}