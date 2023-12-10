package com.ldts1101.sotss;
import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NeptuneTest {

    @Test
    void testNeptune(){
        //Arrange
        Neptune neptune = new Neptune();

        //Act
        String name = neptune.name;
        TextColor backgroundColor = neptune.backgroundColor;
        int tokenCount = neptune.tokenCount;
        int asteroidCount = neptune.asteroidCount;
        int asteroidMoveDelay = (int) neptune.asteroidMoveDelay;

        //Assert
        Assertions.assertEquals("Neptune",name);
        Assertions.assertEquals(TextColor.Factory.fromString("#4169E1"),backgroundColor);
        Assertions.assertEquals(9,tokenCount);
        Assertions.assertEquals(7,asteroidCount);
        Assertions.assertEquals(65,asteroidMoveDelay);

    }
}
