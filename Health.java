import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Health here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Health extends Button
{
    Store store;
    int points;
    int x = 280;
    
    public Health() {
        super("Health Boost");
    }  
    
    public void addedToWorld(World world) {
        this.store = (Store) world;
    }
    
    @Override 
    public void click() {
        points = store.getPoints();
        if(points >= 5) {
            store.addObject(new HeartPic(), x, 70);
            x += 65;
            store.setPoints(points - 5);
            //increase stats
            Zoro zoro = store.getZoro();
            zoro.setHealth(zoro.getHealth() + 1);
            //make score adjustments in GameScreen 
            Score score = store.getScore();
            score.setScore(score.getScore() - 5);
        } else {
            //display error
            NotEnough not = store.getNot();
            not.setGood(false);
            //not.display();
        }
    }
}
