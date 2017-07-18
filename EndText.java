import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class EndText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndText extends Actor
{
    End end;
    int x = 0;
    Color color = new Color(117,201,187);
    //FIND THE RGB 
    
    public void addedToWorld(World world) {
        this.end = (End) world;
    }
    
    public void act() 
    {
        setX();
        setImage(new GreenfootImage("Total Score: " + x, 30, Color.BLACK, color));
    }    
    
    public void setX() {
        x = end.getTotal();
    }
}
