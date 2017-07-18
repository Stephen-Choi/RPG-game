import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * //increments stats
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Speed extends Button
{
    Store store;
    int points;
    int x = 273;
    
    public Speed() {
        super("Speed Boost");
    }  
    
    public void addedToWorld(World world) {
        this.store = (Store) world;
    }
    
    @Override 
    public void click() {
        points = store.getPoints();
        if(points >= 5) {
            store.addObject(new SpeedPic(), x, 340);
            x += 65;
            store.setPoints(points - 5);
            //increase stats
            Zoro zoro = store.getZoro();
            zoro.setSpeed(zoro.getSpeed() + 1);
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
