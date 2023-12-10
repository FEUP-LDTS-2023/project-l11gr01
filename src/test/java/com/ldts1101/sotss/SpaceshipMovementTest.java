package com.ldts1101.sotss;
/*
import com.googlecode.lanterna.TextColor;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SpaceshipMovementTest {

    private Planet planet;

    @Before
    public void setUp() {
        planet = mock(Planet.class);
    }

    @Test
    public void testCanSpaceShipMoveUp() {
        when(planet.walls).thenReturn(someListOfWalls());
        when(planet.spaceship).thenReturn(someSpaceshipInstance());

        assertFalse("Spaceship can move up!", planet.canSpaceShipMoveUp());
    }

    @Test
    public void testCanSpaceShipMoveDown() {
        when(planet.walls).thenReturn(someListOfWalls());
        when(planet.spaceship).thenReturn(someSpaceshipInstance());

        assertEquals(true, planet.canSpaceShipMoveDown());
    }

    @Test
    public void testCanSpaceShipMoveLeft() {
        when(planet.walls).thenReturn(someListOfWalls());
        when(planet.spaceship).thenReturn(someSpaceshipInstance());

        assertEquals(true, planet.canSpaceShipMoveLeft());
    }

    @Test
    public void testCanSpaceShipMoveRight() {
        when(planet.walls).thenReturn(someListOfWalls());
        when(planet.spaceship).thenReturn(someSpaceshipInstance());

        assertEquals(true, planet.canSpaceShipMoveRight());
    }

    private List<Wall> someListOfWalls() {
        // Create and return a list of walls for testing
        return Arrays.asList(new Wall(5, 6), new Wall(7, 8));
    }

    private Spaceship someSpaceshipInstance() {
        // Create and return a spaceship instance for testing
        return new Spaceship(TextColor.ANSI.YELLOW_BRIGHT);
    }
}



/*import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.TerminalScreen;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.io.IOException;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class com.ldts1101.sotss.SpaceshipMovementTest {

    @Test
    public void testSpaceshipMoveUp() throws IOException {
        com.ldts1101.sotss.Planet planetMock = mock(com.ldts1101.sotss.Planet.class);
        TerminalScreen screenMock = mock(TerminalScreen.class);

        Spaceship spaceship = new Spaceship(TextColor.ANSI.YELLOW_BRIGHT);
        planetMock.spaceship = spaceship;



        planetMock.processKey(new KeyStroke(KeyType.ArrowUp));

        ArgumentCaptor<TextGraphics> graphicsCaptor = ArgumentCaptor.forClass(TextGraphics.class);
        verify(spaceship).draw(graphicsCaptor.capture());

        TextGraphics capturedGraphics = graphicsCaptor.getValue();
        assertEquals("Spaceship moved up", spaceship.getPositions().get(0).getY() == 1);
    }

    @Test
    public void testSpaceshipMoveUp2() throws IOException {
        com.ldts1101.sotss.Planet planetMock = mock(com.ldts1101.sotss.Planet.class);
        TerminalScreen screenMock = mock(TerminalScreen.class);

        Spaceship spaceship = new Spaceship(TextColor.ANSI.DEFAULT);
        planetMock.spaceship = spaceship;
        planetMock.walls.add(new Wall(2, 1));

        planetMock.processKey(new KeyStroke(KeyType.ArrowUp));

        ArgumentCaptor<TextGraphics> graphicsCaptor = ArgumentCaptor.forClass(TextGraphics.class);
        verify(spaceship).draw(graphicsCaptor.capture());

        TextGraphics capturedGraphics = graphicsCaptor.getValue();
        assertTrue("Spaceship didn't move up", spaceship.getPositions().get(0).getY() == 0);
    }

    // Similar tests for moveDown, moveLeft, moveRight
}
*/

