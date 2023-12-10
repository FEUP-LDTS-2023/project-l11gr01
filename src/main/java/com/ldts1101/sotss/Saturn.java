package com.ldts1101.sotss;

import com.googlecode.lanterna.TextColor;

public class Saturn extends Planet {
    public Saturn() {
        super(TextColor.Factory.fromString("#AE8B0C"), "Saturn", 8, 7,700, livesCount);
        super.asteroidMoveDelay = 70;
    }
}
