package com.ldts1101.sotss;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.ldts1101.sotss.Element;
import com.ldts1101.sotss.Position;

public class Asteroid extends Element {

    boolean colided = false;

    Asteroid(int x) {
        super();
        setPosition(new Position(x,0));
        image = new BasicTextImage(1,1);
        TextGraphics graphics = image.newTextGraphics();
        graphics.setCharacter(1,1, new TextCharacter('^', TextColor.ANSI.YELLOW_BRIGHT, TextColor.ANSI.BLACK));
    }

    public boolean colided() {return colided;}

    public void colides() {colided = true;}
}
