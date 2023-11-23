import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Spaceship extends Element {

    public Spaceship(int x, int y){
        super(x, y);
    }

    @Override
    public void draw(TextGraphics graphics, String character) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF00"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), character);
    }

    public void moveUp(){
        position.setY(position.getY() - 1);
    }
    public void moveDown(){
        position.setY(position.getY() + 1);
    }
    public void moveLeft(){
        position.setX(position.getX() - 1);
    }
    public void moveRight(){
        position.setX(position.getX() + 1);
    }
}
