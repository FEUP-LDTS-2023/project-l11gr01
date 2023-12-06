package com.ldts1101.sotss;

import com.googlecode.lanterna.TextColor;
import com.ldts1101.sotss.Planet;

public class Mars extends Planet {
    public Mars(){
        super(TextColor.Factory.fromString("#F06100"),"Mars",5,3, livesCount + 1);
    }
}
