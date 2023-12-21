package com.ldts1101.sotss;
import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SaturnTest {

    @Test
    void testSaturn(){
        //Arrange
        Saturn saturn = new Saturn();

        //Act
        String name = saturn.name;
        TextColor backgroundColor = saturn.backgroundColor;
        int tokenCount = saturn.tokenCount;
        int asteroidCount = saturn.asteroidCount;
        int asteroidMoveDelay = (int) saturn.asteroidMoveDelay;

        //Assert
        Assertions.assertEquals("Saturn",name);
        Assertions.assertEquals(TextColor.Factory.fromString("#AE8B0C"),backgroundColor);
        Assertions.assertEquals(8,tokenCount);
        Assertions.assertEquals(7,asteroidCount);
        Assertions.assertEquals(70,asteroidMoveDelay);

    }
}
