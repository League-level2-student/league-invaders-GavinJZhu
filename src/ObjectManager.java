import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
    Rocketship rocket;
    ArrayList<Projectile> projectiles = new ArrayList<>();
    ArrayList<Alien> aliens = new ArrayList<>();
    Random random = new Random();
    int score = 0;

    ObjectManager(Rocketship rocketship){
        rocket = rocketship;


    }
    public void addProjectile(Projectile projectile){
        projectiles.add(projectile);
    }
    public void addAlien(){
        aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH),0));
    }
    public void update(){
        updateAliens();
        updateProjectiles();
        rocket.update();
        checkCollision();
        purgeObjects();
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
        aliens.removeIf(alien -> !alien.isActive);
    }
    public void purgeProjectiles(){
        projectiles.removeIf(pro-> !pro.isActive);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        addAlien();
    }
    public void checkCollision(){
        for(Alien alien : aliens){
            if (rocket.collisionBox.intersects(alien.collisionBox)){
                alien.isActive = false;
                rocket.isActive = false;
            }
            for (Projectile projectile : projectiles){
                if (projectile.collisionBox.intersects(alien.collisionBox)){
                    alien.isActive = false;
                    projectile.isActive = false;
                }
            }
        }
    }
}
