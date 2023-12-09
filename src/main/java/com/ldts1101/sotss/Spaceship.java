package com.ldts1101.sotss;

import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Spaceship extends Element {
    protected static int livesCount;

    public Spaceship(TextColor backgroundColor){
        super();

        for (int x = 44; x <= 46; x++) {
            for (int y = 39; y <= 41; y++) {
                setPosition(new Position(x, y));
            }
        }
        image = new BasicTextImage(3,3);
        TextGraphics graphics = image.newTextGraphics();
        graphics.setCharacter(0, 0, new TextCharacter(' ', TextColor.ANSI.BLUE, backgroundColor));
        graphics.setCharacter(1, 0, new TextCharacter(Symbols.TRIANGLE_UP_POINTING_BLACK, TextColor.ANSI.BLUE, backgroundColor));
        graphics.setCharacter(2, 0, new TextCharacter(' ', TextColor.ANSI.BLUE, backgroundColor));
        graphics.setCharacter(0, 1, new TextCharacter(Symbols.TRIANGLE_RIGHT_POINTING_MEDIUM_BLACK, TextColor.ANSI.BLUE, backgroundColor));
        graphics.setCharacter(1, 1, new TextCharacter(Symbols.BLOCK_SOLID, TextColor.ANSI.BLUE, backgroundColor));
        graphics.setCharacter(2, 1, new TextCharacter(Symbols.TRIANGLE_LEFT_POINTING_MEDIUM_BLACK, TextColor.ANSI.BLUE, backgroundColor));
        graphics.setCharacter(0, 2, new TextCharacter(' ', TextColor.ANSI.BLUE, backgroundColor));
        graphics.setCharacter(1, 2, new TextCharacter(Symbols.TRIANGLE_UP_POINTING_MEDIUM_BLACK, TextColor.ANSI.RED, backgroundColor));
        graphics.setCharacter(2, 2, new TextCharacter(' ', TextColor.ANSI.BLUE, backgroundColor));
    }



    public void setLives(int livesCount) {
        this.livesCount = livesCount;
    }

    public int getLives() {return livesCount;}

    public void loseLife() {
        livesCount--;
    }

    public void addLife() {livesCount++;}

    public boolean died() {
        return livesCount == 0;
    }
}