/**
 * Function defines a Rectangle for the Lexi editor.
 * 
 * Rectangle is a type of Glyph, so it extends generic class 'Glyph.java'.
 * 
 * Class uses the Composite(163) design pattern. 
 *  - It represents a "Leaf" from the pattern.
 * 
 * @author Riordin Dupree
 */

package glyph;

import point.Bounds;
import window.*;

public class Rectangle extends Glyph {
    // variable declarations
    //int width;
    //int height;

    /* Constructor */
    public Rectangle(int w, int h){
        super( 0, 0, h, w);
        //width = w;
        //height = h;
    }

    /**
     * Draws Rectangle in window.
     * @param window : window to draw rectangle in. 
     */
    @Override
    public void draw(Window window){
        Bounds bounds = this.getBounds();
        window.drawRectangle(bounds.getX(), bounds.getY(), bounds.getWidth(), bounds.getHeight());
    }

    /** 
     * Set position of Glyph.
     * @param x : x coordinate for Glyph,
     * @param y : y coordinate for Glyph.
     */
    @Override
    public void setPosition(int x, int y){
        Bounds bounds = this.getBounds(); 
        bounds.setX(x); 
        bounds.setY(y);
    }

    /**
     * Since Rectangles size is set during construction, function just returns.
     * @param window : window Size is held within.
     */
    @Override
    public void setSize(Window window){ return; }

    /* Invalid Methods for Class Rectangle */

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
}
