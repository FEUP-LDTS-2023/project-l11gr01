package com.ldts1101.sotss;

import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Wall extends Element {
    Wall(int x, int y) {
        super();
        setPosition(new Position(x,y));
        image = new BasicTextImage(1,1);
        TextGraphics graphics = image.newTextGraphics();
        graphics.setCharacter(0,0,Symbols.BLOCK_SOLID);
    }
}
