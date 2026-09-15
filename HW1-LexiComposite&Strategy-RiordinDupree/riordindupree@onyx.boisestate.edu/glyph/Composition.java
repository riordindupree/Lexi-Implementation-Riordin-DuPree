package glyph;

import compositor.*;
import point.*;
import window.*;


/*
Composition() should set compositor.
Composition.insert() should compose(), not Lexi.main().
Composition.compose() should call compositor.compose().
*/

public class Composition extends CompositeGlyph {
    // variable declarations
    Compositor c;
    Window w;

    public Composition(Compositor comp, Window window){
        // run super constructor
        super();
        // set comp
        c = comp;
        w = window;
        // set window and comp constructors to this.
        window.setContents(this);
        c.setComposite(this);
    }

    public void insert(Glyph glyph, int i){
        super.insert(glyph, i);
        compose(w);
    }
    
    public Bounds composite(Bounds bound){
        // get variables from given bounds.
        int x = bound.getX();
        int y = bound.getY();
        int w = bound.getWidth();
        int h = bound.getHeight();
    
        // get new cursor y position.
        int new_y = y + h;

        // return next cursor location.
        return new Bounds(x, new_y, w, h);
    }

    public void compose(Window window){
        c.compose(window);
    }

    //public void format() {
        // call compose
        //compose();
    //}

}
