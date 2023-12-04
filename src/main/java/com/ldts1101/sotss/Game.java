package com.ldts1101.sotss;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.ldts1101.sotss.Planet;

import java.io.IOException;

public class Game {

    private static Planet level;
    private static boolean isLevelRunning = false;

    private static int selectedOption = 0;

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
                        case ArrowUp: {
                            selectedOption = (selectedOption - 1 + 3) % 3;
                            break;
                        }
                        case ArrowDown: {
                            selectedOption = (selectedOption + 1) % 3;
                            break;
                        }
                        case Enter: {
                            switch (selectedOption) {
                                case 0: {
                                    level = new Mercury();
                                    level.run(screen);
                                    break;
                                }
                                case 1: {
                                    howToPlay(screen.newTextGraphics(), 35,1,screen);
                                    break;
                                }
                                case 2: {
                                    running = false;
                                    break;
                                }
                            }
                            break;
                        }
                        case Escape, EOF: {
                            running = false;
                            break;
                        }
                    }
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
        graphics.putString(x + 10, y + 7, "[How to Play]");
        graphics.putString(x + 10, y + 8, "[Exit]");

        graphics.setForegroundColor(TextColor.ANSI.GREEN);
        switch (selectedOption) {
            case 0:
                graphics.putString(x + 10, y + 6, "[Start]");
                break;
            case 1:
                graphics.putString(x + 10, y + 7, "[How to Play]");
                break;
            case 2:
                graphics.putString(x + 10, y + 8, "[Exit]");
                break;
        }
    }

    private static void howToPlay(TextGraphics graphics, int x, int y, TerminalScreen screen) throws IOException {
        graphics.setForegroundColor(TextColor.ANSI.WHITE);
        graphics.putString(x - 10, y, "Saviors of the Solar System - How to Play", SGR.BOLD);
        graphics.putString(x - 10, y + 2, "Every brave hero needs to know how things work.", SGR.ITALIC);
        graphics.putString(x - 14, y + 4, "Instructions:", SGR.BOLD);
        graphics.putString(x - 14, y + 5, "Your job is to save our Solar System.");
        graphics.putString(x - 14, y + 6, "Your spaceship will need to avoid the asteroids that");
        graphics.putString(x - 14, y + 7, "will come in your way!");
        graphics.putString(x - 14, y + 8, "Use the arrow keys in order to move the spaceship!");
        graphics.putString(x - 14, y + 9, "Collect all the tokens in order to save the planet.");
        graphics.putString(x - 14, y + 10, "Good luck on your journey!");
        graphics.putString(x - 14, y + 11, "Press Escape to go back to the menu!",SGR.BOLD);


        screen.refresh();

        KeyStroke keyStroke;
        do {
            keyStroke = screen.pollInput();
        } while (keyStroke == null || keyStroke.getKeyType() != KeyType.Escape);
    }
}