package com.ldts1101.sotss;

import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TokenTest {
    @Test
    public void testToken(){
        Token token = new Token(new Position(10,10), TextColor.ANSI.YELLOW);

        assertEquals(10, token.getPositions().get(0).getX());
    }
}
