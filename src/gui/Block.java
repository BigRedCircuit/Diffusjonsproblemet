package gui;

import java.awt.*;
import gui.Board;

public class Block extends Rectangle {

    private int RGB_RED = 24;           //15x
    private int RGB_GREEN = 52;         //12,64
    private int RGB_BLUE = 78;          //10,38

    // 0,

    private int step = 0;
    private int decay = 100;
    private int decayRate = 10;

    public Block(int x, int y, int width, int height){
        setBounds(x,y,width,height);
    }

    public void draw(Graphics g){
        g.setColor(Color.BLACK);
        g.drawRect(x,y,width,height);
    }

    public void startDiffusion(Graphics g){
        g.setColor(new Color(getRedColour(),getGreenColour(),getBlueColour()));
        g.fillRect(x,y,Board.blockSize, Board.blockSize);
        step++;
    }

    private int getRedColour(){
        int red = RGB_RED + (5*step);
        if(red <= 255){
            return red;
        }else{
            return 255;
        }
    }
    private int getGreenColour(){
        int green = RGB_GREEN + (13*step);
        if(green <= 255){
            return green;
        }else{
            return 255;
        }
    }
    private int getBlueColour(){
        int blue = RGB_BLUE + (20*step);
        if(blue <= 255){
            return blue;
        }else{
            return 255;
        }
    }
}
