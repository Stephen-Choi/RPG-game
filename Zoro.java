import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zoro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zoro extends Actor
{
    private GreenfootImage slash = new GreenfootImage("zoro-slash.png");
    private GreenfootImage left = new GreenfootImage("zoro1.png");
    private GreenfootImage leftSlash = new GreenfootImage("zoro1-slash.png");
    GreenfootImage image = getImage();
    GameScreen world;
    
    boolean gettingHit = false;
    boolean isFacingLeft = false;
    int health = 3;
    int damage = 1;
    int baseSpeed = 2;
    int speed = 4;
    int cooldown = 100;
    boolean isAlive = true;
    boolean healthUp = false;

    public Zoro() {
        image.scale(70, 65);
        setImage(image);
    }

    public void addedToWorld(World world) {
        this.world = (GameScreen) world;
    }

    public void act() 
    {
        dead();
        if(isAlive) {
            facing();
            slash();
            move();
            goStore();
            if(gettingHit) {
                stopShield();
            }
        }
    }

    public void move() {
        //getting user inputs for the character
        int mover;
        if(Greenfoot.isKeyDown("s") && !Greenfoot.isKeyDown("a")) {
            mover = speed; 
        } else {
            mover = baseSpeed;
        }
        if(Greenfoot.isKeyDown("right")) {
            move(mover);
            isFacingLeft = false;
        } else if(Greenfoot.isKeyDown("left")) {
            move(-(mover));
            isFacingLeft = true;
        }   
        if(Greenfoot.isKeyDown("up")) {
            setLocation(this.getX(), this.getY() - mover);
        } else if(Greenfoot.isKeyDown("down")) {
            setLocation(this.getX(), this.getY() + mover);
        }
    }

    public void slash() {
        if(Greenfoot.isKeyDown("a") && !isFacingLeft){
            slash.scale(70, 65);
            setImage(slash);
        } else if (Greenfoot.isKeyDown("a") && isFacingLeft){
            leftSlash.scale(75,65);
            setImage(leftSlash);
        }
    }
    
    public void facing() {
        //switch image
        if(isFacingLeft) {
            left.scale(70,65);
            setImage(left);
        } else {
            image.scale(70,65);
            setImage(image);
        }
    }
    
    public void dying() {
        //make sure user cannot be hit consecutively
        Shield shield = world.getShield();
        if(!shield.isActive()) {
            health -= 1;
            gettingHit = true;
        } 
    }
    
    public void stopShield() {
        if(cooldown >= 0) {
            cooldown--;
        } else {
            gettingHit = false;
            cooldown = 100;
        }
    }
    
    public void goStore() {
        //enter the store
        if(Greenfoot.isKeyDown("w")) {
            Score score = world.getScore();
            Store store = new Store(score.getScore(), this, world.getShield(), world, world.getScore());
            Greenfoot.setWorld(store);
        }
    }
    
    public void dead() {
        if(health <= 0) {
            Score score = world.getScore();
            Death death = new Death();
            world.addObject(death, 25, 23);
            isAlive = false;
            world.removeObject(this);
            Greenfoot.delay(60);
            End end = new End(score.getTotal());
            Greenfoot.setWorld(end);
        }
    }
   
    public boolean getHit() {
        return gettingHit;
    }
    
    public void setHit(boolean b) {
        gettingHit = b;
    } 
    
    public int getHealth() {
        return health;
    }
    
    public void setHealth(int h) {
        health = h;
        healthUp = true;
    }
    
    public boolean getHealthUp() {
        return healthUp;
    }
    
    public void setHealthUp(boolean h) {
        healthUp = h;
    }
    
    public int getDamage() {
        return damage;
    }
    
    public void setDamage(int damage) {
        this.damage = damage;
    }
    
    public int getBaseSpeed() {
        return baseSpeed;
    }
    
    public void setBaseSpeed(int s) {
        baseSpeed = s;
    } 
    
    public int getSpeed() {
        return speed;
    }
    
    public void setSpeed(int s) {
        speed = s;
    } 
}
