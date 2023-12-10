package com.ldts1101.sotss;
import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MarsTest {

    @Test
    void testMars(){
        //Arrange
        Mars mars = new Mars();

        //Act
        String name = mars.name;
        TextColor backgroundColor = mars.backgroundColor;
        int tokenCount = mars.tokenCount;
        int asteroidCount = mars.asteroidCount;
        int asteroidMoveDelay = (int) mars.asteroidMoveDelay;

        //Assert
        Assertions.assertEquals("Mars",name);
        Assertions.assertEquals(TextColor.Factory.fromString("#E77D11"),backgroundColor);
        Assertions.assertEquals(13,tokenCount);
        Assertions.assertEquals(10,asteroidCount);
        Assertions.assertEquals(50,asteroidMoveDelay);

    }
}
