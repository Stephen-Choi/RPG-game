import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DamagePic here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShieldPic extends Actor
{
    GreenfootImage shield = getImage();
    
    public ShieldPic() {
        shield.scale(85, 85);
        setImage(shield);
    }
}
