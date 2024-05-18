import java.awt.*;

public class Projectile extends GameObject{
    Projectile(){
        speed = 10;
    }
    public void update(){
        y-=speed;
    }
    public void draw(Graphics g){
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, width, height);

    }
}
