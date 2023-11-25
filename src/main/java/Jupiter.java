import com.googlecode.lanterna.TextColor;

public class Jupiter extends Planet{
    public Jupiter(){
        super(TextColor.Factory.fromString("#D2B59A"),"Jupiter");
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
