import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Heart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Heart extends Actor
{
    GreenfootImage heart = getImage();
    GameScreen world;
    
    public Heart() {
        heart.scale(40,40);
        setImage(heart);
    }
    
    public void addedToWorld(World world) {
        this.world = (GameScreen) world;
    }
}
