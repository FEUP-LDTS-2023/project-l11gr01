import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Token extends Element{
    public Token(Position position, TextColor backgroundColor) {
        super(TextColor.Factory.fromString("#999933"));
        image = new BasicTextImage(1,1);
        TextGraphics graphics = image.newTextGraphics();
        graphics.setCharacter(0,0, new TextCharacter('T',TextColor.ANSI.YELLOW_BRIGHT,backgroundColor));
        setPosition(position);
    }

}
