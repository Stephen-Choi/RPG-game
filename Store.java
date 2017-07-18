import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Store here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Store extends World
{
    int points = 0;
    NotEnough not = new NotEnough();
    Zoro zoro;
    Shield shield;
    GameScreen world;
    Score score;
    
    public Store(int points, Zoro zoro, Shield shield, GameScreen world, Score score)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 500, 1); 
        this.points = points;
        this.zoro = zoro; 
        this.shield = shield;
        this.world = world;
        this.score = score;
        
        addObject(new Nami(), 600, 375);
        addObject(new Health(), 150, 65);
        addObject(new Damage(), 143, 155);
        addObject(new ShieldBoost(), 121, 245);
        addObject(new Speed(), 153, 335);
        addObject(new BaseSpeed(), 122, 425);
        addObject(not, 400, 480);
        addObject(score, 40, 480);
    }
    
    public int getPoints() {
        return points;
    }
    
    public void setPoints(int points) {
        this.points = points;
    }
    
    public NotEnough getNot() {
        return not;
    }
    
    public Zoro getZoro() {
        return zoro;
    }
    
    public Shield getShield() {
        return shield;
    }
    
    public GameScreen getScreen() {
        return world;
    }
    
    public Score getScore() {
        return score;
    }
}
