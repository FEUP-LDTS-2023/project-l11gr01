package com.ldts1101.sotss;
import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VenusTest {

    @Test
    void testVenus(){
        //Arrange
        Venus venus = new Venus();

        //Act
        String name = venus.name;
        TextColor backgroundColor = venus.backgroundColor;
        int tokenCount = venus.tokenCount;
        int asteroidCount = venus.asteroidCount;
        int asteroidMoveDelay = (int) venus.asteroidMoveDelay;

        //Assert
        Assertions.assertEquals("Venus",name);
        Assertions.assertEquals(TextColor.Factory.fromString("#CDCDCD"),backgroundColor);
        Assertions.assertEquals(6,tokenCount);
        Assertions.assertEquals(5,asteroidCount);
        Assertions.assertEquals(90,asteroidMoveDelay);

    }
}
