package com.ldts1101.sotss;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AsteroidMockTest {
    @Test
    void testAsteroidMoveDownWithMockito() {
        // Arrange
        Asteroid asteroid = Mockito.spy(new Asteroid(5));

        // Act
        asteroid.moveDown();

        // Assert
        Mockito.verify(asteroid, Mockito.times(1)).moveDown(); // Verifying that the moveDown method was called
        assertEquals(4, asteroid.getPositions().get(0).getY());
    }

    @Test
    void testAsteroidCollidesWithMockito() {
        // Arrange
        Asteroid asteroid = Mockito.spy(new Asteroid(5));

        // Act
        asteroid.collides();

        // Assert
        Mockito.verify(asteroid, Mockito.times(1)).collides(); // Verifying that the collides method was called
        assertTrue(asteroid.collided());
    }
}