import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import org.w3c.dom.Text;

import java.io.IOException;

public class Mercury extends Planet {
    protected Spaceship spaceship;
    private String backgroundColor;

    public Mercury(){
        super(new TerminalSize(90, 40), "Planet Mercury", "#536872");
        spaceship = new Spaceship(new Position(45,20));
    }


    public void start(){
        try{
            while(true){
                processInputs();

                drawFloor();
                spaceship.draw(screen.newTextGraphics());
                screen.refresh();

                KeyStroke keyStroke = screen.readInput();
                if (keyStroke != null && keyStroke.getKeyType() == KeyType.Escape) {
                    screen.close();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();}
    }

    private void processInputs() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
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
