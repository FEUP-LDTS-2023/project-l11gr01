import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextImage;

import java.util.ArrayList;
import java.util.List;


public abstract class Element {

    //Member fields
    protected List<Position> positions;
    protected TextColor color;
    protected TextImage image;

    //Constructor, after calling it need to set image and Position(s).
    Element(TextColor color) {
        this.positions = new ArrayList<>();
        this.color = color;
    }

    public List<Position> getPositions() {
        return positions;
    }
    public void setPosition(Position position) {
        positions.add(position);
    }


    public void moveUp(){
        for (Position position : positions) {
            position.setY(position.getY() - 1);
        }
    }

    public void moveDown(){
        for (Position position : positions) {
            position.setY(position.getY() + 1);
        }
    }
    public void moveLeft(){
        for (Position position : positions) {
            position.setX(position.getX() - 1);
        }
    }

    public void moveRight(){
        for (Position position : positions) {
            position.setX(position.getX() + 1);
        }
    }

    public void draw(TextGraphics graphics) {
        graphics.drawImage(new TerminalPosition(positions.get(0).getX(),positions.get(0).getY()), image);
    };
}
