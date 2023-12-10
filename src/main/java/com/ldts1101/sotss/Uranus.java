package com.ldts1101.sotss;

import com.googlecode.lanterna.TextColor;

public class Uranus extends Planet {
    public Uranus(){
        super(TextColor.Factory.fromString("#ADD8E6"),"Uranus",11,9,500, livesCount);
        super.asteroidMoveDelay = 60;
    }
}
