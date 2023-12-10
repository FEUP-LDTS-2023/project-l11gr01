package com.ldts1101.sotss;

import com.googlecode.lanterna.TextColor;

public class Mars extends Planet {
    public Mars(){
        super(TextColor.Factory.fromString("#E77D11"),"Mars",12,10,400, livesCount);
        super.asteroidMoveDelay = 55;
    }
}
