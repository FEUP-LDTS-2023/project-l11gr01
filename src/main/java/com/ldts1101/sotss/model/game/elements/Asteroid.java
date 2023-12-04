package com.ldts1101.sotss.model.game.elements;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.ldts1101.sotss.model.Position;

public class Asteroid extends Element {

    Asteroid(int x) {
        super( TextColor.ANSI.RED);
        setPosition(new Position(x,0));
        image = new BasicTextImage(1,1);
        TextGraphics graphics = image.newTextGraphics();
        graphics.setCharacter(1,1, new TextCharacter('^', TextColor.ANSI.YELLOW_BRIGHT, TextColor.ANSI.BLACK));
    }
}
