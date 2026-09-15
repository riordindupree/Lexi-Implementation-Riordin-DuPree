package glyph;

import compositor.*;
import point.*;
import window.*;

/**
 * Defines a Basic Composition for the Lexi Program which is modifiable via a Compositor.
 * 
 * Composition is an abstract class, which extends the functionality of CompositeGlyph,
 * causing it to inherit many of its properties. 
 * 
 * Class uses the Strategy(315) design pattern. 
 *  - It represents a "Context" from Strategy(315).
 * 
 * @author Riordin Dupree
 */

/*
Composition() should set compositor.
Composition.insert() should compose(), not Lexi.main().
Composition.compose() should call compositor.compose().
*/

public abstract class Composition extends CompositeGlyph {
    // variable declarations
    Compositor c;

    // Consturctor
    public Composition(Window window){
        // run super constructor
        super();
        // set comp
        c = new SimpleCompositor(window);
        // set compositors composition to this.
        c.setComposite(this);
    }

    // Method to be used for Classes which wish to set their own compositor.
    public Composition(Compositor comp){
        // run super constructor
        super();
        // set comp
        c = comp;
        // set compositors composition to this.
        c.setComposite(this);
    }

    @Override
    public void insert(Glyph glyph, int i){
        super.insert(glyph, i);
        compose();
    }
    
    /**
     * 
     */
    @Override
    public abstract Bounds composite(Bounds bound);
    /*{
        // get variables from given bounds.
        Point pos = new Point(bounds.getX(), bounds.getY());

        // ask to format        

        // return next cursor location.
        return new Bounds(pos, 0, 0);
    }*/

    /**
     * 
     */
    @Override
    public void compose(){
        c.compose();
    }

}
