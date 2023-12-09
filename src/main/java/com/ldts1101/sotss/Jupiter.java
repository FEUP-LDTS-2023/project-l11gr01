package com.ldts1101.sotss;

import com.googlecode.lanterna.TextColor;

public class Jupiter extends Planet {
    public Jupiter(){
        super(TextColor.Factory.fromString("#D2B59A"),"Jupiter",7,5, 800, livesCount);
        super.asteroidMoveDelay = 80;
        super.livesCount = livesCount + 1;
    }
}
