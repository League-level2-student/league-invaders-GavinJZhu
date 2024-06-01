import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
    Rocketship rocket;
    ArrayList<Projectile> projectiles = new ArrayList<>();
    ArrayList<Alien> aliens = new ArrayList<>();
    Random random = new Random();

    ObjectManager(Rocketship rocketship){
        rocket = rocketship;


    }
    public void addProjectile(Projectile projectile){

    }
    public void addAlien(){
        aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH),0,50,50));
    }
    public void update(){
        updateAliens();
        updateProjectiles();
    }
    public void updateAliens(){
        for (Alien alien: aliens){
            alien.update();
            if (alien.y>LeagueInvaders.HEIGHT || alien.y<=0){
                alien.isActive = false;
            }
        }
    }
    public void updateProjectiles(){
        for(Projectile projectile: projectiles){
            projectile.update();
            if (projectile.y>LeagueInvaders.HEIGHT || projectile.y<=0){
                projectile.isActive = false;
            }
        }
    }
    public void draw(Graphics g){
        rocket.draw(g);
        drawAliens(g);
        drawProjectiles(g);
    }
    public void drawAliens(Graphics g){
        for (Alien alien: aliens){
            alien.draw(g);
        }
    }
    public void drawProjectiles(Graphics g){
        for (Projectile projectile: projectiles){
            projectile.draw(g);
        }
    }
    public void purgeObjects(){
        purgeAliens();
        purgeProjectiles();
    }
    public void purgeAliens(){
        for (Alien alien: aliens){
            if (alien.isActive == false){
                aliens.remove(alien);
            }
        }
    }
    public void purgeProjectiles(){
        projectiles.removeIf(pro-> !pro.isActive);
        //above = below
        //for (Projectile pro: projectiles){
        //    if (pro.isActive == false){
        //        projectiles.remove(pro);
        //    }
        //}
    }
}
