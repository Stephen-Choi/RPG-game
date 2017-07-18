import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Next here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Next1 extends Actor
{
    //class to move along the instruction screens
    GreenfootImage img = getImage();
    
    public Next1() {
        img.scale(110,110);
        setImage(img);
    }
    
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)) {
            click();
        }
    }    
    
    public void click() {
        getWorld().removeObject(this);
        Greenfoot.setWorld(new Enemies());
    }
}
