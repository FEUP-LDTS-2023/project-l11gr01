package com.ldts1101.sotss;

import com.googlecode.lanterna.TextColor;
import com.ldts1101.sotss.Planet;

public class Venus extends Planet {
    public Venus(){
        super(TextColor.Factory.fromString("#CDCDCD"),"Venus",6,4, 900, livesCount + 1);
    }
}
