package com.ldts1101.sotss;

import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpaceshipTest {

    @Test
    public void spaceshipsLives(){
        Spaceship spaceship = new Spaceship(TextColor.ANSI.WHITE);
        spaceship.setLives(3);

        int lives = spaceship.getLives();

        assertEquals(3,lives);
    }

    @Test
    public void addAndLoseLives(){
        Spaceship spaceship = new Spaceship(TextColor.ANSI.WHITE);
        spaceship.setLives(3);

        spaceship.addLife();
        spaceship.addLife();
        spaceship.addLife();
        spaceship.loseLife();

        int lives = spaceship.getLives();
        assertEquals(5,lives);
    }
}
