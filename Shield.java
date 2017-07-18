import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shield here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shield extends Actor
{
    GreenfootImage shield = getImage();
    boolean active = false;
    GameScreen world;
    
    int timer = 150;
    
    public Shield() {
        shield.scale(100,100);
        shield.setTransparency(0);
        setImage(shield);
    }
    
    public void addedToWorld(World world) {
        this.world = (GameScreen) world;
    }
    
    public void act() 
    {
        activate();
        track();
    }    
    
    public void activate() {
        //Helper to activate shield
        Zoro zor = world.getZoro();
        if((Greenfoot.isKeyDown("d") && timer >= 0) || zor.getHit()) {
            active = true;
            timer -= 3;
        } else {
            active = false;
        }
        
        timer++;
    }
    
    public void track() {
        //method to make shield active and keep shield on the character 
        if(active) {
            Zoro zor = world.getZoro();
            shield.setTransparency(100);
            
            this.setLocation(zor.getX() - 4, zor.getY() + 4);
        } else {
            shield.setTransparency(0);
        }
    }
    
    public boolean isActive() {
        return active;
    }
    
    public void setActive(boolean active) {
        this.active = active;
    }
    
    public int getCooldown() {
        return timer;
    }
    
    public void setCooldown(int t) {
        timer = t;
    }
}
