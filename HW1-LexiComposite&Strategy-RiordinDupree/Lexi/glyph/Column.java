/**
 * Function defines a Column for the Lexi editor.
 * 
 * Column is a type of Glyph, so it extends generic class 'Glyph.java'.
 * 
 * Column holds an array of types Glyphs. Column cannot know or check what 
 * types of Glyphs for the sake of reusability.
 * 
 * Class uses the Composite(163) design pattern. 
 *  - It represents a "Composite" from the pattern.
 * 
 * @author Riordin Dupree
 */

package glyph;

import point.*;
import window.*;

public class Column extends CompositeGlyph {
    // variable declaration
    private int width = 0;
    private int height = 0;

    /**
     * Function to be called by Column's Compositor. Updates the size of Column, and moves cursor for next input.
     * @param bound : bounds for last composited data.
     * @return : cursor position for next composite data.
     */
    public Bounds composite(Bounds bound){
        // get variables from given bounds.
        int x = bound.getX();
        int y = bound.getY();
        int w = bound.getWidth();
        int h = bound.getHeight();
        
        // update size of row.
        height += h;
        if (width < w){
            width = w;
        }
        setSize(width, height);

        // get new cursor y position.
        int new_y = y + h;

        // return next cursor location.
        return new Bounds(x, new_y, w, h);
    }

    // Function sets the size of Column based on width and height.
    public void setSize(Window window){
        super.setSize(width, height);
    }
}
