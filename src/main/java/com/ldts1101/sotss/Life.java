package com.ldts1101.sotss;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Life extends Element{
    public Life(Position position, TextColor backgroundColor) {
        super(TextColor.Factory.fromString("#999933"));
        image = new BasicTextImage(2,1);
        TextGraphics graphics = image.newTextGraphics();
        graphics.setCharacter(0,0, new TextCharacter('<', TextColor.Factory.fromString("#7C0000"), backgroundColor));
        graphics.setCharacter(1,0, new TextCharacter('3', TextColor.Factory.fromString("#7C0000"), backgroundColor));
        setPosition(position);
    }
}