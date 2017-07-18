import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Try here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Try extends Actor
{
    /**
     * Act - do whatever the Try wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)) {
            GameScreen screen = new GameScreen();
            Greenfoot.setWorld(screen);
        }
    }    
}
