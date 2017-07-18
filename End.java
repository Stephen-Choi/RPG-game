import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class End here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class End extends World
{
    int total;
    public End(int total)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 500, 1); 
        this.total = total;
        addObject(new EndText(), 200, 400);
        addObject(new Try(), 405, 400);
        addObject(new TipsButton(), 625, 400);
    }
    
    public int getTotal() {
        return total;
    }
}
