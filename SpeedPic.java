import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DamagePic here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpeedPic extends Actor
{
    GreenfootImage speed = getImage();
    
    public SpeedPic() {
        speed.scale(75, 75);
        setImage(speed);
    }
}
