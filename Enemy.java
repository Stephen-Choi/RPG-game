import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Enemy extends Actor
{    
    public abstract void follow();
    
    public abstract void attack();
    
    public abstract String getName();
    
    public abstract void dead();
    
    public abstract void attacked();
    
    public void act() 
    {
        
    }
}
