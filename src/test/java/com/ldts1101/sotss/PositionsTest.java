package com.ldts1101.sotss;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositionsTest {

    @Test
    void testPosition1(){
        Position position = new Position(10, 20);
        assertEquals(10, position.getX());
        assertEquals(20, position.getY());
    }

    @Test
    void testPosition2(){
        Position position = new Position(1, 1);
        assertEquals(1, position.getX());
        assertEquals(1, position.getY());
    }

    @Test
    void testPosition3(){
        Position position = new Position(33, 22);
        assertEquals(33, position.getX());
        assertEquals(22, position.getY());
    }

    @Test
    void testPosition4(){
        Position position = new Position(89, 44);
        assertEquals(89, position.getX());
        assertEquals(44, position.getY());
    }

    @Test
    void testPositionSet1(){
        Position position = new Position(14, 21);
        assertEquals(14, position.getX());
        assertEquals(21, position.getY());
        position.setX(38);
        position.setY(12);
        assertEquals(38, position.getX());
        assertEquals(12, position.getY());
    }

    @Test
    void testPositionSet2(){
        Position position = new Position(89, 44);
        assertEquals(89, position.getX());
        assertEquals(44, position.getY());
        position.setX(0);
        position.setY(0);
        assertEquals(0, position.getX());
        assertEquals(0, position.getY());
    }
}
