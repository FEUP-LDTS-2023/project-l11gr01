package com.ldts1101.sotss;
import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MercuryTest {

    @Test
    void testMercury(){
        //Arrange
        Mercury mercury = new Mercury();

        //Act
        String name = mercury.name;
        TextColor backgroundColor = mercury.backgroundColor;
        int tokenCount = mercury.tokenCount;
        int asteroidCount = mercury.asteroidCount;
        int asteroidMoveDelay = (int) mercury.asteroidMoveDelay;

        //Assert
        Assertions.assertEquals("Mercury",name);
        Assertions.assertEquals(TextColor.Factory.fromString("#536872"),backgroundColor);
        Assertions.assertEquals(5,tokenCount);
        Assertions.assertEquals(3,asteroidCount);
        Assertions.assertEquals(100,asteroidMoveDelay);

    }
}
