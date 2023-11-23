import com.googlecode.lanterna.graphics.TextGraphics;


public abstract class Element {

    //Member fields
    protected Position position;

    //Constructors
    Element(int x, int y) {
        this.position = new Position(x, y);
    }

    //Getter
    public Position getPosition() {
        return position;
    }

    //Setter
    public void setPosition(int x, int y) {position.setX(x);position.setY(y);}

    public void setPosition(Position position) {this.position.setX(position.getX());this.position.setY(position.getY());}

    public abstract void draw(TextGraphics graphics,String character);
}
