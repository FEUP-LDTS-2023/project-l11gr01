import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Asteroid extends Element{

    Asteroid(int x) {
        super(new Position(x,0), TextColor.ANSI.RED);
        image = new BasicTextImage(1,1);
        TextGraphics graphics = image.newTextGraphics();
        graphics.setCharacter(1,1, new TextCharacter('^', TextColor.ANSI.YELLOW_BRIGHT, TextColor.ANSI.BLACK));
    }
}
