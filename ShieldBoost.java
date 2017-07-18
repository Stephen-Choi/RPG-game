import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Health here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShieldBoost extends Button
{
    Store store;
    int points;
    int x = 272;
    
    public ShieldBoost() {
        super("Shield-Time Boost");
    }  
    
    public void addedToWorld(World world) {
        this.store = (Store) world;
    }
    
    @Override 
    public void click() {
        points = store.getPoints();
        if(points >= 5) {
            store.addObject(new ShieldPic(), x, 250);
            x += 65;
            store.setPoints(points - 5);
            //increase stats
            Shield shield = store.getShield();
            shield.setCooldown(shield.getCooldown() + 25);
            //make score adjustments in GameScreen 
            Score score = store.getScore();
            score.setScore(score.getScore() - 5);
        } else {
            //display error
            NotEnough not = store.getNot();
            not.setGood(false);
            not.display();
        }
    }
}