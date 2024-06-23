import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Alien extends GameObject{
    public static BufferedImage image;
    public static boolean needImage = true;
    public static boolean gotImage = false;
    Alien(int x, int y) {
        super(x, y,50, 50);
        speed = 1;
        if (needImage) {
            loadImage ("alien.png");
        }
    }
    public void update(){
        y+=speed;
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
