package com.ldts1101.sotss;

import com.googlecode.lanterna.TextColor;

public class Earth extends Planet {
    public Earth(){
        super(TextColor.Factory.fromString("#088F8F"),"Earth",13,11, 300, livesCount);
        super.asteroidMoveDelay = 50;
    }
}
