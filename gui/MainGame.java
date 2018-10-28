/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bahti.gui;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainGame extends Gui implements KeyListener {

    private Player thePlayer;
    
    private BufferedImage img = loadImage("assets/mainmenu/Aecho.jpg");
    private BufferedImage island = loadImage("assets/game/island.png");
    private BufferedImage bridge = loadImage("assets/game/bridge.png");
    private BufferedImage smiley = loadImage("assets/game/smiley.png");
    
    private BufferedImage enemy = loadImage("assets/game/enemy.png");
    
    private JTextArea question;
    private JTextArea A;
    private JTextArea B;
    private JTextArea C;
    private JTextArea D;
    private JLabel countdown;
    
    private Player[] ais = new Player[4];
    
    public MainGame() {
        super(1920,1080,"Main Game");
        createGui();
        
        for (int i = 0; i < ais.length; i++){
            ais[i] = new Player();
        }

        question = new JTextArea();
        question.setSize(900,200);
        question.setLocation((1920-900)/2, 150);
        question.setEnabled(false);
        question.setFont(new Font("Ariel",Font.PLAIN,50));
        question.setForeground(Color.WHITE);
        question.setBackground(Color.BLACK);
        add(question);
        
        A = new JTextArea();
        A.setSize(300,300);
        A.setLocation(25, 775);
        A.setEnabled(false);
        A.setFont(new Font("Ariel",Font.PLAIN,30));
        A.setForeground(Color.WHITE);
        A.setBackground(Color.BLACK);
        add(A);
        
        B = new JTextArea();
        B.setSize(300,300);
        B.setLocation(550, 775);
        B.setEnabled(false);
        B.setFont(new Font("Ariel",Font.PLAIN,30));
        B.setForeground(Color.WHITE);
        B.setBackground(Color.BLACK);
        add(B);
        
        
        C = new JTextArea();
        C.setSize(300,300);
        C.setLocation(1075, 775);
        C.setEnabled(false);
        C.setFont(new Font("Ariel",Font.PLAIN,30));
        C.setForeground(Color.WHITE);
        C.setBackground(Color.BLACK);
        add(C);
        
        D = new JTextArea();
        D.setSize(300,300);
        D.setLocation(1600, 775);
        D.setEnabled(false);
        D.setFont(new Font("Ariel",Font.PLAIN,30));
        D.setForeground(Color.WHITE);
        D.setBackground(Color.BLACK);
        add(D);
        
        
        
        super.gui.addKeyListener(this);
        finishGui();

        loadAssets();
        
        thePlayer = new Player();
    }

    private boolean playing = false;
    Questions q;

    public void newQuestion(){
        ArrayList<Questions> questions = HackAttackMain.ques;
        
        int ran=(int)(Math.random()*questions.size());
        q = questions.get(ran);
        questions.remove(ran);
        question.setText(q.getQuestion());
        A.setText(q.getAnswer(0));
        B.setText(q.getAnswer(1));
        C.setText(q.getAnswer(2));
        D.setText(q.getAnswer(3));
    
    }
    
    private TimeHelper time = new TimeHelper();
    
    public void moveAis(){
        for (Player player : ais){
            if (player.reachedTarget()){
                player.setTarget( (int)(Math.random()*1900)+50);
            }else{
                player.moveToTarget();
            }
        }
    }
    
    public void onTick(){
        
        
        if (!playing && time.hasReached(3000)){
            newQuestion();
            playing = true;
            time.reset();
        }
        
        if (playing){
            moveAis();
                A.setBackground(Color.BLACK);
                B.setBackground(Color.BLACK);
                C.setBackground(Color.BLACK);
                D.setBackground(Color.BLACK);
            if (time.hasReached(10000)){
                playing = false;
                time.reset();
                
                int correct = q.answer;
                
                A.setText("WRONG");
                B.setText("WRONG");
                C.setText("WRONG");
                D.setText("WRONG");
                
                if (correct == 0){
                    A.setText(q.getAnswer(correct));
                    A.setBackground(Color.green);
                }
                if (correct == 1){
                    B.setText(q.getAnswer(correct));
                    B.setBackground(Color.green);
                }
                if (correct == 2){
                    C.setText(q.getAnswer(correct));
                    C.setBackground(Color.green);
                }
                if (correct == 3){
                    D.setText(q.getAnswer(correct));
                    D.setBackground(Color.green);
                }
                
                
                int x = thePlayer.getX();
                boolean userDead = true;
                if (x < 250 && correct == 0){
                    userDead = false;
                }else if (x > 510 && x < 790 && correct == 1){
                    userDead = false;
                }else if (x > 1050 && x < 1310 && correct == 1){
                    userDead = false;
                }else if (x > 1550 && correct == 1){
                    userDead = false;
                }
                
                if (userDead) {
                    thePlayer.loseHP();
                }
                
                super.gui.setTitle("Current HP: "+thePlayer.hp);
                
                if (thePlayer.isDead()){
                    Game.currentGui.switchTo(Game.theMenu);
                    thePlayer = new Player();
                    new HackAttackMain();
                }
            }
        }
        
        
        if (left){
            thePlayer.moveLeft();
        }
        
        if (right){
            thePlayer.moveRight();
        }
    }
    
    private void loadAssets() {

    }

    public void paintComponent(Graphics g) {
        g.drawImage(img, 0,0, img.getWidth(),img.getHeight(),null);
        double scaled = 2;
        double bridgeScaled = 9;
        
        int yAxis = 375;
        
        g.drawImage(island, -75,yAxis, (int)(island.getWidth() / scaled),(int)(island.getHeight() / scaled),null);
        g.drawImage(island, 445,yAxis, (int)(island.getWidth() / scaled),(int)(island.getHeight() / scaled),null);
        g.drawImage(island, 960,yAxis, (int)(island.getWidth() / scaled),(int)(island.getHeight() / scaled),null);
        g.drawImage(island, 1475,yAxis, (int)(island.getWidth() / scaled),(int)(island.getHeight() / scaled),null);
        
        g.drawImage(bridge, 275,550, (int)(bridge.getWidth() / bridgeScaled),(int)(bridge.getHeight() / bridgeScaled),null);
        
        g.drawImage(bridge, 275+1050,550, (int)(bridge.getWidth() / bridgeScaled),(int)(bridge.getHeight() / bridgeScaled),null);
        g.drawImage(bridge, 275+525,550, (int)(bridge.getWidth() / bridgeScaled),(int)(bridge.getHeight() / bridgeScaled),null);
    
        //g.drawImage(smiley, thePlayer.getX(), thePlayer.getY(), smiley.getWidth() /2,smiley.getHeight()/2,null);
        
        for (Player player : ais){
            g.drawImage(enemy, player.getX(), player.getY(), enemy.getWidth() /25,enemy.getHeight()/25,null);
        }
        g.drawImage(smiley, thePlayer.getX(), thePlayer.getY(), smiley.getWidth() /2,smiley.getHeight()/2,null);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    boolean left = false;
    boolean right = false;
    
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'a'){
            left = true;
        }
        if (e.getKeyChar() == 'd'){
            right = true;
        }
        
        
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
        if (e.getKeyChar() == 'a'){
            left = false;
        }
        if (e.getKeyChar() == 'd'){
            right = false;
        }
    
    }



}
