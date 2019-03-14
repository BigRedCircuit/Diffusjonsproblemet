package gui;

import gui.Screen;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class KeyHandler implements MouseMotionListener, MouseListener {

    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        //System.out.println("Pressed");
        System.out.println("x = " + e.getX() + " Y = " + e.getY());
    }

    public void mouseReleased(MouseEvent e) {
        //System.out.println("realiesd");
    }

    public void mouseEntered(MouseEvent e) {
        // System.out.println("entered");
    }

    public void mouseExited(MouseEvent e) {

    }

    public void mouseDragged(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent e) {
    }
}