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
 * For the sake of following the design pattern, super should avoid calling super as much as possible.
 * 
 * @author Riordin Dupree
 */

public abstract class Embellishment extends Composition {
    
    // embellish will need a modified method for insert that ensures that it can only have 1 child.
    public Embellishment(Window window) {
        super(window);
    }

    // draw method:
    // draws component inside it before drawing self, then draws self around component.
    @Override
    public void draw(Window window){
        this.getChild(0).draw(window);
        this.drawEmbell(window);
    }

    // setSize method:
    // sets size of component inside it before setting its own size.
    @Override
    public void setSize(Window window){
        this.getChild(0).setSize(window);
        this.setEmbellSize(window);
    }

    // Composite method:
    // composites child then updates composites result to account for Embellishment
    @Override
    public Bounds composite(Bounds bounds){
        return this.embellComposite(this.getChild(0).composite(bounds));
    }

    /**
     * method offsets child, then calls compose on child
     */
    @Override
    public void compose() {
        this.offsetChild();
        // function does not need to edit bound 
        this.getChild(0).compose();
    }

    /* Abstract Methods : Need to be implemented by child classes */
    public abstract void drawEmbell(Window window); // draws embellishment.
    public abstract void setEmbellSize(Window window); // sets size of embellishment.
    public abstract Bounds embellComposite(Bounds bounds); // offsets composite to account for embellishment.
    public abstract void offsetChild(); // offsets child before composing it.


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

    /* Glyph Methods */
    @Override
    public void setPosition(int x, int y){
        // call set position on child
        //   - NOTE: childs position will be fixed during offsetChild() method
        this.getChild(0).setPosition(x, y);
        // call set position on self
        super.setPosition(x, y);
    }

}
