import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DamagePic here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DamagePic extends Actor
{
    GreenfootImage sword = getImage();
    
    public DamagePic() {
        sword.scale(60, 55);
        setImage(sword);
    }
}
