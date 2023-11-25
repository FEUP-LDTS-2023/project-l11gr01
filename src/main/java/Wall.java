import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Wall extends Element {
    Wall(int x, int y) {
        super( TextColor.ANSI.BLACK_BRIGHT);
        setPosition(new Position(x,y));
        image = new BasicTextImage(1,1);
        TextGraphics graphics = image.newTextGraphics();
        graphics.setCharacter(0,0,Symbols.BLOCK_SOLID);
    }
}
