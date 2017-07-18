import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameScreen extends World
{
    //Creating character 
    Zoro zoro = new Zoro();
    Shield shield = new Shield();
    Spawner spawner = new Spawner();
    Lives lives = new Lives();
    Score score = new Score();
    
    public GameScreen() {    
           super(800, 500, 1); 
            // tile map 
           int[][] map =  { {1, 1, 1, 1, 1, 1, 1, 1, 1},
                            {1, 0, 0, 0, 0, 0, 0, 0, 1},
                            {1, 0, 0, 0, 0, 0, 0, 0, 1},
                            {1, 0, 0, 0, 0, 0, 0, 0, 1},
                            {1, 0, 0, 0, 0, 0, 0, 0, 1},
                            {1, 0, 0, 0, 0, 0, 0, 0, 1},
                            {1, 0, 0, 0, 0, 0, 0, 0, 1},
                            {1, 0, 0, 0, 0, 0, 0, 0, 1},
                            {1, 1, 1, 1, 1, 1, 1, 1, 1},
                          };  
           //values to position
           int mapWidth = this.getWidth() - 32;
           int mapHeight = this.getHeight() - 20;
            
           //adding tiles to world
           for(int i = 0; i < map.length; i++) {
                for(int j = 0; j < map.length; j++) {
                    if(map[i][j] == 0) {
                        addObject(new Tile(), mapWidth, mapHeight);
                        mapHeight =  mapHeight - 57;
                    } else if(map[i][j] == 1) {
                        addObject(new Water(), mapWidth, mapHeight);
                        mapHeight =  mapHeight - 57;
                    }
                }
                mapWidth = this.getWidth() - (92 * (i + 1)) - 32;
                mapHeight = this.getHeight() - 20;
           }
           
           addObject(zoro, 200, 200);
           addObject(shield, 0, 0);
           addObject(lives, 0, 0);
           addObject(spawner, 0, 0);
           addObject(score, 40, 480);
    }
    
    public Zoro getZoro() {
        return zoro;
    }
    
    public Shield getShield() {
        return shield;
    }
    
    public Spawner getSpawner() {
        return spawner;
    }
    
    public Lives getLives() {
        return lives;
    }
    
    public Score getScore() {
        return score;
    }
}
