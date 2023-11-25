import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Spaceship extends Element {

    public Spaceship(TextColor backgroundColor){
        super(TextColor.ANSI.YELLOW_BRIGHT);

        for (int x =44; x <= 46; x++) {
            for (int y = 39; y <= 41; y++) {
                setPosition(new Position(x,y));
            }
        }
        image = new BasicTextImage(3,2);
        TextGraphics graphics = image.newTextGraphics();
        graphics.setCharacter(0, 0, new TextCharacter(' ', TextColor.ANSI.YELLOW_BRIGHT, backgroundColor));
        graphics.setCharacter(1, 0, new TextCharacter('^', TextColor.ANSI.YELLOW_BRIGHT, backgroundColor));
        graphics.setCharacter(2, 0, new TextCharacter(' ', TextColor.ANSI.YELLOW_BRIGHT, backgroundColor));
        graphics.setCharacter(0, 1, new TextCharacter('<', TextColor.ANSI.YELLOW_BRIGHT, backgroundColor));
        graphics.setCharacter(1, 1, new TextCharacter('^', TextColor.ANSI.YELLOW_BRIGHT, backgroundColor));
        graphics.setCharacter(2, 1, new TextCharacter('>', TextColor.ANSI.YELLOW_BRIGHT, backgroundColor));
    }
}