package bahti.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MainMenu extends Gui{

    private BufferedImage img = loadImage("assets/mainmenu/Aecho.jpg");
    private ImageIcon joinIcon = new ImageIcon(loadImage("assets/mainmenu/joingame.png"));
    
    private ImageIcon createIcon = new ImageIcon(loadImage("assets/mainmenu/createicon.png"));
    
    private JButton join;
    private JButton create;


    public MainMenu() {
        super(1920,1080,"Main Menu");
        createGui();

        new HackAttackMain();
        
        join = new JButton();
        join.setBorderPainted(false);
        join.setContentAreaFilled(false);
        join.setSize(700,300);
        join.setLocation((1920 - 700 )  / 2,250);
        join.setIcon(joinIcon);
        join.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {joinGame();}});
        add(join);
        
        create = new JButton();
        create.setBorderPainted(false);
        create.setContentAreaFilled(false);
        create.setSize(1059,302);
        create.setLocation((1920 - 1059 )  / 2,600);
        create.setIcon(createIcon);
        create.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {createGame();}});
        add(create);
            
        finishGui();

        reveal();

        loadAssets();
    }

    
    public void onTick(){
        
    }
    
    private void joinGame(){
        Game.currentGui.switchTo(Game.joinMenu);
    }
    
    private void createGame() {
        
        Game.currentGui.switchTo(Game.createMenu);
    }
    
    private void loadAssets() {

    }

    public void paintComponent(Graphics g) {
            g.drawImage(img, 0,0, img.getWidth(),img.getHeight(),null);

    }



}
