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

import command.Command;
import point.*;
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
    @Override
    public void draw(Window window){
        Bounds bounds = this.getBounds();
        window.drawCharacter(c, bounds.getX(), bounds.getY());
    }
    
    /**
     * Set width and height of Character
     * @param window : window character is located in.
     */
    @Override
    public void setSize(Window window) {
        Bounds bounds = this.getBounds();
        bounds.setHeight(window.charHeight(c));
        bounds.setWidth(window.charWidth(c));
    }

    /* Invalid Methods for Class Character */

    @Override
    public void insert(Glyph glyph, int i) { throw new IllegalStateException(); }

    @Override
    public void remove(Glyph glyph) { throw new IllegalStateException(); }

    @Override
    public Glyph getChild(int i) { throw new IllegalStateException(); }

    @Override
    public int numChildren() { throw new IllegalStateException(); }

    @Override
    public Bounds composite(Bounds bound) { throw new IllegalStateException(); }

    @Override
    public void compose() { throw new IllegalStateException(); }

    @Override
    public Command click() { throw new IllegalStateException(); }

}
