import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Soldier here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Soldier extends Enemy
{
    //Basic specs
    GameScreen world;
    private int speed = 1;
    private String name = "Soldier";
    GreenfootImage kidAttack = new GreenfootImage("kidd.png");
    GreenfootImage kid  = getImage();
    GreenfootImage kidLeft = new GreenfootImage("kid1.png");

    int delay = 75;  //death
    int cooldown = 75;  //when to pop back  
    private int health = 90;
    boolean inRadius = false; 
    int h = 1;
    HealthBar healthBar;

    public Soldier() {
        kid.scale(65,50);
        setImage(kid);
    }

    public void addedToWorld(World world) {
        this.world = (GameScreen) world;
    }

    public void act() 
    {
        follow();
        //turn();
        getRange();
        attack();
        attacked();
        dead();
    }    

    @Override 
    public void follow() {
        //follow user
        if(!inRadius) {
            Zoro zor = world.getZoro();

            int x = zor.getX();
            int y = zor.getY();
            turnTowards(x, y);
            move(speed);
        }
    }

    @Override 
    public void attack() {
        //cooldown so cannot attack non-stop
        if(inRadius && cooldown >= 50) {
            kidAttack.scale(65,60);
            setImage(kidAttack);
            cooldown--;
            if(cooldown <= 50) {
                cooldown = 0;
            }
            //damage
            Zoro zor = world.getZoro();
            if(this.intersects(zor)) {
                if(delay >= 75) {
                    zor.dying();
                }
                delay = 0;
            }
        } else {
            setImage(kid);
            cooldown++;
        }
        delay++;
    }

    @Override 
    public String getName() {
        return this.name;
    }

    @Override 
    public void dead() {
        if(health <= 0) {
            world.removeObject(healthBar);
            Spawner spawner = world.getSpawner();
            Score score = world.getScore();
            spawner.setEnemyCount(spawner.getEnemyCount() - 1);
            score.setScore(score.getScore() + 3);
            score.setTotal(score.getTotal()+3);
            world.removeObject(this);
        }
    }

    @Override
    public void attacked() {
        //lose health when hit
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

    public void getRange() {
        //see if soldier is getting towards the user
        Zoro zoro = world.getZoro();

        if(this.getX() >= zoro.getX() && this.getX() >= zoro.getY()) {
            if((this.getX() - zoro.getX()) < 50 && (this.getY() - zoro.getY()) <= 50) {
                inRadius = true;
            } else {
                inRadius = false;
            }
        } else if(this.getX() <= zoro.getX() && this.getY() <= zoro.getY()) {
            if((zoro.getX() - this.getX()) < 50 && (zoro.getY() - this.getY()) < 50) {
                inRadius = true;
            } else {
                inRadius = false;
            }
        } else if(this.getX() <= zoro.getX() && this.getY() >= zoro.getY()){
            if((zoro.getX() - this.getX()) < 50 && (this.getY() - zoro.getY()) < 50) {
                inRadius = true;
            } else {
                inRadius = false;
            }
        } else {
            if((this.getX() - zoro.getX()) < 50 && (zoro.getY() - this.getY()) < 50) {
                inRadius = true;
            } else {
                inRadius = false;
            }
        }
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }
}
