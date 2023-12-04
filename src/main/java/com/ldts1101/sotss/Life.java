package com.ldts1101.sotss;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Life extends Element{
    public Life(Position position, TextColor backgroundColor) {
        super(TextColor.Factory.fromString("#FF0000"));
        image = new BasicTextImage(1,1);
        TextGraphics graphics = image.newTextGraphics();
        graphics.setCharacter(0,0, new TextCharacter('<', TextColor.ANSI.RED, backgroundColor));
        graphics.setCharacter(1,0, new TextCharacter('3', TextColor.ANSI.RED, backgroundColor));
        setPosition(position);
    }
}
