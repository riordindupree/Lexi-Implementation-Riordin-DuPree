package glyph;

import point.*;
import window.*;

/**
 * Class defines a Scroller Embelishment for the Lexi editor.
 * 
 * Class uses the Decorator(175) design pattern. 
 *  - It represents "ConcreteDecoratorA" from the pattern.
 * 
 * @author Riordin Dupree
 */


public class Scroller extends Embellishment {
    // declare variables
    int scroller_width = 20;

    // constructor
    public Scroller(Window window) {
        super(window);
    }
    // declare width constructor.
    public Scroller(int i, Window window) {
        super(window);
        scroller_width = i;
    }

    // Scoller constructor method: window.addScrollBar(x, y, width, height);

    // scroller height = height of child
    // scroller width can be a constant, or determine upon upon being called
    // scroller_x = child_x + child_width
    // scroller_y = child_y
    
    /* Set Size Method needs to update child height only, and ignore width. */
    @Override
    public void draw(Window window){
        super.draw(window);
        drawScroll(window);
    }
    
    public void drawScroll(Window window){
        Bounds b = this.getChild(0).getBounds();
        int x = b.getX() + b.getWidth();
        int y = b.getY();
        int h = b.getHeight();
        window.addScrollBar(x, y, scroller_width, h);
    }

    @Override
    public Bounds composite(Bounds bound) {
        return new Bounds(bound.getX() + scroller_width, bound.getY(), bound.getWidth(), bound.getHeight());
    }
}
