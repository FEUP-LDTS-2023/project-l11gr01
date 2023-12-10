package com.ldts1101.sotss;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AsteroidTest {

    @Test
    void testAsteroidMoveDown() {
        // Arrange
        Asteroid asteroid = new Asteroid(5);

        // Act
        asteroid.moveDown();

        // Assert
        Assertions.assertEquals(4, asteroid.getPositions().get(0).getY());
    }

    @Test
    void testAsteroidCollides() {
        // Arrange
        Asteroid asteroid = new Asteroid(5);

        // Act
        asteroid.collides();

        // Assert
        Assertions.assertTrue(asteroid.collided());
    }

}
