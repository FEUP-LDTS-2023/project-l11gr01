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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private static TerminalScreen screen;
    private static Planet level;
    private static boolean isGameRunning = false;
    private static int selectedOption = 0;
    private static List<Class<? extends Planet>> levels;
    private static int currentLevelIndex = 0;
    private static boolean running = true;
    private static boolean gameWon = false;
    public static void main(String[] args) {
        levels = new ArrayList<>();
        levels.add(Mercury.class);
        levels.add(Venus.class);
        levels.add(Jupiter.class);
        levels.add(Saturn.class);
        levels.add(Neptune.class);
        levels.add(Uranus.class);
        levels.add(Mars.class);
        levels.add(Earth.class);

        try {
            //Create Terminal
            TerminalSize terminalSize = new TerminalSize(90, 45);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setTerminalEmulatorTitle("Saviors of the Solar System");
            terminalFactory.setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();

            //Create screen
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null);
            screen.startScreen();

            int terminalWindowX = (terminalSize.getColumns() - 30) / 2;
            int terminalWindowY = (terminalSize.getRows() - 5) / 2;

            //Graphics object for outputting to the screen
            TextGraphics graphics = screen.newTextGraphics();


            while (running) {
                if (!isGameRunning) {
                    drawMenu(graphics, terminalWindowX, terminalWindowY);
                }
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
                                    isGameRunning = true;
                                    while (isGameRunning) {
                                        startNextLevel(screen);
                                    }
                                    break;
                                }
                                case 1: {
                                    howToPlay(screen.newTextGraphics(), screen, terminalWindowX, terminalWindowY);
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

    private static void drawMenu(TextGraphics graphics, int x, int y) {
        graphics.setForegroundColor(TextColor.ANSI.WHITE);
        graphics.putString(x + 1, y, "Saviors of the Solar System", SGR.BOLD);
        graphics.putString(x + 4, y + 2, "Welcome, our Savior!", SGR.ITALIC);
        graphics.putString(x, y + 4, "Press ENTER to start playing!");
        graphics.putString(x + 11, y + 6, "[Start]");
        graphics.putString(x + 8, y + 7, "[How to Play]");
        graphics.putString(x + 11, y + 8, "[Exit]");

        graphics.setForegroundColor(TextColor.ANSI.GREEN);
        switch (selectedOption) {
            case 0:
                graphics.putString(x + 11, y + 6, "[Start]");
                break;
            case 1:
                graphics.putString(x + 8, y + 7, "[How to Play]");
                break;
            case 2:
                graphics.putString(x + 11, y + 8, "[Exit]");
                break;
        }
    }

    private static void howToPlay(TextGraphics graphics, TerminalScreen screen, int x, int y) throws IOException {
        screen.clear();
        graphics.setBackgroundColor(TextColor.ANSI.BLACK);

        graphics.putString(5, 5, "Saviors of the Solar System - How to Play", SGR.BOLD);
        graphics.putString(5, 7, "Every brave hero needs to know how things work.", SGR.ITALIC);
        graphics.putString(5, 9, "Instructions:", SGR.BOLD);
        graphics.putString(5, 11, "Your task is to help the Saviors of the Universe");
        graphics.putString(5, 12, "save the Solar System from a species of invaders.");
        graphics.putString(5, 13, "Your spaceship will have to dodge the asteroids");
        graphics.putString(5, 14, "thrown by the invaders!");
        graphics.putString(5, 15, "Use the arrow keys in order to move the spaceship!");
        graphics.putString(5, 16, "Collect all the tokens in order to save the planet.");
        graphics.putString(5, 17, "Good luck on your journey!");
        graphics.putString(5, 19, "Press ESCAPE to go back to the menu!", SGR.BOLD);


        screen.refresh();

        KeyStroke keyStroke;
        do {
            keyStroke = screen.pollInput();
        } while (keyStroke == null || keyStroke.getKeyType() != KeyType.Escape);

        screen.clear();
        drawMenu(screen.newTextGraphics(), x,y);
        screen.refresh();
    }

    private static void startNextLevel(TerminalScreen screen) throws IOException {
        if (currentLevelIndex < levels.size()) {
            try {
                level = levels.get(currentLevelIndex).getDeclaredConstructor().newInstance();
                level.run(screen);
                if (level.spaceshipDead()) {
                    isGameRunning = false;
                }
                currentLevelIndex++;

                if (currentLevelIndex == levels.size()) {
                    gameWon = true;
                    displayGameWinScreen(screen);
                } else {
                    displayMessageBetweenLevels(screen);
                }

            } catch (ReflectiveOperationException e) {
                throw new RuntimeException("Error creating the next level.", e);
            }
        }
    }

    private static void displayMessageBetweenLevels(TerminalScreen screen) throws IOException {
        screen.clear();
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setForegroundColor(TextColor.ANSI.WHITE);
        graphics.setBackgroundColor(TextColor.ANSI.BLACK);

        graphics.putString(31, 20, "You saved the planet!", SGR.BOLD);
        graphics.putString(27, 22, "Traveling to the next planet...", SGR.BOLD);
        graphics.putString(27, 24, "Press ENTER when you're ready!", SGR.BOLD);

        screen.refresh();
        KeyStroke keyStroke;
        do {
            keyStroke = screen.pollInput();
        } while (keyStroke == null || keyStroke.getKeyType() != KeyType.Enter);
        if (keyStroke.getKeyType() == KeyType.Enter) {
            isGameRunning = true;
        }
    }

    public static void displayGameOverScreen() {
        try{
            screen.clear();

            TextGraphics graphics = screen.newTextGraphics();
            graphics.setForegroundColor(TextColor.ANSI.WHITE);
            graphics.setBackgroundColor(TextColor.ANSI.BLACK);

            graphics.putString(40, 20, "GAME OVER!", SGR.BOLD);
            graphics.putString(28, 22, "You couldn't save the Solar System.", SGR.ITALIC);
            graphics.putString(29, 24, "You can always try again though!", SGR.ITALIC);
            graphics.putString(23, 26, "Press ESCAPE if you want to take a break, Savior!");
            graphics.putString(24, 28, "Or ENTER if you want to take your revenge!");

            screen.refresh();

            KeyStroke keyStroke;
            do {
                keyStroke = screen.pollInput();
                if (keyStroke != null && keyStroke.getKeyType() == KeyType.Escape) {
                    screen.close();
                    System.exit(0);
                }
                if (keyStroke != null && keyStroke.getKeyType() == KeyType.Enter) {
                    isGameRunning = false;
                    restartGame();
                }
            } while (keyStroke == null || (keyStroke.getKeyType() != KeyType.Escape && keyStroke.getKeyType() != KeyType.Enter));
        } catch (IOException e) {
            throw new RuntimeException("Issues displaying the Game Over Screen", e);
        }
    }

    private static void displayGameWinScreen(TerminalScreen screen) throws IOException {
        screen.clear();
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setForegroundColor(TextColor.ANSI.WHITE);
        graphics.setBackgroundColor(TextColor.ANSI.BLACK);

        graphics.putString(40, 20, "YOU WON!", SGR.BOLD);
        graphics.putString(30, 22, "You saved the Solar System!", SGR.ITALIC);
        graphics.putString(26, 24, "You are the hero the Solar System needed!", SGR.ITALIC);
        graphics.putString(20, 26, "Press ENTER if you want to redo your impressive journey!");
        graphics.putString(23,28,"Or ESCAPE so you can enjoy your deserved rest!");

        screen.refresh();
        KeyStroke keyStroke;
        do {
            keyStroke = screen.pollInput();
            if (keyStroke != null && keyStroke.getKeyType() == KeyType.Escape) {
                screen.close();
                System.exit(0);
            }
            if (keyStroke != null && keyStroke.getKeyType() == KeyType.Enter) {
                isGameRunning = false;
                restartGame();
            }
        } while (keyStroke == null || (keyStroke.getKeyType() != KeyType.Escape && keyStroke.getKeyType() != KeyType.Enter));

    }

    private static void restartGame() throws IOException{
        currentLevelIndex = 0; //Goes back to Mercury (first level)
        isGameRunning = true;
        while (isGameRunning) {
            startNextLevel(screen);
        }
    }
}