package gui;
import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    private static String windowTitle = "Diffusjonsproblemet";
    public static Dimension size = new Dimension(800,700);

    public static void main(String[] args){
        new Main();
    }

    private Main(){
        setSize(size);
        setTitle(windowTitle);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        init();
    }

    private void init(){
        setLayout(new GridLayout(1,1,0,0));
        Screen screen = new Screen(this);
        add(screen);

        setVisible(true);
    }
}
