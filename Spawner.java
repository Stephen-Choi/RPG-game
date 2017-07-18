import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Spawner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spawner extends Actor
{
    GameScreen world;
    
    //increase difficulty
    private int level = 1;
    //queue for storage
    Queue<Integer> enemyList = new ArrayDeque<Integer>();
    //for incrementation purposes
    int enemyCount = 0;
    private boolean spawning;
    //make sure spawn does not land on character 
    int a = 1;

    public Spawner() {
        storage();
    }
    
    public void addedToWorld(World world) {
        this.world = (GameScreen) world;
    }
    
    public void act() 
    {
        shouldSpawn();
        spawn();
        increaseLevel();
    }    

    public void storage() {
        //have a stack that will be randomly filled with letters, each will correspond to an enemy
        Random r = new Random();

        for(int i = 0; i < 1000; i++) {
            int enemy = r.nextInt(3);
            enemyList.add(enemy);
        }
    }

    public void spawn() {
        Random rand = new Random();
        
        //using the random number to spawn the different enemies
        if(spawning) {
            GameScreen world = (GameScreen) getWorld();
            int enemyId = enemyList.remove();
            Actor identity;
    
            if (enemyId == 0) {
                identity = new Basic();
            } else if(enemyId == 1) {
                identity = new Sniper(); 
            } else {
                identity = new Soldier();
            }
            
            if(a < 4) {
                world.addObject(identity, 700, rand.nextInt(500));
                a++;
                enemyCount++;
            } else {
                world.addObject(identity, rand.nextInt(800), rand.nextInt(500));
                enemyCount++;
            }
        }
    }

    public void shouldSpawn() {
        if(enemyCount <= 1+level) {
            spawning = true;
        } else {
            spawning = false;
        }
    }

    public void setEnemyCount(int count) {
        enemyCount = count;
    }

    public int getEnemyCount() {
        return enemyCount;
    }
    
    public void increaseLevel() {
        //increase difficulty 
        Score score = world.getScore();
        if(score.getTotal() > 11 && level == 1) {
            level++;
        } else if(score.getTotal() > 25 && level == 2) {
            level++;
        } else if(score.getTotal() > 50 && level == 3) {
            level++;
        } else if(score.getTotal() > 75 && level == 4) {
            level++;
        } else if(score.getTotal() > 100 && level == 5) {
            level++;
        } else if(score.getTotal() > 150 && level == 6) {
            Win win = new Win();
            Greenfoot.setWorld(win);
        }
    }
}