import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TipsButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TipsButton extends Actor
{
    //move to tip world
    GreenfootImage img = getImage();
    public TipsButton() {

    }
    
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)) {
            Tips tips = new Tips();
            Greenfoot.setWorld(tips);
        }
    }    
}
