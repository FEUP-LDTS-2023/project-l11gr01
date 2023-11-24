import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.TerminalSize;

import java.io.IOException;

public class Mercury extends Planet {

    private TerminalScreen screen;
    private static final TextColor backgroundColor = TextColor.Factory.fromString("#536872");
    private Spaceship spaceship;

    public Mercury() {
        try {
            TerminalSize terminalSize = new TerminalSize(90, 45);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setTerminalEmulatorTitle("Planet Mercury");
            terminalFactory.setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();

            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null);
            screen.startScreen();

            spaceship = new Spaceship(new Position(45,20));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void drawPlanet(){
        try{
            drawFloor();
            spaceship.draw(screen.newTextGraphics());
            screen.refresh();

        } catch(IOException e){
            e.printStackTrace();
        }
    }
    @Override
    public void drawFloor() {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(backgroundColor);
        graphics.fillRectangle(new TerminalPosition(0, 0), screen.getTerminalSize(), ' ');
    }
}
