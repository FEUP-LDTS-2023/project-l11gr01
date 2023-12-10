package com.ldts1101.sotss;
import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UranusTest {

    @Test
    void testUranus(){
        //Arrange
        Uranus uranus = new Uranus();

        //Act
        String name = uranus.name;
        TextColor backgroundColor = uranus.backgroundColor;
        int tokenCount = uranus.tokenCount;
        int asteroidCount = uranus.asteroidCount;
        int asteroidMoveDelay = (int) uranus.asteroidMoveDelay;

        //Assert
        Assertions.assertEquals("Uranus",name);
        Assertions.assertEquals(TextColor.Factory.fromString("#ADD8E6"),backgroundColor);
        Assertions.assertEquals(10,tokenCount);
        Assertions.assertEquals(9,asteroidCount);
        Assertions.assertEquals(60,asteroidMoveDelay);

    }
}
