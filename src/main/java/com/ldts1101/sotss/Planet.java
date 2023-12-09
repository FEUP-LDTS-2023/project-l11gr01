package com.ldts1101.sotss;

import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.ldts1101.sotss.Position;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Planet{

    protected String name;
    protected TextColor backgroundColor;
    protected Spaceship spaceship;
    protected List<Wall> walls;
    protected List<Asteroid> asteroids;
    protected int tokenCount;
    public static int livesCount;
    protected Element token;
    protected Element lifeToken;
    protected int asteroidCount;
    private long lastAsteroidCreationTime = System.currentTimeMillis();
    private long lastAsteroidMoveTime = System.currentTimeMillis();
    private long asteroidCreationDelay; // Milliseconds between each asteroid creation
    protected long asteroidMoveDelay = 100;


    //Constructor, after calling it need to set asteroidCount.
    public Planet(TextColor backgroundColor, String name, int tokenCount, int asteroidCount, long asteroidDelay, int livesCount){
        this.backgroundColor = backgroundColor;
        this.tokenCount = tokenCount;
        this.asteroidCount = asteroidCount;
        this.livesCount = livesCount;
        this.spaceship = new Spaceship(backgroundColor);
        this.walls = new ArrayList<>();
        this.asteroids = new ArrayList<>();
        this.name = name;
        this.asteroidCreationDelay = asteroidDelay;
        this.spaceship.setLives(livesCount);
        createWalls();
    }

    public void run(TerminalScreen screen) throws IOException {
        KeyStroke keyStroke;
        //updateToken(); //createToken();
        Random random = new Random();
        token = new Token(new Position(random.nextInt(1,89), random.nextInt(3,44)), backgroundColor);
        do {
            updateToken();
            updateLifeToken();
            updateAsteroidsY();
            draw(screen.newTextGraphics());
            screen.refresh();
            keyStroke = screen.pollInput();
            if (keyStroke != null) {
                processKey(keyStroke);
            }

            if(keyStroke != null && keyStroke.getKeyType() == KeyType.Escape){
                System.exit(0);
                break;
            }

            if(levelPassed()){
                spaceship.addLife();
                return;
            }
        } while ((tokenCount != 0) && (keyStroke == null) || (keyStroke.getKeyType() != KeyType.EOF && keyStroke.getKeyType() != KeyType.Escape));
    }

    public void draw(TextGraphics graphics) {
        //Set planet's background color
        graphics.setBackgroundColor(backgroundColor);
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(90,45), ' ');
        //Draw walls
        for (Wall wall : walls) {
            wall.draw(graphics);
        }
        //Draw level name
        graphics.setForegroundColor(TextColor.Factory.fromString("#000000"));
        graphics.putString(new TerminalPosition(1,1), name, SGR.BOLD);
        //Draw spaceship
        spaceship.draw(graphics);
        //Draw asteroids
        for (Asteroid asteroid : asteroids) {
            asteroid.draw(graphics);
        }
        //Draw Token
        token.draw(graphics);
        //Draw LifeToken
        if (lifeToken != null){
            lifeToken.draw(graphics);
        }
        //Draw level lives
        drawLives(graphics);
    }

    public void updateAsteroidsX(){
        Random random = new Random();
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastAsteroidCreationTime > asteroidCreationDelay) {
            if (asteroids.size() < asteroidCount) {
                int x = random.nextInt(1, 90);
                asteroids.add(new Asteroid(x));
            }
            lastAsteroidCreationTime = currentTime;
        }
        if (currentTime - lastAsteroidMoveTime > asteroidMoveDelay) {
            for (Asteroid asteroid : asteroids) {
                asteroid.moveDown();
            }
            lastAsteroidMoveTime = currentTime;
        }
        for (int i = 0; i < asteroids.size(); i++) {
            for (Position position : asteroids.get(i).getPositions()) {
                if (position.getY() == 44) {
                    asteroids.remove(i);
                }
            }
        }
    }

    public void updateAsteroidsY() {
        Random random = new Random();
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastAsteroidCreationTime > asteroidCreationDelay) {
            if (asteroids.size() < asteroidCount) {
                int x = random.nextInt(1, 89);
                asteroids.add(new Asteroid(x));
            }
            lastAsteroidCreationTime = currentTime;
        }
        if (currentTime - lastAsteroidMoveTime > asteroidMoveDelay) {
            for (Asteroid asteroid : asteroids) {
                asteroid.moveDown();
            }
            lastAsteroidMoveTime = currentTime;
        }
        for (int i = 0; i < asteroids.size(); i++) {
            for (Position position : asteroids.get(i).getPositions()) {
                if (position.getY() == 44) {
                    asteroids.remove(i);
                }
            }
        }
        verifyAsteroidCollision();
        if (spaceshipDead()){
            System.exit(0);
        }
    }

    public void updateToken() {
        Random random = new Random();
        for (Position spaceshipPosition : spaceship.getPositions()) {
            if (spaceshipPosition.equals(token.getPositions().get(0))) {
                token = new Token(new Position(random.nextInt(1,89), random.nextInt(3,44)), backgroundColor); //createToken();
                tokenCount--;
                createLifeToken();
            }
        }
    }

    public void updateLifeToken() {
        for (Position spaceshipPosition : spaceship.getPositions()) {
            if (lifeToken != null) {
                if (spaceshipPosition.equals(lifeToken.getPositions().get(0))) {
                    spaceship.addLife();
                    lifeToken = null;
                }
            }
        }
    }


    private void createWalls() {
        //Create walls for the left and right boundaries
        for (int y = 0; y <= 44; y++) {
            walls.add(new Wall(0, y));
            walls.add(new Wall(89, y));
        }
        // Create walls for the top and bottom boundaries
        for (int x = 0; x <= 89; x++) {
            walls.add(new Wall(x, 0));
            walls.add(new Wall(x, 1));
            walls.add(new Wall(x, 2));
            walls.add(new Wall(x, 44));
        }
    }

    void processKey(KeyStroke keyStroke) throws IOException {
        if(keyStroke != null){
            switch(keyStroke.getKeyType()){
                case ArrowUp: {
                    if (canSpaceShipMoveUp()) {
                        spaceship.moveUp();
                    }
                    break;
                }
                case ArrowDown: {
                    if (canSpaceShipMoveDown()) {
                        spaceship.moveDown();
                    }
                    break;
                }
                case ArrowLeft: {
                    if (canSpaceShipMoveLeft()) {
                        spaceship.moveLeft();
                    }
                    break;
                }
                case ArrowRight: {
                    if (canSpaceShipMoveRight()) {
                        spaceship.moveRight();
                    }
                    break;
                }
            }
        }
    }

    public boolean canSpaceShipMoveUp() {
        for (Wall wall : walls) {
            for (Position wallPosition : wall.getPositions()) {
                for (Position spaceshipPosition : spaceship.getPositions()) {
                    if (wallPosition.getX() == spaceshipPosition.getX() && wallPosition.getY() == spaceshipPosition.getY() - 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean canSpaceShipMoveDown() {
        for (Wall wall : walls) {
            for (Position wallPosition : wall.getPositions()) {
                for (Position spaceshipPosition : spaceship.getPositions()) {
                    if (wallPosition.getX() == spaceshipPosition.getX() && wallPosition.getY() == spaceshipPosition.getY() + 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean canSpaceShipMoveLeft() {
        for (Wall wall : walls) {
            for (Position wallPosition : wall.getPositions()) {
                for (Position spaceshipPosition : spaceship.getPositions()) {
                    if (wallPosition.getX() == spaceshipPosition.getX() - 1 && wallPosition.getY() == spaceshipPosition.getY()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean canSpaceShipMoveRight() {
        for (Wall wall : walls) {
            for (Position wallPosition : wall.getPositions()) {
                for (Position spaceshipPosition : spaceship.getPositions()) {
                    if (wallPosition.getX() == spaceshipPosition.getX() + 1 && wallPosition.getY() == spaceshipPosition.getY()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void verifyAsteroidCollision() {
        for (Asteroid asteroid : asteroids) {
            Position asteroidPosition = asteroid.getPositions().get(0);
            for (Position spaceshipPosition : spaceship.getPositions()) {
                if (spaceshipPosition.equals(asteroidPosition)) {
                    if (!asteroid.collided()) {
                        spaceship.loseLife();
                    }
                    asteroid.collides();
                }
            }
        }
    }


    public boolean levelPassed() {
        return tokenCount == 0;
    }

    public void drawLives(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#7C0000"));
        for (int i = 0; i < spaceship.getLives(); i++) {
            graphics.putString(new TerminalPosition(87 - i * 2, 1), "<3", SGR.BOLD);
        }
    }

    public boolean spaceshipDead() {
        return spaceship.died();
    }

    private void createLifeToken() {
        Random random = new Random();
        int i = random.nextInt(0,100);
        if (i <= 10) {
            lifeToken = new LifeToken(new Position(random.nextInt(1,89), random.nextInt(3,44)), backgroundColor);
        }
    }

}

