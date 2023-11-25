import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public abstract class Planet{

    protected String name;
    protected TextColor backgroundColor;
    protected Spaceship spaceship;
    protected List<Wall> walls;
    protected List<Asteroid> asteroids;
    protected List<Token> tokens;

    private long lastAsteroidCreationTime = System.currentTimeMillis();

    private long lastAsteroidMoveTime = System.currentTimeMillis();
    private long asteroidCreationDelay = 1000; // Milliseconds between each asteroid creation
    private long asteroidMoveDelay = 100;


    public Planet(TextColor backgroundColor,String name){
        this.backgroundColor = backgroundColor;
        this.spaceship = new Spaceship();
        this.walls = new ArrayList<>();
        this.asteroids = new ArrayList<>();
        this.tokens = new ArrayList<>();
        this.name = name;
        createWalls();
    }

    public void draw(TextGraphics graphics) {
        //Set Planet's background color
        graphics.setBackgroundColor(backgroundColor);
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(90,45), ' ');
        //Draw walls
        for (Wall wall : walls) {
            wall.draw(graphics);
        }
        //Draw spaceship
        spaceship.draw(graphics);
        //Draw level name
        graphics.setForegroundColor(TextColor.ANSI.YELLOW_BRIGHT);
        graphics.putString(new TerminalPosition(1,1),name,SGR.BOLD);
        //Draw asteroids
        for (Asteroid asteroid : asteroids) {
            asteroid.draw(graphics);
        }

        for(Token token : tokens){
            token.draw(graphics);
        }
    }

    public void updateAsteroids() {
        Random random = new Random();
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastAsteroidCreationTime > asteroidCreationDelay) {
            if (asteroids.size() < 3) {
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
            if (asteroids.get(i).getY() == 44) {
                asteroids.remove(i);
            }
        }
        verifyAsteroidCollision();
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

    private Boolean canSpaceShipMoveLeft() {
        for (Wall wall : walls) {
            if (wall.getX() == spaceship.getX()-1 && wall.getY() == spaceship.getY()) {
                return false;
            }
        }
        return true;
    }

    private Boolean canSpaceShipMoveRight() {
        for (Wall wall : walls) {
            if (wall.getX() == spaceship.getX()+3 && wall.getY() == spaceship.getY()) {
                return false;
            }
        }
        return true;
    }

    private Boolean canSpaceShipMoveUp() {
        for (Wall wall : walls) {
            if (wall.getX() == spaceship.getX() && wall.getY() == spaceship.getY()-1) {
                return false;
            }
        }
        return true;
    }

    private Boolean canSpaceShipMoveDown() {
        for (Wall wall : walls) {
            if (wall.getX() == spaceship.getX() && wall.getY() == spaceship.getY()+3) {
                return false;
            }
        }
        return true;
    }

    public List<Token> spawnTokens(int count){
        Random random = new Random();
        ArrayList<Token> tokens = new ArrayList<>();
        for(int i = 0; i < count; i++){
            Token newToken;
            do{
                newToken = new Token(new Position(random.nextInt(76) + 5, random.nextInt(31) + 5), TextColor.Factory.fromString("#999933"));

            } while(tokens.contains(newToken) || newToken.getPosition().equals(spaceship.getPosition()));
            tokens.add(newToken);
        }

        return tokens;
    }

    public void removeTokens() {
        Iterator<Token> iterator = tokens.iterator();
        while (iterator.hasNext()) {
            Token token = iterator.next();
            if (spaceship.getPosition().equals(token.getPosition())) {
                iterator.remove(); // Use iterator to safely remove the token
                break;
            }
        }
    }

    protected abstract void verifyAsteroidCollision();

}

