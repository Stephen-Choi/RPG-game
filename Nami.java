import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Nami here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nami extends Actor
{
    GreenfootImage nami = getImage();
    Store store;
    
    public Nami() {
        nami.scale(420,250);
        setImage(nami);
    }
    
    public void addedToWorld(World world) {
        this.store = (Store) world;
    }
    
    public void act() 
    {
        returning();
    }    
    
    public void returning() {
        //method to return back to game
        if(Greenfoot.isKeyDown("/")) {
            GameScreen world = store.getScreen();
            Score score = store.getScore();
            world.addObject(score, 40, 480);
            Greenfoot.setWorld(world);
        }
    }
}
