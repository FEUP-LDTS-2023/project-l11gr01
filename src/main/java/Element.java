import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextImage;



public abstract class Element {

    //Member fields
    protected Position position;
    protected TextColor color;
    protected TextImage image;

    //Constructors
    Element(Position position, TextColor color) {
        this.position = position;
        this.color = color;
    }

    public int getX() {return position.getX();}

    public int getY() {return position.getY();}

    public Position getPosition(){
        return position;
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

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(color);
        graphics.enableModifiers(SGR.BOLD);
        graphics.drawImage(new TerminalPosition(position.getX(), position.getY()),image);
    };
}
