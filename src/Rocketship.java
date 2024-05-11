import java.awt.*;

public class Rocketship extends GameObject{
    public void up(){
        y-=speed;
    }
    public void down(){
        y+=speed;
    }
    public void left(){
        x-=speed;
    }
    public void right(){
        x+=speed;
    }
    Rocketship(){
    speed = 10;
    }
    void draw(Graphics g){
        g.setColor(Color.BLUE);
        g.fillRect(x, y, 50, 50);

    }
}
