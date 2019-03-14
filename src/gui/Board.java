package gui;

import java.awt.*;

public class Board {

    public static int worldWidth = 21;
    public static int worldHeight = 21;
    public static int blockSize = 30;

    Block [][] block;

    public Board(){
        define();
    }

    private void define(){
        block = new Block[worldHeight][worldWidth];

        for (int y = 0; y < block.length; y++){
            for (int x = 0; x < block[0].length; x++){
                block[y][x] = new Block(x*blockSize, y*blockSize, blockSize,blockSize);
            }
        }
    }

    public void draw(Graphics g){
        for (int y = 0; y < block.length; y++){
            for (int x = 0; x < block[0].length; x++){
                block[y][x].draw(g);
            }
        }
        block[getYMiddle()][getXMiddle()].startDiffusion(g);
    }

    private int getYMiddle(){
        return (worldHeight/2);
    }

    private int getXMiddle(){
        return (worldWidth/2);
    }

    public void physic(){

    }
}
