import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
    Rocketship rocket;
    ArrayList<Projectile> projectile = new ArrayList<>();
    ArrayList<Alien> alien = new ArrayList<>();
    Random random = new Random();

    ObjectManager(Rocketship rocketship){
        rocket = rocketship;


    }
    public void addProjectile(Projectile projectile){

    }
    public void addAlien(){
        alien.add(new Alien(random.nextInt(LeagueInvaders.WIDTH),0,50,50));

    }
}
