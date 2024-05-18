import java.awt.*;

public class Alien extends GameObject{
    Alien() {
        speed = 1;
    }
    public void update(){
        y+=speed;

    }
    public void draw(Graphics g){
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, width, height);
    }
}
