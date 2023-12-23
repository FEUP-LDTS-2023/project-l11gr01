package com.ldts1101.sotss;

import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LifeTokenTest {
    @Test
    public void lifeTokenTest(){
        LifeToken lifeToken = new LifeToken(new Position(10,10), TextColor.ANSI.RED);

        assertEquals(10, lifeToken.getPositions().get(0).getX());
    }
}
