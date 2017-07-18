import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.awt.Color;

/**
 * A abstract, clickable object that handle user-input.
 * 
 * @author Jonathan Chak and Stephen Choi  
 * @version April 8, 2017
 */
public abstract class Button extends Actor {
    //color of choosing
    Color colour = new Color(0, 174, 239, 0);

    public Button(String text) {
        setImage(new GreenfootImage(text, 24, Color.BLACK, colour));
    }

    public abstract void click();

    @Override
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            click();
        }
    }

}

