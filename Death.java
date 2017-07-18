import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Death here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Death extends Actor
{
    GreenfootImage death = getImage();
    GameScreen world;
    
    public Death() {
        death.scale(40,40);
        setImage(death);
    }
    
    public void addedToWorld(World world) {
        this.world = (GameScreen) world;
    }
    
    public void act() 
    {
        
    }   
}
