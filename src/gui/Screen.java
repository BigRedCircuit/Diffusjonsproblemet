package gui;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;

import java.util.logging.Logger;

public class Screen extends JPanel implements Runnable{

    private Thread gameThread = new Thread(this);

    private boolean isFirst = true;

    static boolean exit = false;
    static int myWidth;
    static  int myHeight;

    //Logger to communicate with user in case of error
    private final Logger logger = Logger.getLogger(Screen.class.getName());

    public static Point mse = new Point(0,0);

    private static Board board;


    /**
     * Constructor
     * @param frame takes the Application and tells the app to listen for mouse events.
     */
    public Screen(Frame frame){
        frame.addMouseListener(new KeyHandler());
        frame.addMouseMotionListener(new KeyHandler());
        gameThread.start();
    }

    private void define(){
        board = new Board();
    }

    @Override
    public  void paintComponent(Graphics g){
        if(isFirst){
            myWidth = getWidth();
            myHeight = getHeight();

            define();
            board.physic();

            isFirst = false;
        }

        g.clearRect(0,0, myWidth, myHeight);

        board.draw(g);
    }


    public void run(){
        while(!exit){
            if(!isFirst){
                board.physic();
            }
            repaint();

            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                logger.log(Level.WARNING, "Interrupted!", e);
                // Restore interrupted state...      
                Thread.currentThread().interrupt();
            }
        }
    }
}
