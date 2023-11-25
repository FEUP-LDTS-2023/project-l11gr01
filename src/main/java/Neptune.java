import com.googlecode.lanterna.TextColor;

public class Neptune extends Planet{
    public Neptune(){
        super(TextColor.Factory.fromString("#4169E1"),"Neptune");
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
