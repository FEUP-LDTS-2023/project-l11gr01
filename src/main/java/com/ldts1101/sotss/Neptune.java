package com.ldts1101.sotss;

import com.googlecode.lanterna.TextColor;
import com.ldts1101.sotss.Planet;

public class Neptune extends Planet {
    public Neptune(){
        super(TextColor.Factory.fromString("#4169E1"),"Neptune",9,7,600, livesCount + 1);
        super.asteroidMoveDelay = 65;
    }
}
