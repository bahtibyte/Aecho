/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bahti.gui;

public class Player {
    
    private TimeHelper time;
    
    private int target;
    private boolean goingToTarget;
    
    private int x;
    private int y;
    int hp;
    private int speed = 5;
    
    public void setTarget(int x){
        target = x;
        goingToTarget = true;
    }
    
    public boolean reachedTarget(){
        boolean a = target > x - 5 && target < x + 5;
        if (a) 
        {
            goingToTarget = false;
            time.reset();
        
        }
        return a;
    }
    
    public void moveToTarget(){
        if (time.hasReached(1000)){
            if (x > target){
                x -= (int)(Math.random()*speed);
            }else{
                x += (int)(Math.random()*speed);
            }
        }
    }
    
    
    
    
    public Player(){
        time = new TimeHelper();
        x = 500;
        target = x;
        y = 550;
        hp = 3;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public void moveLeft(){
        x -= speed;
    }
    
    public void moveRight(){
        x += speed;
    }
    
    public void loseHP(){
        hp--;
    }
    
    public boolean isDead(){
        return hp == 0;
    }
    
    
}
