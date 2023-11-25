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

public class Game {

    private static Planet level;

    public static void main(String[] args) {
        try {
            //Create Terminal
            TerminalSize terminalSize = new TerminalSize(90, 45);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setTerminalEmulatorTitle("Saviors of the Solar System");
            terminalFactory.setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();

            //Create screen
            TerminalScreen screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null);
            screen.startScreen();

            int terminalWindowX = (terminalSize.getColumns() - 30) / 2;
            int terminalWindowY = (terminalSize.getRows() - 5) / 2;

            //Graphics object for outputting to the screen
            TextGraphics graphics = screen.newTextGraphics();



            boolean running = true;

            while (running) {
                drawMenu(graphics, terminalWindowX, terminalWindowY);
                screen.refresh();
                KeyStroke keyStroke = screen.pollInput();
                if (keyStroke != null) {
                    switch (keyStroke.getKeyType()) {
                        case Enter: {
                            //Start level 1
                            level = new Mercury();
                            level.run(screen);
                            break;
                        }
                        case Escape, EOF: {
                            running = false;
                            break;
                        }
                    }
                    //Escrever aqui oque deve acontecer quando coletar as 5 moedas.
                }
            }
            screen.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private static void processKey(KeyStroke keyStroke) throws IOException {
        level.processKey(keyStroke);
    }

    private static void drawMenu(TextGraphics graphics, int x, int y) {
        graphics.setForegroundColor(TextColor.ANSI.WHITE);
        graphics.putString(x + 1, y, "Saviors of the Solar System", SGR.BOLD);
        graphics.putString(x + 4, y + 2, "Welcome, our Savior!", SGR.ITALIC);
        graphics.putString(x, y + 4, "Press Enter to start playing!");
        graphics.putString(x + 10, y + 6, "[Start]");
    }
}