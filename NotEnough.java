import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class NotEnough here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NotEnough extends Actor
{
    //class to show user that not enough points have been accumulated
    GreenfootImage error;
    boolean good = true;
    
    public NotEnough() {
        setImage(new GreenfootImage("You need 5 points to upgrade", 24, Color.BLUE, Color.BLACK));
    }   
    
    public void act(){
        if(good) {
            hide();
        } 
        
        if(good == false) {
            display();
        }
    }

    public void display() {
        error = getImage();
        error.setTransparency(250);
    }
    
    public void hide() {
        error = getImage();
        error.setTransparency(0);
    }
    
    public void setGood(boolean good) {
        this.good = good;
    }
    
    public boolean getGood() {
        return good;
    }
}
