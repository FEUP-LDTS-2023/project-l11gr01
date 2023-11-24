import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Wall extends Element {
    Wall(int x, int y) {
        super(new Position(x,y), TextColor.ANSI.BLACK_BRIGHT);
        image = new BasicTextImage(1,1);
        TextGraphics graphics = image.newTextGraphics();
        graphics.setCharacter(0,0,Symbols.BLOCK_SOLID);
    }
}
