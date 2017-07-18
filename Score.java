import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor
{
    int score = 0;
    int total = 0;
    
    public void act() 
    {
        setImage(new GreenfootImage("Beris: " + score, 18, Color.BLACK, Color.WHITE));
    }    
    
    public int getScore() {
        return score;
    }
    
    public void setScore(int score) {
        this.score = score;
    }
    
    public int getTotal() {
        return total;
    }
    
    public void setTotal(int t) {
        total = t;
    }
}
