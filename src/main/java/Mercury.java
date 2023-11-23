
import com.googlecode.lanterna.graphics.TextGraphics;

public class Mercury extends Planet {
    public Mercury(TextGraphics graphics){
        //Create Planet and start new Spaceship.
        super(graphics, "#FFFFFF", new Spaceship(45,20));
    }
}
