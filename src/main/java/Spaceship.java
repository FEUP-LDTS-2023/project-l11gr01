import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Spaceship {
    private Position position;

    public Spaceship(Position position){
        this.position = position;
    }

    public Position getPosition(){
        return position;
    }

    public void setPosition(Position position){
        this.position = position;
    }

    public void draw(TextGraphics graphics){
        int x = position.getX();
        int y = position.getY();

        graphics.setForegroundColor(TextColor.Factory.fromString("#FF3333"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()),"S");
    }
}
