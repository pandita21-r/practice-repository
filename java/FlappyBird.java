import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class FlappyBird extends JPanel
        implements ActionListener, KeyListener, WindowListener {

    int birdY = 250;
    int birdVelocity = 0;

    final int GRAVITY = 1;
    final int JUMP = -12;

    int pipeX = 400;
    int pipeGap = 150;
    int pipeTopHeight;

    int score = 0;
    boolean gameOver = false;

    Timer timer;
    Random rand = new Random();

    public FlappyBird() {
        JFrame frame = new JFrame("Flappy Bird - Java");
        frame.setSize(400, 600);

        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        frame.add(this);
        frame.addKeyListener(this);
        frame.addWindowListener(this);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        pipeTopHeight = rand.nextInt(200) + 50;
        timer = new Timer(20, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.cyan);
        g.fillRect(0, 0, 400, 600);

        g.setColor(Color.orange);
        g.fillRect(0, 550, 400, 50);

        g.setColor(Color.green);
        g.fillRect(pipeX, 0, 60, pipeTopHeight);
        g.fillRect(pipeX, pipeTopHeight + pipeGap, 60, 600);

        drawBird(g);

        g.setColor(Color.black);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: " + score, 20, 30);

        if (gameOver) {
            g.setFont(new Font("Arial", Font.BOLD, 40));
            g.drawString("Game Over", 70, 300);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            g.drawString("Press R to Restart", 100, 340);
        }
    }

    void drawBird(Graphics g) {
        int x = 100;
        int y = birdY;

        g.setColor(Color.yellow);
        g.fillOval(x, y, 36, 28);

        g.setColor(Color.orange);
        int wingOffset = birdVelocity < 0 ? -6 : 6;
        g.fillOval(x + 10, y + 12 + wingOffset, 18, 12);

        g.setColor(Color.black);
        g.fillOval(x + 24, y + 8, 4, 4);

        int[] beakX = {x + 36, x + 44, x + 36};
        int[] beakY = {y + 12, y + 16, y + 20};
        g.setColor(Color.red);
        g.fillPolygon(beakX, beakY, 3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            birdVelocity += GRAVITY;
            birdY += birdVelocity;

            pipeX -= 5;

            if (pipeX < -60) {
                pipeX = 400;
                pipeTopHeight = rand.nextInt(200) + 50;
                score++;
            }

            Rectangle bird = new Rectangle(100, birdY, 36, 28);
            Rectangle topPipe = new Rectangle(pipeX, 0, 60, pipeTopHeight);
            Rectangle bottomPipe =
                    new Rectangle(pipeX, pipeTopHeight + pipeGap, 60, 600);

            if (bird.intersects(topPipe) ||
                bird.intersects(bottomPipe) ||
                birdY > 520 ||
                birdY < 0) {
                gameOver = true;
            }

            repaint();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE && !gameOver) {
            birdVelocity = JUMP;
        }

        if (e.getKeyCode() == KeyEvent.VK_R && gameOver) {
            restartGame();
        }
    }

    void restartGame() {
        birdY = 250;
        birdVelocity = 0;
        pipeX = 400;
        score = 0;
        gameOver = false;
        pipeTopHeight = rand.nextInt(200) + 50;
    }

    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}

    @Override
    public void windowClosing(WindowEvent e) {
        timer.stop(); 
        System.out.println("Final score: " + score);
        System.exit(0); 
    }

    @Override public void windowOpened(WindowEvent e) {}
    @Override public void windowClosed(WindowEvent e) {}
    @Override public void windowIconified(WindowEvent e) {}
    @Override public void windowDeiconified(WindowEvent e) {}
    @Override public void windowActivated(WindowEvent e) {}
    @Override public void windowDeactivated(WindowEvent e) {}

    public static void main(String[] args) {
        new FlappyBird();
    }
}