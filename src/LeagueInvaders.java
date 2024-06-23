import javax.swing.*;

public class LeagueInvaders {
    //on step 5 of collision management
    JFrame frame;
    static final int WIDTH = 500;
    static final int HEIGHT = 800;
    GamePanel gamePanel;
    public static void main(String[] args) {
        LeagueInvaders leagueInvaders = new LeagueInvaders();
        leagueInvaders.setup();

    }
    LeagueInvaders(){
        frame = new JFrame();
        gamePanel = new GamePanel();
        frame.addKeyListener(gamePanel);

    }
    public void setup(){
        frame.add(gamePanel);
        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    }

}


