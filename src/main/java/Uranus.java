import com.googlecode.lanterna.TextColor;

public class Uranus extends Planet{
    public Uranus(){
        super(TextColor.Factory.fromString("#ADD8E6"),"Uranus");
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
