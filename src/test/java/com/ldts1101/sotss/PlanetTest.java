package com.ldts1101.sotss;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SuppressWarnings({"DirectInvocationOnMock", "MockNotUsedInProduction"})
public class PlanetTest {
    private Planet planet;

    @BeforeEach
    public void setUp(){
        planet = new TestPlanet(TextColor.ANSI.BLACK, "TestPlanet", 1, 1, 100, 3);
    }


    @Test
    public void testSpaceshipDeath(){
        Spaceship spaceship = new Spaceship(TextColor.ANSI.WHITE);
        spaceship.setLives(0);

        assertTrue(spaceship.died());
    }

    @Test
    public void canSpaceshipMove(){
        Spaceship spaceship = new Spaceship(TextColor.ANSI.WHITE);
        Position spaceshipPosition = spaceship.getPositions().get(0);
        int x = spaceshipPosition.getX();
        int y = spaceshipPosition.getY();//44,39
        planet.walls.clear();
        Wall wallAbove = new Wall (x, y - 1);
        Wall wallBelow = new Wall (x,y + 3);
        Wall wallLeft = new Wall(x - 1,y);
        Wall wallRight = new Wall(x + 3,y);
        planet.walls.add(wallAbove);
        planet.walls.add(wallBelow);
        planet.walls.add(wallLeft);
        planet.walls.add(wallRight);

        System.out.println(x);
        System.out.println(y);
        assertFalse(planet.canSpaceShipMoveUp());
        assertFalse(planet.canSpaceShipMoveDown());
        assertFalse(planet.canSpaceShipMoveLeft());
        assertFalse(planet.canSpaceShipMoveRight());

    }

    @Test
    public void spaceshipCanMove(){
        //Feito para chegar ao return true de cada um
        Spaceship spaceship = new Spaceship(TextColor.ANSI.WHITE);
        Position spaceshipPosition = spaceship.getPositions().get(0);
        int x = spaceshipPosition.getX();
        int y = spaceshipPosition.getY();//44,39
        planet.walls.clear();
        Wall wallAbove = new Wall (x, y + 10);
        Wall wallBelow = new Wall (x,y - 13);
        Wall wallLeft = new Wall(x - 21,y);
        Wall wallRight = new Wall(x + 13,y);
        planet.walls.add(wallAbove);
        planet.walls.add(wallBelow);
        planet.walls.add(wallLeft);
        planet.walls.add(wallRight);

        System.out.println(x);
        System.out.println(y);
        assertTrue(planet.canSpaceShipMoveUp());
        assertTrue(planet.canSpaceShipMoveDown());
        assertTrue(planet.canSpaceShipMoveLeft());
        assertTrue(planet.canSpaceShipMoveRight());
    }

    @Test
    public void passLevel(){
        planet.tokenCount = 0;

        boolean levelPassed = planet.levelPassed();

        assertTrue(levelPassed);
    }

    private static class TestPlanet extends Planet {
        public TestPlanet(TextColor backgroundColor, String name, int tokenCount, int asteroidCount, long asteroidDelay, int livesCount) {
            super(backgroundColor, name, tokenCount, asteroidCount, asteroidDelay, livesCount);
        }

        @Override
        public boolean spaceshipDead() {
            return super.spaceshipDead();
        }
    }
}
