package com.ldts1101.sotss;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.ldts1101.sotss.Element;
import com.ldts1101.sotss.Position;

public class Asteroid extends Element {

    Asteroid(int x, int y) {
        super( TextColor.ANSI.RED);
        setPosition(new Position(x,y));
        image = new BasicTextImage(1,1);
        TextGraphics graphics = image.newTextGraphics();
        graphics.setCharacter(1,1, new TextCharacter('^', TextColor.ANSI.YELLOW_BRIGHT, TextColor.ANSI.BLACK));
    }
}
