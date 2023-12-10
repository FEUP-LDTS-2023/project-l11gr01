package com.ldts1101.sotss;

import com.googlecode.lanterna.TextColor;

public class Venus extends Planet {
    public Venus(){
        super(TextColor.Factory.fromString("#CDCDCD"),"Venus",6,5, 900, livesCount);
        super.asteroidMoveDelay = 90;
    }
}
