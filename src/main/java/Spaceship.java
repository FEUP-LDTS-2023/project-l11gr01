import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Spaceship extends Element {

    public Spaceship(){
        super(new Position(44,39),TextColor.ANSI.YELLOW_BRIGHT);
        image = new BasicTextImage(3, 3);
        TextGraphics graphics = image.newTextGraphics();
        graphics.setCharacter(1, 0, new TextCharacter('^', TextColor.ANSI.YELLOW_BRIGHT, TextColor.ANSI.BLACK));
        graphics.setCharacter(0, 1, new TextCharacter('<', TextColor.ANSI.YELLOW_BRIGHT, TextColor.ANSI.BLACK));
        graphics.setCharacter(1, 1, new TextCharacter('^', TextColor.ANSI.YELLOW_BRIGHT, TextColor.ANSI.BLACK));
        graphics.setCharacter(2, 1, new TextCharacter('>', TextColor.ANSI.YELLOW_BRIGHT, TextColor.ANSI.BLACK));
    }
}