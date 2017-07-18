import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sniper here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sniper extends Enemy
{
    //info
    String name = "sniper";
    GreenfootImage appo = getImage();
    GreenfootImage appoLeft = new GreenfootImage("appo1.png");
    int health = 75;
    GameScreen world;
    //setup info
    int timer = 150;
    int h = 1;
    HealthBar healthBar;
    
    public Sniper() {
        appo.scale(70,65);
        setImage(appo);
    }
    
    public void addedToWorld(World world) {
        this.world = (GameScreen) world;
    }
    
    public void act() 
    {
        follow();
        attack();
        attacked();
        dead();
    }    
    
    @Override 
    //aim where the user is to fire
    public void follow() {
        Zoro zor = world.getZoro();
            
        int x = zor.getX();
        int y = zor.getY();
        turnTowards(x, y);
    }
    
    @Override
    public void attack() {
        if(timer <= 0) {
            fire();
            timer = 150;
        } else {
            timer--;
        }
    }
    
    public void fire() {
        Bullet bullet = new Bullet();
        bullet.setRotation(getRotation());
        world.addObject(bullet, this.getX(), this.getY());
    }
    
    @Override
    public String getName(){
        return this.name;
    }
    
    @Override
    public void dead() {
        if(health <= 0) {
            world.removeObject(healthBar);
            Spawner spawner = world.getSpawner();
            Score score = world.getScore();
            spawner.setEnemyCount(spawner.getEnemyCount() - 1);
            score.setScore(score.getScore() + 2);
            score.setTotal(score.getTotal()+2);
            world.removeObject(this);
        }
    }
    
    @Override
    public void attacked() {
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
