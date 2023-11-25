import com.googlecode.lanterna.TextColor;

public class Venus extends Planet{
    public Venus(){
        super(TextColor.Factory.fromString("#FFFDAF"),"Venus");
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
