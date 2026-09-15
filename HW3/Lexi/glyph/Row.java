/**
 * Function defines a Row for the Lexi editor.
 * 
 * Row is a type of Glyph, so it extends generic class 'Glyph.java'.
 * 
 * Row holds an array of types Glyphs. Row cannot know or check what 
 * types of Glyphs for the sake of reusability.
 * 
 * Class uses the Decorator(175) design pattern. 
 *  - It represents a "ConcreteComponent" from Decorator(175).
 * 
 * @author Riordin Dupree
 */

package glyph;

import point.*;
import window.*;

public class Row extends Composition{
    // variable declaration
    int spacer = 1;

    // Constructors
    public Row(Window window){
        super(window);
    }
    // Fancy Constructor
    public Row(String string, Window window) {
        super(window);
        try {
            for (int i=0; i<string.length(); i++)
            this.insert(new Character(string.charAt(i)), i);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Function to be called by Row's Compositor. Updates the size of Row, and moves cursor for next input.
     * @param bound : bounds for last composited data.
     * @return : cursor position for next composite data.
     */
    @Override
    public Bounds composite(Bounds bound){
        // get variables from given bounds.
        int x = bound.getX();
        int y = bound.getY();
        int w = bound.getWidth();
        int h = bound.getHeight();
        
        // update size of row.
        /*width += w;
        if (height < h){
            height = h;
        }
        setSize(width, height);*/

        // get new cursor x position.
        int new_x = x + w + spacer; // spacer puts a small buffer between characters so they are not touching.

        // return next cursor location.
        return new Bounds(new_x, y, w, h);
    }

    // Function sets the size of Row based on width and height.
    /*public void setSize(Window window){
        
    }*/
}
