package com.ldts1101.sotss;

import com.googlecode.lanterna.TextColor;

public class Mercury extends Planet {
    public Mercury(){
        super(TextColor.Factory.fromString("#536872"),"Mercury",5,4,1000, livesCount);
        super.asteroidMoveDelay = 100;
    }

}
