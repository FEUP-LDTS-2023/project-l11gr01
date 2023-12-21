package com.ldts1101.sotss;
import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class EarthTest {

    @Test
    void testEarth(){
        //Arrange
        Earth earth = new Earth();

        //Act
        String name = earth.name;
        TextColor backgroundColor = earth.backgroundColor;
        int tokenCount = earth.tokenCount;
        int asteroidCount = earth.asteroidCount;
        int asteroidMoveDelay = (int) earth.asteroidMoveDelay;

        //Assert
        Assertions.assertEquals("Earth",name);
        Assertions.assertEquals(TextColor.Factory.fromString("#088F8F"),backgroundColor);
        Assertions.assertEquals(15,tokenCount);
        Assertions.assertEquals(11,asteroidCount);
        Assertions.assertEquals(45,asteroidMoveDelay);

    }
}
