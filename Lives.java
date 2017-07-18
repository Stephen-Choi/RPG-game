import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Lives here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lives extends Actor
{
    GameScreen world;
    int x = 25;
    int y = 23;
    int heartCounter = 0;
    int curHealth;

    //arraylist idea didnt end up having time to do
    List<String> letterList = new ArrayList<String>();
    String letters = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z";
    String seperated[] = letters.split(",");
    String cur;
    String name;

    public Lives() {
        nameHelper();
    }

    public void act() 
    {
        liveCounter();
        upgrade();
    }    

    public void addedToWorld(World world) {
        this.world = (GameScreen) world;
    }

    public void nameHelper() {
        for(int i = 0; i < seperated.length; i++) {
            cur = "heart" + seperated[i];
            letterList.add(cur);
        }
    }

    public void liveCounter() {
        //creates hearts everytime health increases (from upgrade)
        Zoro zoro = world.getZoro();
        for(int i = 0; i < zoro.getHealth(); i++) {
            if(heartCounter < zoro.getHealth()) {
                //have easier access to the heart Objects added to world 
                name = letterList.get(i);
                Heart name = new Heart();
                world.addObject(name, x, y);
                x += 53;
                heartCounter++;
                curHealth = zoro.getHealth();
            }
        }

        //creates a death img over heart everytime health is lost
        if(curHealth > zoro.getHealth()) {
            world.addObject(new Death(), x - 53, y);
            x -= 53;
            curHealth = zoro.getHealth();
        }
    }

    public int getHearts() {
        return heartCounter;
    }

    public void setHearts(int heartCounter) {
        this.heartCounter = heartCounter;
    }

    public void upgrade() {
        //fixing certain heart spawn issues
        Zoro zoro = world.getZoro();
        if(zoro.getHealthUp()) {
            Heart name = new Heart();
            world.addObject(name, x, y);
            x += 53;
            //stop increasing
            zoro.setHealthUp(false);
            curHealth = zoro.getHealth();
        }
    }
}
