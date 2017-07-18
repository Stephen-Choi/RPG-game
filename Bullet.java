import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    GreenfootImage music = getImage();
    GreenfootImage bomb = new GreenfootImage("explosion.png");

    int speed = 3;
    int delay = 50;
    boolean isRemove = false;
    boolean run = true;

    public Bullet() {
        music.scale(65,60);
        setImage(music);
    }

    public void act() 
    {
        if(run) {
            move(speed);
            damage();
            off();
            if(isRemove) {
                remove();
            }
        }
    }    

    public void off() {
        if(this.getX() <= 0 || this.getY() <= 0 || this.getX() > 790 || this.getY() > 490) {
            GameScreen world = (GameScreen)getWorld();
            world.removeObject(this);
        }
    }

    public void damage() {
        GameScreen world = (GameScreen)getWorld();
        Zoro zor = world.getZoro();

        if(this.intersects(zor)) {
            zor.dying();
            bomb.scale(65,60);
            setImage(bomb);
            speed = 0;
            isRemove = true;
        }
    }
    
    public void remove() {
        GameScreen world = (GameScreen)getWorld();
        if(delay <= 0) {
            world.removeObject(this);
            run = false;
        } else {
            delay--;
        }
    }
}
