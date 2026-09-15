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

import window.*;

public class Character extends Glyph {
    // variable declarations
    private char c;

    /* Constructors */
    public Character(char ch){
        super(0, 0, 0,0);
        c = ch;
    }

    /**
     * Draws the Character in the given window.
     * @param window : where character will be drawn.
     */
    public void draw(Window window){
        window.drawCharacter(c, bounds.getX(), bounds.getY());
    }
    
    /**
     * Set width and height of Character
     * @param window : window character is located in.
     */
    public void setSize(Window window) {
        bounds.setHeight(window.charHeight(c));
        bounds.setWidth(window.charWidth(c));
    }

}
