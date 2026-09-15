/**
 * Function defines a Row for the Lexi editor.
 * 
 * Row is a type of Glyph, so it extends generic class 'Glyph.java'.
 * 
 * Row holds an array of types Glyphs. Row cannot know or check what 
 * types of Glyphs for the sake of reusability.
 * 
 * Class uses the Composite(163) design pattern. 
 *  - It represents a "Composite" from the Composite(163).
 * 
 * @author Riordin Dupree
 */

package glyph;

import point.*;
import window.*;

public class Row extends CompositeGlyph{
    // variable delclaration
    private int width = 0;
    private int height = 0;

    /**
     * Function to be called by Row's Compositor. Updates the size of Row, and moves cursor for next input.
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
        width += w;
        if (height < h){
            height = h;
        }
        setSize(width, height);

        // get new cursor x position.
        int new_x = x + w;

        // return next cursor location.
        return new Bounds(new_x, y, w, h);
    }

    // Function sets the size of Row based on width and height.
    public void setSize(Window window){
        super.setSize(width, height);
    }
}
