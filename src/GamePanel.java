import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer.*;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    int currentState = MENU;
    Font titleFont;
    Font introFont;
    Font gameOverFont;
    Font statsFont;
    Timer frameDraw;
    Rocketship rocketship;
    GamePanel (){
        titleFont = new Font("Arial", Font.PLAIN, 48);
        introFont = new Font("Arial", Font.PLAIN, 24);
        gameOverFont = new Font("Arial", Font.PLAIN, 48);
        statsFont = new Font("Arial", Font.PLAIN, 24);
        frameDraw = new Timer(1000/60, this);
        frameDraw.start();
        rocketship = new Rocketship();
    }


    @Override
    public void paintComponent(Graphics g){
        if(currentState == MENU){
            drawMenuState(g);
        }
        else if(currentState == GAME){
            drawGameState(g);
        }
        else if(currentState == END){
            drawEndState(g);
        }
    }
    void updateMenuState() {

    }
    void updateGameState() {

    }
    void updateEndState()  {

    }
    void drawMenuState(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
        g.setFont(titleFont);
        g.setColor(Color.YELLOW);
        g.drawString("LEAGUE INVADERS", 20, 200);
        g.setFont(introFont);
        g.setColor(Color.yellow);
        g.drawString("Press ENTER to start", 125, 400);
        g.drawString("Press SPACE for instructions", 85, 550);
    }
    void drawGameState(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0,0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
        rocketship.draw(g);
    }
    void drawEndState(Graphics g)  {
        g.setColor(Color.RED);
        g.fillRect(0,0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
        g.setFont(gameOverFont);
        g.setColor(Color.YELLOW);
        g.drawString("Game Over", 117, 100);
        g.setFont(statsFont);
        g.setColor(Color.yellow);
        g.drawString("You killed " + " enemies", 150, 400);
        g.drawString("Press ENTER to restart", 125, 550);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(currentState == MENU){
            updateMenuState();
        }
        else if(currentState == GAME){
            updateGameState();
        }
        else if(currentState == END){
            updateEndState();
        }
        System.out.println("action");
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_ENTER) {
            if (currentState == END) {
                currentState = MENU;
            } else {
                currentState++;
            }
        }
        if (e.getKeyCode()==KeyEvent.VK_UP) {
            System.out.println("UP");
        }
        else if(e.getKeyCode()==KeyEvent.VK_DOWN) {
            System.out.println("DOWN");
        }
        else if (e.getKeyCode()==KeyEvent.VK_LEFT) {
            System.out.println("LEFT");
        }
        else if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
            System.out.println("RIGHT");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

