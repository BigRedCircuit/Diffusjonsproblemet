package gui;

import java.awt.*;

public class Block extends Rectangle {

    public Block(int x, int y, int width, int height){
        setBounds(x,y,width,height);
    }

    public void draw(Graphics g){
        g.setColor(Color.BLACK);
        g.drawRect(x,y,width,height);


    }

    public void startDiffusion(Graphics g){
        g.setColor(new Color(0,0,255));
        g.fillRect(x,y,Board.blockSize, Board.blockSize);
    }
}
