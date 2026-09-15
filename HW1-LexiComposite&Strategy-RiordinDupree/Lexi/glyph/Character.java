/**
 * Function defines a Character for the Lexi editor.
 * 
 * Character is a type of Glyph, so it extends generic class 'Glyph.java'.
 * 
 * Class uses the Composite(163) design pattern. 
 *  - It represents a "Leaf" from the pattern.
 * 
 * @author Riordin Dupree
 */

package glyph;

import point.*;
import window.*;

public class Character extends Glyph {
    // variable declarations
    private char c;
    public Bounds bounds;

    /* Constructors */
    public Character(char ch){
        c = ch;
        Point point = new Point(0, 0);
        bounds = new Bounds(point, 0, 0);
    }

    /**
     * Draws the Character in the given window.
     * @param window : where character will be drawn.
     */
    public void draw(Window window){
        window.drawCharacter(c, bounds.getX(), bounds.getY());
    }
    
    /**
     * Function sets position of the character
     * @param x : x coordinate for character
     * @param y : y coordinate for character
     */
    public void setPosition(int x, int y){ 
        bounds.setX(x); 
        bounds.setY(y);
    }
    
    /**
     * Set width and height of Character
     * @param window : window character is located in.
     */
    public void setSize(Window window){
        bounds.setHeight(window.charHeight(c));
        bounds.setWidth(window.charWidth(c));
    }

    /** 
     * returns the bounds of the Character.
     * @return the Bounds of a Character
     */
    public Bounds getBounds(){ return bounds; }
}
