import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.Random;

/**
 * Write a description of class Basic here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Basic extends Enemy
{   
    GameScreen world;
    
    //MAKE A LEVEL COUNTER, SPEED WILL INCREASE ACCORDING TO LEVEL
    Random r = new Random();
    private int speed = r.nextInt(2) + 1;
    private String name = "Basic";
    GreenfootImage bomb = new GreenfootImage("explosion.png");
    GreenfootImage traf = getImage();
    
    //timer for bomb
    private int health = 15;
    int bombTimer = 25;
    int imageTimer = 50;
    int delay = 75;
    
    boolean touched = false;
    boolean continuing = true;
    HealthBar healthBar;
    int h = 1;

    public Basic() {
        traf.scale(35,35);
        setImage(traf);
    }
    
    public void addedToWorld(World world) {
        this.world = (GameScreen) world;
    }
    
    public void act() 
    {
        if(continuing) {
            attacked();
            follow();
            attack();
            dead();
        }
    }    
    
    @Override 
    public void follow() {
        //folllows the user
        if(touched == false) {
            GameScreen world = (GameScreen)getWorld();
            Zoro zor = world.getZoro();
            
            int x = zor.getX();
            int y = zor.getY();
            turnTowards(x, y);
            move(speed);
        }
    }
    
    @Override 
    public void attack() {
        //switch image to explosion plus add damage to player character
        if(isTouching(Zoro.class)) {
            setLocation(this.getX(), this.getY());
            touched = true;
        }
        if(touched == true) {
            if(bombTimer >= 0) {
                bombTimer--;
            }
        }
        if(bombTimer <= 0) {
            bomb.scale(40,40);
            setImage(bomb);
            imageTimer--;
            
            //damage
            Zoro zor = world.getZoro();
            
            if(this.intersects(zor)) {
                if(delay == 75) {
                    zor.dying();
                }
                delay = 0;
            }
        }
        if(imageTimer <= 0) {
            Spawner spawner = world.getSpawner();
            spawner.setEnemyCount(spawner.getEnemyCount() - 1);
            world.removeObject(healthBar);
            world.removeObject(this);
            continuing = false;
        }
    }
    
    @Override 
    public String getName() {
        return this.name;
    }
    
    @Override 
    public void dead() {
        //once dead have other classes react with (score and spawner)
        Score score = world.getScore();
        Spawner spawner = world.getSpawner();
        if(health <= 0) {
            world.removeObject(healthBar);
            spawner.setEnemyCount(spawner.getEnemyCount() - 1);
            score.setScore(score.getScore() + 1);
            score.setTotal(score.getTotal()+1);
            world.removeObject(this);
        }
    }
    
    @Override
    public void attacked() {
        //decrease health and have the healthbar react
        Zoro zoro = world.getZoro();
        if(isTouching(Zoro.class) && Greenfoot.isKeyDown("a")) {
            setHealth(getHealth()-zoro.getDamage());
            if(h == 1) {
                healthBar = new HealthBar(this, this.getHealth());
                world.addObject(healthBar, this.getX(), this.getY() - 45);
                h++; 
            }
            healthBar.loseHealth(zoro.getDamage());
        }
    }
    
    public void setHealth(int health) {
        this.health = health;
    }
    
    public int getHealth() {
        return health;
    }
}
