package com.ldts1101.sotss;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Spaceship extends Element {

    protected static int lives;

    public Spaceship(TextColor backgroundColor){
        super();

        for (int x = 44; x <= 46; x++) {
            for (int y = 39; y <= 40; y++) {
                setPosition(new Position(x, y));
            }
        }
        image = new BasicTextImage(3,2);
        TextGraphics graphics = image.newTextGraphics();
        graphics.setCharacter(0, 0, new TextCharacter(' ', TextColor.ANSI.BLUE, backgroundColor));
        graphics.setCharacter(1, 0, new TextCharacter('^', TextColor.ANSI.BLUE, backgroundColor));
        graphics.setCharacter(2, 0, new TextCharacter(' ', TextColor.ANSI.BLUE, backgroundColor));
        graphics.setCharacter(0, 1, new TextCharacter('<', TextColor.ANSI.BLUE, backgroundColor));
        graphics.setCharacter(1, 1, new TextCharacter('^', TextColor.ANSI.BLUE, backgroundColor));
        graphics.setCharacter(2, 1, new TextCharacter('>', TextColor.ANSI.BLUE, backgroundColor));
    }


    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getLives() {return lives;}

    public void loseLife() {
        lives--;
    }

    public void addLife() {lives++;}

    public boolean died() {
        return lives == 0;
    }
}