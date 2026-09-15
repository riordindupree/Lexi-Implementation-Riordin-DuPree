package glyph;

import point.Bounds;
import window.Window;

/**
 * Function defines a generic class for an Embelishment for the Lexi editor.
 * 
 * An Embelishment holds a Composition, which is a type of Glyph.
 * This makes it also a Composition.
 * 
 * Class uses the Decorator(175) design pattern. 
 *  - It represents a "Decorator" from the pattern.
 * 
 * @author Riordin Dupree
 */

public class Embellishment extends Composition {
    
    // embellish will need a modified method for insert that ensures that it can only have 1 child.
    public Embellishment(Window window) {
        super(window);
    }

    // draw method:
    // draws component inside it before drawing self, then draws self around component.
    @Override
    public void draw(Window window){
        this.getChild(0).draw(window);
    }


    /**
     * Updated insert function to account for Embellishments single element functionality.
     * 
     * @param glyph : glyph to be inserted into border
     * @param i : location where border is meant to be placed (if > 0 program will fail)
     */
    @Override
    public void insert(Glyph glyph, int i){
        // since 
        if (i > 0){ throw new IllegalStateException(); }
        else{ super.insert(glyph, 0); }
    }

    /**
     * Alternative insert method (which does not need to specify location).
     * @param glyph : glyph to be inserted into border.
     */
    public void insert(Glyph glyph){
        this.insert(glyph, 0);
    }

    /**
     * Returns inserted bounds since function should not need to update it.
     * @param bound : bound to be edited by composite
     */
    @Override
    public Bounds composite(Bounds bound) {
        // function does not need to edit bound 
        return bound;   
    }

}
