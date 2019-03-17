package gui;

import java.awt.*;
import java.util.Iterator;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class Board {

    public static int worldWidth = 31;
    public static int worldHeight = 31;
    public static int blockSize = 30;

    //start position of the spreading
    private int yIndex = 10;
    private int xIndex = 10;

    private List<Water> particles;

    Random rand = new Random(1);

    private double NORTH_SPREAD_PROB = 0.1;
    private double  EAST_SPREAD_PROB = 0.1;
    private double SOUTH_SPREAD_PROB = 0.1;
    private double  WEST_SPREAD_PROB = 0.1;

    Block [][] block;

    public Board(){
        define();
    }

    private void define(){
        Location startingLocation = new Location(yIndex,xIndex);
        block = new Block[worldHeight][worldWidth];
        particles = new ArrayList<>();
        particles.add(new Water(startingLocation));

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
       for(int i = 0; i < particles.size(); i++){
           block[particles.get(i).getYIndex()][particles.get(i).getXIndex()].startDiffusion(g);
       }
        particles.addAll(spreadWater());
    }

    public void physic(){
    }

    private ArrayList spreadWater(){
        ArrayList<Water> newList = new ArrayList();
        for(int i = 0; i < particles.size(); i++){
            if(rand.nextDouble() <= NORTH_SPREAD_PROB){
                newList.add(new Water(new Location(particles.get(i).getYIndex()-1, particles.get(i).getXIndex())));
            }

            if(rand.nextDouble() <= EAST_SPREAD_PROB){
                newList.add(new Water(new Location(particles.get(i).getYIndex(), particles.get(i).getXIndex()+1)));
            }

            if(rand.nextDouble() <= SOUTH_SPREAD_PROB){
                newList.add(new Water(new Location(particles.get(i).getYIndex() + 1, particles.get(i).getXIndex())));
            }

            if(rand.nextDouble() <= WEST_SPREAD_PROB){
                newList.add(new Water(new Location(particles.get(i).getYIndex(), particles.get(i).getXIndex()-1)));
            }
        }
        return newList;
    }

    private int getYMiddle(){
        return (worldHeight/2);
    }

    private int getXMiddle(){
        return (worldWidth/2);
    }
}
