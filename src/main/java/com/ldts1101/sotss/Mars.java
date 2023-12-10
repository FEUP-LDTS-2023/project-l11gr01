package com.ldts1101.sotss;

import com.googlecode.lanterna.TextColor;
import com.ldts1101.sotss.Planet;

public class Mars extends Planet {
    public Mars(){
        super(TextColor.Factory.fromString("#E77D11"),"Mars",13,10,400, livesCount + 1);
        super.asteroidMoveDelay = 50;
    }
}
