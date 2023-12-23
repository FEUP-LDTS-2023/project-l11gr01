package com.ldts1101.sotss;

import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElementTest {

    @Test
    public void movingTest(){
        Spaceship spaceship = new Spaceship(TextColor.ANSI.WHITE);
        spaceship.positions.clear();
        spaceship.setPosition(new Position(10,10));

        spaceship.moveUp();
        spaceship.moveLeft();
        Position finalPosition = new Position (9,9);
        assertEquals(finalPosition,spaceship.getPositions().get(0));
    }

    @Test
    public void movingTest2() {
        Spaceship spaceship = new Spaceship(TextColor.ANSI.WHITE);
        spaceship.positions.clear();
        spaceship.setPosition(new Position(10, 10));

        spaceship.moveDown();
        spaceship.moveRight();
        Position finalPosition = new Position(11, 11);
        assertEquals(finalPosition, spaceship.getPositions().get(0));
    }
}
