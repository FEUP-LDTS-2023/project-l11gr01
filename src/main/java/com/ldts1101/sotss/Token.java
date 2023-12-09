package com.ldts1101.sotss;

import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Token extends Element {
    public Token(Position position, TextColor backgroundColor) {
        super();
        image = new BasicTextImage(1,1);
        TextGraphics graphics = image.newTextGraphics();
        graphics.setCharacter(0,0, new TextCharacter(Symbols.DIAMOND ,TextColor.ANSI.YELLOW_BRIGHT, backgroundColor));
        setPosition(position);
    }

}
