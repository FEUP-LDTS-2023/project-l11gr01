import com.googlecode.lanterna.TextColor;

public class Saturn extends Planet{
    public Saturn(){
        super(TextColor.Factory.fromString("#AE8B0C"),"Saturn");
    }

    @Override
    protected void verifyAsteroidCollision() {
        for (Asteroid asteroid : asteroids){
            if (spaceship.getPosition().equals(asteroid.position)){
                System.out.println("You almost saved the solar system!");
                System.exit(0);
            }
        }
    }
}
