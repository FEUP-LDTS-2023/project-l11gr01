import com.googlecode.lanterna.TextColor;

public class Mars extends Planet{
    public Mars(){
        super(TextColor.Factory.fromString("#F06100"),"Mars");
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
