package com.ldts1101.sotss;

import com.googlecode.lanterna.TextColor;

public class Neptune extends Planet {
    public Neptune(){
        super(TextColor.Factory.fromString("#4169E1"),"Neptune",9,7,600, livesCount);
        super.asteroidMoveDelay = 65;
        super.livesCount = livesCount + 1;
    }
}
