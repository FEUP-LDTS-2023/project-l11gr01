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

public class Mercury {

    private TerminalScreen screen;
    private Spaceship spaceship;

    public Mercury(){
        try{
            TerminalSize mercuryTerminalSize = new TerminalSize(90,40);
            DefaultTerminalFactory mercuryTerminalFactory = new DefaultTerminalFactory().setTerminalEmulatorTitle("Planet Mercury");
            mercuryTerminalFactory.setInitialTerminalSize(mercuryTerminalSize);
            Terminal mercuryTerminal = mercuryTerminalFactory.createTerminal();

            screen = new TerminalScreen(mercuryTerminal);
            screen.startScreen();
            mercuryTerminal.setBackgroundColor(TextColor.Factory.fromString("#FF0000"));
            mercuryTerminal.setForegroundColor(TextColor.ANSI.WHITE);
            screen.refresh();

            TextGraphics graphics = screen.newTextGraphics();
            int x = (screen.getTerminalSize().getColumns() - 1) / 2;
            int y = (screen.getTerminalSize().getRows() - 1) / 2;
            graphics.setForegroundColor(TextColor.Factory.fromString("#FF3333"));
            graphics.putString(new TerminalPosition(x,y), "S");
            screen.refresh();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start(){
        try{
            while(true){
                KeyStroke keyStroke = screen.readInput();
                if (keyStroke != null && keyStroke.getKeyType() == KeyType.Escape) {
                    screen.close();
                    break;
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
