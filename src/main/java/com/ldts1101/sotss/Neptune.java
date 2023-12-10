package com.ldts1101.sotss;

import com.googlecode.lanterna.TextColor;

public class Neptune extends Planet {
    public Neptune(){
        super(TextColor.Factory.fromString("#4169E1"),"Neptune",10,8,600, livesCount);
        super.asteroidMoveDelay = 65;
    }
}
