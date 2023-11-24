import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
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

    public Planet(TextColor backgroundColor,String name){
        this.backgroundColor = backgroundColor;
        this.spaceship = new Spaceship();
        this.walls = new ArrayList<>(210);
        this.asteroids = new ArrayList<>();
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
        graphics.putString(new TerminalPosition(0,0),name,SGR.BOLD);
        //Draw asteroids
        for (Asteroid asteroid : asteroids) {
            asteroid.draw(graphics);
        }
    }

    public void updateAsteroids() {
        if (asteroids.size() < 15) {
            Random random = new Random();
            int x = random.nextInt(1,90);
            asteroids.add(new Asteroid(x));
        }
        for (int i = 0; i < asteroids.size(); i++) {
            asteroids.get(i).moveDown();
            if (asteroids.get(i).getY() == 45) {
                asteroids.remove(i);
            }
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

    private void createWalls() {
         //Create walls for the left and right boundaries
        for (int y = 30; y <= 44; y++) {
            walls.add(new Wall(0, y));
            walls.add(new Wall(89, y));
        }
        // Create walls for the top and bottom boundaries
        for (int x = 0; x <= 89; x++) {
            walls.add(new Wall(x, 30));
            walls.add(new Wall(x, 44));
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
}
