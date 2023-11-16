import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalFactory;

import java.io.IOException;

public class Game {

    public static void main(String[] args) {
        try {
            //Initializing the terminal and screen
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            TerminalScreen screen = new TerminalScreen(terminal);
            screen.startScreen();

            //Initialize the GUI with the screen to display our name
            MultiWindowTextGUI gui = new MultiWindowTextGUI(screen);
            Window window = new BasicWindow("Savior of the Solar System");

            //Panel to hold components
            Panel contentPanel = new Panel();
            contentPanel.setLayoutManager(new GridLayout(1));
            contentPanel.addComponent(new Label("Welcome, our Savior"));
            contentPanel.addComponent(new EmptySpace(new TerminalSize(0, 1)));

            //"Start" button, but since we don't have anything yet it just closes
            Button startButton = new Button("Start", () -> {
                try {
                    screen.stopScreen();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            //Add the "Start" button to the panel
            contentPanel.addComponent(startButton);
            window.setComponent(contentPanel);
            gui.addWindowAndWait(window);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}