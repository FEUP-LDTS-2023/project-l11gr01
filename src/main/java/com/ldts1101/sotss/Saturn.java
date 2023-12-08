package com.ldts1101.sotss;

import com.googlecode.lanterna.TextColor;
import com.ldts1101.sotss.Planet;

public class Saturn extends Planet {
    public Saturn() {
        super(TextColor.Factory.fromString("#AE8B0C"), "Saturn", 8, 6,700, livesCount + 1);
        super.asteroidMoveDelay = 70;
    }
}
