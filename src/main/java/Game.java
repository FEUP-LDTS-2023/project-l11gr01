import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.gui2.TextGUI;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.IOException;

public class Game {

    public static void main(String[] args) {
        try {
            TerminalSize terminalSize = new TerminalSize(50, 20);

            // Initializing the terminal
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setTerminalEmulatorTitle("Savior of the Solar System");
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

            // Wait for the user to press Enter
            while (true) {
                KeyStroke keyStroke = terminal.pollInput();
                if (keyStroke != null && keyStroke.getKeyType() == KeyType.Enter) {
                    screen.close();

                    //This is the starting level
                    new Mercury().start();
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
        textGraphics.putString(x, y, "Savior of the Solar System");
        textGraphics.putString(x, y + 2, "Welcome, our Savior");
        textGraphics.putString(x, y + 3, "Press Enter to start playing!");
    }

    private static void drawButton(TerminalScreen screen, int x, int y, String label) {
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
        textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);
        textGraphics.putString(x, y, "[" + label + "]");
    }
}
