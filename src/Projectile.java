import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Projectile extends GameObject{
    public static BufferedImage image;
    public static boolean needImage = true;
    public static boolean gotImage = false;
    Projectile(int x, int y, int width, int height){
        super(x, y, 50, 50);
        speed = 10;
        if (needImage) {
            loadImage ("bullet.png");
        }
    }
    public void update(){
        y-=speed;
        super.update();
    }
    public void draw(Graphics g){
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
