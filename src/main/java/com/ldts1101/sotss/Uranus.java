package com.ldts1101.sotss;

import com.googlecode.lanterna.TextColor;

public class Uranus extends Planet {
    public Uranus(){
        super(TextColor.Factory.fromString("#ADD8E6"),"Uranus",10,8,500, livesCount);
        super.asteroidMoveDelay = 60;
        super.livesCount = livesCount + 1;
    }
}
