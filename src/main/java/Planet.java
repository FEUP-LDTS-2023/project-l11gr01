import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Planet {
    protected TerminalScreen screen;
    protected String backgroundColor;

    public Planet(TerminalSize terminalSize, String title, String backgroundColor){
        this.backgroundColor = backgroundColor;
        try{
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setTerminalEmulatorTitle(title);
            terminalFactory.setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();

            screen = new TerminalScreen(terminal);
            screen.startScreen();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void drawFloor() {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString(this.backgroundColor));
        graphics.setForegroundColor(TextColor.Factory.fromString(this.backgroundColor));
        graphics.fillRectangle(new TerminalPosition(0, 0), screen.getTerminalSize(), ' ');
    }

    public String getBackgroundColor(){
        return backgroundColor;
    }

}
