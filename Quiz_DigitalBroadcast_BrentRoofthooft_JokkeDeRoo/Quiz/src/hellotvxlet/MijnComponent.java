/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Color;
import java.awt.Graphics;
//import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;

//import java.awt.image.BufferedImage;
import org.havi.ui.HComponent;

/**
 *
 * @author student
 */

public class MijnComponent extends HComponent{
    
    Image beeldje;
    int x=200;
    int y=500;
    int ay=0;
        

    
    
    public MijnComponent (String filename , int x, int y, int x2, int y2) {
        this.setBounds(x,y,x2,y2);
        beeldje = this.getToolkit().getImage(filename);
        
        MediaTracker mt = new MediaTracker(this);
        mt.addImage(beeldje,1);
        
        try{
            mt.waitForAll();
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public void paint (Graphics g){
       // g.drawLine(0, 0, 100, 100); //x,y,x2,y2
       // g.drawLine(0,100,100,0);
       // g.setColor (Color.GREEN);
       // g.fillOval(0,0,100,100);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 720, 576);
       g.drawImage(beeldje, 10, 20, this);
    }
}

