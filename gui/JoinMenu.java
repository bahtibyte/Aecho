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
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JoinMenu extends Gui{

    private BufferedImage img = loadImage("assets/mainmenu/Aecho.jpg");
    private ImageIcon joinIcon = new ImageIcon(loadImage("assets/mainmenu/joingame.png"));
    
    private ImageIcon createIcon = new ImageIcon(loadImage("assets/mainmenu/createicon.png"));
    
    private JButton join;
    private JButton create;
    private JButton back;
    private JTextField customJoin;


    public JoinMenu() {
        super(1920,1080,"Main Menu");
        createGui();

            
        
        customJoin = new JTextField("Enter Invite Code:");
        customJoin.setSize(700,100);
        customJoin.setLocation((1920-700)/2, 250);
        customJoin.setFont(new Font("Ariel",Font.PLAIN,50));
        customJoin.setBackground(Color.cyan);
        add(customJoin);
        JButton buts[] = new JButton[5];
        for (int i = 0; i < 5; i++){
            buts[i] = new JButton();
            buts[i].setBorderPainted(false);
            buts[i].setFont(new Font("Ariel",Font.PLAIN,40));
            buts[i].setSize(550,75); 
            buts[i].setBackground(Color.cyan);
            buts[i].setLocation((1920-550)/2, 400 + ( i * 100));
            buts[i].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {startGame();}});
            add(buts[i]);
        }
        
        buts[0].setText("History            5/7");
        buts[1].setText("English            4/7");
        buts[2].setText("General           6/7");
        buts[3].setText("Math               2/7");
        buts[4].setText("Astronomy      5/7");
        
        back = new JButton("BACK");
        back.setBorderPainted(false);
        back.setSize(700,100);
        back.setLocation((1920 - 700 )  / 2,900);
        back.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {back();}});
        back.setFont(new Font("Ariel",Font.PLAIN,40));
        add(back);
        
        finishGui();


        loadAssets();
    }

    
    public void startGame(){
        Game.currentGui.switchTo(Game.mainGame);
    }
    
    public void onTick(){
        
    }
    
    private void back(){
        Game.currentGui.switchTo(Game.theMenu);
    }
    
    private void loadAssets() {

    }

    public void paintComponent(Graphics g) {
            g.drawImage(img, 0,0, img.getWidth(),img.getHeight(),null);

    }



}
