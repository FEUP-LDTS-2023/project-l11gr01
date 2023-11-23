import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import org.w3c.dom.Text;

import java.io.IOException;

public abstract class Planet{

    protected TextColor backgroundColor;
    protected Spaceship spaceship;

    public Planet(TextGraphics graphics, String backgroundColor, Spaceship spaceship){
        this.backgroundColor = TextColor.Factory.fromString(backgroundColor);
        this.spaceship = spaceship;
        draw(graphics);
    }

    public void draw(TextGraphics graphics) {
        //Set Planet's background color
        graphics.setBackgroundColor(backgroundColor);
        graphics.setForegroundColor(backgroundColor);
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(90,45), ' ');

        spaceship.draw(graphics, "S");
    }

    void processKey(KeyStroke keyStroke) throws IOException {
        if(keyStroke != null){
            switch(keyStroke.getKeyType()){
                case ArrowUp:
                    spaceship.moveUp();
                    break;
                case ArrowDown:
                    spaceship.moveDown();
                    break;
                case ArrowLeft:
                    spaceship.moveLeft();
                    break;
                case ArrowRight:
                    spaceship.moveRight();
                    break;
            }
        }
    }
}
