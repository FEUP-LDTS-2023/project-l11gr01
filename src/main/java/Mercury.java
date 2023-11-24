import com.googlecode.lanterna.TextColor;

import java.util.Random;

public class Mercury extends Planet {
    public Mercury(){
        super(TextColor.Factory.fromString("#353432"),"Mercury");
        spawnTokens(5);
    }


}
