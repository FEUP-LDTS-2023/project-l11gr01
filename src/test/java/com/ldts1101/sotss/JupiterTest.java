package com.ldts1101.sotss;
import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JupiterTest {

    @Test
    void testJupiter(){
        //Arrange
        Jupiter jupiter = new Jupiter();

        //Act
        String name = jupiter.name;
        TextColor backgroundColor = jupiter.backgroundColor;
        int tokenCount = jupiter.tokenCount;
        int asteroidCount = jupiter.asteroidCount;
        int asteroidMoveDelay = (int) jupiter.asteroidMoveDelay;

        //Assert
        Assertions.assertEquals("Jupiter",name);
        Assertions.assertEquals(TextColor.Factory.fromString("#D2B59A"),backgroundColor);
        Assertions.assertEquals(7,tokenCount);
        Assertions.assertEquals(5,asteroidCount);
        Assertions.assertEquals(80,asteroidMoveDelay);

    }
}
