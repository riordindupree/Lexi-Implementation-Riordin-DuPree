package glyph;

import point.*;
import window.*;

/**
 * Class defines a Scroller Embelishment for the Lexi editor.
 * 
 * Class uses the Decorator(175) design pattern. 
 *  - It represents "ConcreteDecoratorA" from the pattern.
 * 
 * Class should avoid calling super on Composite Methods
 * 
 * @author Riordin Dupree
 */


public class Scroller extends Embellishment {
    // declare variables
    int scroller_width = 10;

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
    
    /** Draw Scroller: called in parent draw methods */
    @Override
    public void drawEmbell(Window window){
        Bounds b = this.getChild(0).getBounds();
        int x = b.getX() + b.getWidth();
        int y = b.getY();
        int h = b.getHeight();
        window.addScrollBar(x+5, y, scroller_width, h);
    }

    @Override
    public void setEmbellSize(Window window){
        // get inner components border
        Bounds b = this.getChild(0).getBounds();
        // set size of element to Size of Embell + size of component
        this.setBounds(b.getX(), b.getY(), b.getWidth() + scroller_width + 5, b.getHeight());
    }

    @Override
    public Bounds embellComposite(Bounds bounds) {
        // account for increased width caused by border
        bounds.setX(bounds.getX()+scroller_width);
        // return bounds
        return bounds;
    }
    
    @Override
    public void offsetChild() {
        return; // Scroller does not effect child positioning.
    }
}
