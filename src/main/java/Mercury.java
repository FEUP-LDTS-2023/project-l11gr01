import com.googlecode.lanterna.TextColor;

public class Mercury extends Planet {
    public Mercury(){
        super(TextColor.Factory.fromString("#536872"),"Mercury");
    }

    @Override
    protected void verifyAsteroidCollision(){
        for (Asteroid asteroid : asteroids){
            if (spaceship.getPosition().equals(asteroid.position)){
                System.out.println("You weren't able to save the solar system!");
                System.exit(0);
            }
        }
    }
}
