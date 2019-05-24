package hellotvxlet;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.tv.xlet.*;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HStaticText;
import org.havi.ui.HTextButton;
import org.havi.ui.HVisible;
import org.havi.ui.event.HActionListener;


public class HelloTVXlet implements Xlet, HActionListener {

    HScene scene;
    
    MijnComponent achtergr = new MijnComponent("HorrorBackground.jpg", 0, 0, 720, 576);
     
    MijnComponent jason = new MijnComponent("jason.jpg", 115, 100, 720, 576);
    MijnComponent michael = new MijnComponent("michael.jpg", 40, 30, 720, 576);
    MijnComponent penny = new MijnComponent("penny.jpg", 10, 0, 720, 576);
    MijnComponent freddy = new MijnComponent("freddy.jpg", -5, -15, 720, 576);
    MijnComponent ghostface = new MijnComponent("ghostface.jpg", 50, 30, 720, 576);
    MijnComponent leather = new MijnComponent("leather.jpg", 50, 20, 720, 576);
    MijnComponent candy = new MijnComponent("candy.jpg", 0, -10, 720, 576);
    
       
    int jasonVoorhees = 0;
    int michaelMyers = 0;
    int pennywise = 0;
    int freddyKreuger = 0;
    int ghostFace = 0;
    int leatherface = 0;
    int candyman = 0;
    
    HStaticText vraag = new HStaticText ("Pick an activity.", 20, 300, 680, 50);
    HTextButton startbtn1 = new HTextButton("Which horror icon are you?", 200,300,300,50); // x y w h
    HTextButton btn1 = new HTextButton("", 20,400,300,50); // x y w h
    HTextButton btn2 = new HTextButton("", 20,450,300,50); // x y w h
    HTextButton btn3 = new HTextButton("", 350,400,300,50); // x y w h
    HTextButton btn4 = new HTextButton("", 350,450,300,50); // x y w h
    
    HStaticText jasonEnd = new HStaticText ("You are Jason Voorhees", 20, 500, 680, 50);
    HStaticText michaelEnd = new HStaticText ("You are Michael Myers", 20, 500, 680, 50);
    HStaticText pennyEnd = new HStaticText ("You are Pennywise the Clown", 20, 500, 680, 50);
    HStaticText freddyEnd = new HStaticText ("You are Freddy Krueger", 20, 500, 680, 50);
    HStaticText ghostEnd = new HStaticText ("You are Ghostface", 20, 500, 680, 50);
    HStaticText leatherEnd = new HStaticText ("You are Leatherface", 20, 500, 680, 50);
    HStaticText candyEnd = new HStaticText ("You are the Candyman", 20, 500, 680, 50);
    
    String vragen[] = {"Pick an activity","Would you rather", "Pick a weapon","Pick one", "Favorite family member?","Pick a location", "What do u prefer to wear?","I have ...", "Pick a color", "I am ...", "Pick one", "Pick a favorite"};
    String antwoordenLinksBoven[] = {"Trick 'r treating", "Go swimming", "Knife", "Spider", "Mother", "The hood", "Mask", "Problems sleeping", "Black", "An entertainer", "I have many faces", "Jack o' Lantern"};
    String antwoordenRechtsBoven[] = {"Day at the lake", "Stay up late", "Machete", "Bee", "I love them all", "A sewer", "Make-up", "Mommy issues", "Red", "There when you call me", "No one knows my identity", "Cotton Candy"};
    String antwoordenLinksOnder[] = {"Circus show", "Save the bees", "Hook", "Bedbug", "Bees are my family", "Texas", "Bag", "A speaking disorder", "Brown", "A dreamer", "I kidnap children", "Bed"};
    String antwoordenRechtsOnder[] = {"Houseparty", "Stalk someone", "Chainsaw", "Flea", "Fuck family", "Lake", "Hat", "A really deep voice", "Orange", "Someone who calls a lot", "I'm a silent walker", "Cape"};
    
    int vraagnr = 0;
    
    int plusTeller = 0;
    
    //            vr0  vr1
    String[] s1={"M","J", "GM", "M", "JL", "C", "JGL", "F", "GC", "P", "L", "M"};
    String[] s2={"J","F", "J", "C", "L", "P", "P", "J", "JPF", "C", "G", "P"};
    String[] s3={"P","C", "C", "F", "C", "L", "J", "LJ", "LC", "F", "PF", "F"};
    String[] s4={"G","JMG", "L", "PL", "M", "J", "F", "C", "M", "G", "MG", "G"};
    /*String vragen[] =  {"Pick an activity.", "Vraag 2", "Vraag 3", "Vraag 4", "Vraag 5", "Vraag 6", "Vraag 7", "Vraag 8", "Vraag 9", "Vraag 10"};
    int huidigeVraag = 0;
    HStaticText vraag = new HStaticText (vragen[huidigeVraag], 20, 300, 680, 50);
    
    Int antwoordTeller = 0;
    
    String antwoordLinksBoven[] = {"Day at the lake.", "Antwoord"*/
    
    public HelloTVXlet() {
        
    }
    public boolean bevat( String s, char t)
    {
        for (int i=0;i<s.length();i++)
        {
            if (s.charAt(i)==t) return true;
        }
        return false;
    }
    
    public void wijzig_tekst(int nr)
    {
        vraag.setTextContent(vragen[nr], HVisible.NORMAL_STATE);
        
        btn1.setTextContent(antwoordenLinksBoven[nr], HVisible.NORMAL_STATE);
        btn2.setTextContent(antwoordenRechtsBoven[nr], HVisible.NORMAL_STATE);
        btn3.setTextContent(antwoordenLinksOnder[nr], HVisible.NORMAL_STATE);
        btn4.setTextContent(antwoordenRechtsOnder[nr], HVisible.NORMAL_STATE);
        
        scene.repaint();
    }
    
    public void initXlet(XletContext context) {
      scene=HSceneFactory.getInstance().getDefaultHScene();
      
      scene.add(achtergr);
     
      startbtn1.setBackgroundMode(HVisible.BACKGROUND_FILL);
      startbtn1.setBackground(Color.BLACK);
      
      scene.add(startbtn1);
      scene.popToFront(startbtn1);
      startbtn1.setActionCommand("start");
      startbtn1.addHActionListener(this);
      scene.validate();
      scene.setVisible(true);
      startbtn1.requestFocus();
    }
    public void showVragen()
    {
      vraag.setBackgroundMode(HVisible.BACKGROUND_FILL);
      vraag.setBackground(Color.BLACK);
      
      scene.add(vraag);
      
      btn1.setBackgroundMode(HVisible.BACKGROUND_FILL);
      btn1.setBackground(Color.BLACK);
      scene.add(btn1);
      
      btn2.setBackgroundMode(HVisible.BACKGROUND_FILL);
      btn2.setBackground(Color.BLACK);
      scene.add(btn2);
      
      btn3.setBackgroundMode(HVisible.BACKGROUND_FILL);
      btn3.setBackground(Color.BLACK);
      scene.add(btn3);
     
      btn4.setBackgroundMode(HVisible.BACKGROUND_FILL);
      btn4.setBackground(Color.BLACK);
      scene.add(btn4);
      
      btn1.requestFocus();      
      
      btn1.setFocusTraversal(null, btn2, null, btn3); //Boven Onder Links Rechts
      btn2.setFocusTraversal(btn1, null, null, btn4);
      btn3.setFocusTraversal(null, btn4, btn1, null);
      btn4.setFocusTraversal(btn3, null, btn2, null);
      
      btn1.setActionCommand("btn1");
      btn2.setActionCommand("btn2");
      btn3.setActionCommand("btn3");
      btn4.setActionCommand("btn4");
      
      btn1.addHActionListener(this);
      btn2.addHActionListener(this);
      btn3.addHActionListener(this);
      btn4.addHActionListener(this);
      
      scene.pushToBack(achtergr);
      scene.validate();
      scene.setVisible(true);
      
      wijzig_tekst(0);
    }

    public void startXlet() {
    
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }
    
    public void actionPerformed(ActionEvent arg0) {
     System.out.println(arg0.getActionCommand());
     if (arg0.getActionCommand().equals("start"))
     {
         scene.removeAll();
         
         scene.add(achtergr);
         scene.pushToBack(achtergr);
         scene.repaint();
         
         showVragen();
         return;
     }
    
     if(arg0.getActionCommand().equals("btn1")) {
         
         if (bevat(s1[vraagnr],'F')) { freddyKreuger++; }
         if (bevat(s1[vraagnr],'M')) { michaelMyers++; }
         if (bevat(s1[vraagnr],'J')) { jasonVoorhees++; }
         if (bevat(s1[vraagnr],'P')) { pennywise++; }
         if (bevat(s1[vraagnr],'G')) { ghostFace++; }
         if (bevat(s1[vraagnr],'L')) { leatherface++; }
         if (bevat(s1[vraagnr],'C')) { candyman++; }
         
        HStaticText antwoord = new HStaticText ("Fout", 200,150,280,50);
        antwoord.setBackgroundMode(HVisible.BACKGROUND_FILL);
        antwoord.setBackground(Color.RED);
        
        /*scene.add(antwoord);
        scene.popToFront(antwoord);
        scene.repaint();*/
     }
     else if(arg0.getActionCommand().equals("btn2")) {
         
         if (bevat(s2[vraagnr],'F')) { freddyKreuger++; }
         if (bevat(s2[vraagnr],'M')) { michaelMyers++; }
         if (bevat(s2[vraagnr],'J')) { jasonVoorhees++; }
         if (bevat(s2[vraagnr],'P')) { pennywise++; }
         if (bevat(s2[vraagnr],'G')) { ghostFace++; }
         if (bevat(s2[vraagnr],'L')) { leatherface++; }
         if (bevat(s2[vraagnr],'C')) { candyman++; }
         
        HStaticText antwoord = new HStaticText ("Fout", 200,150,280,50);
        antwoord.setBackgroundMode(HVisible.BACKGROUND_FILL);
        antwoord.setBackground(Color.RED);
        
        /*scene.add(antwoord);
        scene.popToFront(antwoord);
        scene.repaint();*/
     }
     else if(arg0.getActionCommand().equals("btn3")) {
         
         if (bevat(s3[vraagnr],'F')) { freddyKreuger++; }
         if (bevat(s3[vraagnr],'M')) { michaelMyers++; }
         if (bevat(s3[vraagnr],'J')) { jasonVoorhees++; }
         if (bevat(s3[vraagnr],'P')) { pennywise++; }
         if (bevat(s3[vraagnr],'G')) { ghostFace++; }
         if (bevat(s3[vraagnr],'L')) { leatherface++; }
         if (bevat(s3[vraagnr],'C')) { candyman++; }
         
        HStaticText antwoord = new HStaticText ("Fout", 200,150,280,50);
        antwoord.setBackgroundMode(HVisible.BACKGROUND_FILL);
        antwoord.setBackground(Color.RED);
        
        /*scene.add(antwoord);
        scene.popToFront(antwoord);
        scene.repaint();*/
     }
     else if(arg0.getActionCommand().equals("btn4")) {
         
         if (bevat(s4[vraagnr],'F')) { freddyKreuger++; }
         if (bevat(s4[vraagnr],'M')) { michaelMyers++; }
         if (bevat(s4[vraagnr],'J')) { jasonVoorhees++; }
         if (bevat(s4[vraagnr],'P')) { pennywise++; }
         if (bevat(s4[vraagnr],'G')) { ghostFace++; }
         if (bevat(s4[vraagnr],'L')) { leatherface++; }
         if (bevat(s4[vraagnr],'C')) { candyman++; }
         
        /*HStaticText antwoord = new HStaticText ("Juist", 200,150,280,50);
        antwoord.setBackgroundMode(HVisible.BACKGROUND_FILL);
        antwoord.setBackground(Color.GREEN);*/
        
        /*scene.add(antwoord);
        scene.popToFront(antwoord);
        scene.repaint();*/
 
     }
     
              
         System.out.println("michael="+michaelMyers);
         System.out.println("jason="+jasonVoorhees);
         System.out.println("pennywise="+pennywise);
         System.out.println("freddy="+freddyKreuger);
         System.out.println("ghostface="+ghostFace);
         System.out.println("leatherface="+leatherface);
         System.out.println("candyman="+candyman);
     
     plusTeller++;
     vraagnr++;
     if( plusTeller < 12)
     {
       wijzig_tekst(plusTeller);  
     }
     
     if( plusTeller==12)
     {
         scene.setBackgroundMode(HVisible.BACKGROUND_FILL);
         scene.setBackground(Color.BLACK);
         
         System.out.println("resultaat");
         if(jasonVoorhees > michaelMyers && jasonVoorhees > pennywise && jasonVoorhees > freddyKreuger && jasonVoorhees > ghostFace && jasonVoorhees > leatherface && jasonVoorhees > candyman)
         {
             scene.removeAll();
             scene.add(jason);
             scene.popToFront(jason);
             scene.repaint();
             
             scene.add(jasonEnd);
             scene.popToFront(jasonEnd);
             jasonEnd.setForeground(Color.RED);
             scene.repaint();
         }
         else if (michaelMyers > jasonVoorhees && michaelMyers > pennywise && michaelMyers > freddyKreuger && michaelMyers > ghostFace && michaelMyers > leatherface && michaelMyers > candyman)
         {
            scene.removeAll();
            scene.add(michael);
            scene.popToFront(michael);
            scene.repaint();  
            
            scene.add(michaelEnd);
            scene.popToFront(michaelEnd);
            michaelEnd.setForeground(Color.RED);
            scene.repaint();
         }
         else if (pennywise > jasonVoorhees && pennywise > michaelMyers && pennywise > freddyKreuger && pennywise > ghostFace && pennywise > leatherface && pennywise > candyman)
         {
            scene.removeAll();
            scene.add(penny);
            scene.popToFront(penny);
            scene.repaint();
            
            scene.add(pennyEnd);
            scene.popToFront(pennyEnd);
            pennyEnd.setForeground(Color.RED);
            scene.repaint();
         }
         else if (freddyKreuger > jasonVoorhees && freddyKreuger > michaelMyers && freddyKreuger > pennywise && freddyKreuger > ghostFace && freddyKreuger > leatherface && freddyKreuger > candyman)
         {
            scene.removeAll();
            scene.add(freddy);
            scene.popToFront(freddy);
            scene.repaint();
            
            scene.add(freddyEnd);
            scene.popToFront(freddyEnd);
            freddyEnd.setForeground(Color.RED);
            scene.repaint();
         }
         else if (ghostFace > jasonVoorhees && ghostFace > michaelMyers && ghostFace > pennywise && ghostFace > freddyKreuger && ghostFace > leatherface && ghostFace > candyman)
         {
            scene.removeAll();
            scene.add(ghostface);
            scene.popToFront(ghostface);
            scene.repaint();
            
            scene.add(ghostEnd);
            scene.popToFront(ghostEnd);
            ghostEnd.setForeground(Color.RED);
            scene.repaint();
         }
         else if (leatherface > jasonVoorhees && leatherface > michaelMyers && leatherface > pennywise && leatherface > freddyKreuger && leatherface > ghostFace && leatherface > candyman)
         {
            scene.removeAll();
            scene.add(leather);
            scene.popToFront(leather);
            scene.repaint();
            
            scene.add(leatherEnd);
            scene.popToFront(leatherEnd);
            leatherEnd.setForeground(Color.RED);
            scene.repaint();
         }
         else if (candyman > jasonVoorhees && candyman > michaelMyers && candyman > pennywise && candyman > freddyKreuger && candyman > ghostFace && candyman > leatherface)
         {
            scene.removeAll();
            scene.add(candy);
            scene.popToFront(candy);
            scene.repaint();
            
            scene.add(candyEnd);
            scene.popToFront(candyEnd);
            candyEnd.setForeground(Color.RED);
            scene.repaint();
         }
         else
         {
            scene.removeAll();
            scene.add(candy);
            scene.popToFront(candy);
            scene.repaint();
            
            scene.add(candyEnd);
            scene.popToFront(candyEnd);
            candyEnd.setForeground(Color.RED);
            scene.repaint();
         }
     }
     
    }

}