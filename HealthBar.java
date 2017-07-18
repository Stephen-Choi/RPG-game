import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * HealthBar class for battle worlds and map world
 *
 * @Jon and Stephen
 * @April 18th, 2017
 */
public class HealthBar extends Actor
{
    private int health = 1;
    private int healthWidth = 1;
    private int healthHeight = 20;
    private int pixelsPerHealth = (int)healthWidth/health;
    private int red = 0;
    private int green = 255;
    int healthLoss = 0;
    int x = 75;
    
    Actor actor;
 
    public HealthBar(Actor actor, int health){
        this.actor = actor;
        this.health = health + 1;
        healthWidth = health;
    }
 
    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        if (red > 255){
            red = 255;
        }
        if (green < 0){
            green = 0;
        }
        display();
        track();
    }    
 
    public void display(){
        // creates healthBar based on given variables above
        setImage (new GreenfootImage(healthWidth + 2, healthHeight + 2));
        GreenfootImage img = getImage();
        img.setColor(Color.gray);
        img.drawRect(0, 0, health, healthHeight);
        img.setColor(new Color(red, green, 0));
        img.fillRect(1, 1,  healthWidth - healthLoss, healthHeight);
    }
 
    public void loseHealth(int n){
        //decrease health and changes colour of health
        healthLoss += n;
        if (red >= 255){
            red = 255;
        }else{
            red += n + 20;
        }
 
        if (green <= 0){
            green = 0;
        }else{
            green -= n + 20;
        }
    }
    
    public void track() {
        this.setLocation(actor.getX(), actor.getY() - 45);
    }
}