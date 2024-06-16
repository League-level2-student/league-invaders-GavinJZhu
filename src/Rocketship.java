import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Rocketship extends GameObject{
    public static BufferedImage image;
    public static boolean needImage = true;
    public static boolean gotImage = false;
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
    Rocketship(int x, int y, int width, int height){
    super(x, y, width, height);
        speed = 10;
        if (needImage) {
            loadImage ("rocket.png");
        }
    }
    void draw(Graphics g){
        if (gotImage) {
            g.drawImage(image, x, y, width, height, null);
        } else {
            g.setColor(Color.BLUE);
            g.fillRect(x, y, width, height);
        }

    }
    void loadImage(String imageFile) {
        if (needImage) {
            try {
                image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
                gotImage = true;
            } catch (Exception e) {

            }
            needImage = false;
        }
    }
}
