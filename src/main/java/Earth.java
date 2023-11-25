import com.googlecode.lanterna.TextColor;

public class Earth extends Planet{
    public Earth(){
        super(TextColor.Factory.fromString("#088F8F"),"Earth");
    }

    @Override
    protected void verifyAsteroidCollision() {
        for (Asteroid asteroid : asteroids){
            if (spaceship.getPosition().equals(asteroid.position)){
                System.out.println("You weren't able to save the solar system!");
                System.exit(0);
            }
        }
    }
}
