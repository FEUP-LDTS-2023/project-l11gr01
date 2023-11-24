import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.IOException;

import static com.googlecode.lanterna.input.KeyType.Escape;

public class Game {

    private Spaceship spaceship;
    private TerminalScreen screen;

    public static void main(String[] args) {
        try {
            TerminalSize terminalSize = new TerminalSize(50, 20);

            // Initializing the terminal
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setTerminalEmulatorTitle("Saviors of the Solar System");
            terminalFactory.setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();

            // Initializing the screen
            TerminalScreen screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null);
            screen.startScreen();

            // Set the default background color to black
            terminal.setBackgroundColor(TextColor.ANSI.BLACK);
            terminal.setForegroundColor(TextColor.ANSI.WHITE);
            terminal.clearScreen();

            // Centralize the terminal window
            int terminalWindowX = (terminalSize.getColumns() - 30) / 2;
            int terminalWindowY = (terminalSize.getRows() - 5) / 2;

            // Draw some "components" of the menu
            drawTitleAndMessage(screen, terminalWindowX, terminalWindowY);
            drawButton(screen, terminalWindowX + 10, terminalWindowY + 5, "Start");
            screen.refresh();

            // Waiting for the user to press Enter
            while (true) {
                KeyStroke keyStroke = terminal.pollInput();
                if(keyStroke != null && keyStroke.getKeyType() == Escape){
                    screen.close();
                    break;
                }
                if (keyStroke != null && keyStroke.getKeyType() == KeyType.Enter) {
                    screen.close();

                    Mercury mercury = new Mercury();
                    mercury.drawFloor();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void drawTitleAndMessage(TerminalScreen screen, int x, int y) {
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
        textGraphics.putString(x, y, "Saviors of the Solar System", SGR.BOLD, SGR.ITALIC);
        textGraphics.putString(x + 5, y + 2, "Welcome, our Savior");
        textGraphics.putString(x, y + 4, "Press Enter to start playing!");
    }

    private static void drawButton(TerminalScreen screen, int x, int y, String label) {
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
        textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);
        textGraphics.putString(x, y, "[" + label + "]");
    }

}
