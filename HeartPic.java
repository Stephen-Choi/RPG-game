import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HeartPic here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HeartPic extends Actor
{
    GreenfootImage heart = getImage();
    
    public HeartPic() {
        heart.scale(50, 50);
        setImage(heart);
    }  
}
