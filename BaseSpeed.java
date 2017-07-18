import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Health here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BaseSpeed extends Button
{
    //increments stats
    Store store;
    int points;
    int x = 273;
    
    public BaseSpeed() {
        super("Base-Speed Boost");
    }  
    
    public void addedToWorld(World world) {
        this.store = (Store) world;
    }
    
    @Override 
    public void click() {
        points = store.getPoints();
        if(points >= 5) {
            //display
            store.addObject(new SpeedPic(), x, 430);
            x += 65;
            store.setPoints(points - 5);
            //increase stats
            Zoro zoro = store.getZoro();
            zoro.setBaseSpeed(zoro.getBaseSpeed() + 1);
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
