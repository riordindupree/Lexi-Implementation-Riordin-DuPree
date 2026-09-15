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

import point.*;
import window.*;

public class Rectangle extends Glyph {
    // variable declarations
    private Bounds bounds;
    int width;
    int height;

    /* Constructor */
    public Rectangle(int w, int h){
        width = w;
        height = h;
        // Point is temporary
        Point p = new Point(0, 0);
        bounds = new Bounds(p, width, height);
    }

    /**
     * Draws Rectangle in window.
     * @param window : window to draw rectangle in. 
     */
    public void draw(Window window){
        window.drawRectangle(bounds.getX(), bounds.getY(), bounds.getWidth(), bounds.getHeight());
    }

    /**
     * Checks if a given point intersects the Rectangle.
     *  - currently unimplemented
     */
   public boolean intersects(Point point){ return false; }

    /** 
     * Set position of Glyph.
     * @param x : x coordinate for Glyph,
     * @param y : y coordinate for Glyph.
     */
    public void setPosition(int x, int y){ 
        bounds.setX(x); 
        bounds.setY(y);
    }

    /**
     * Sets the size of the rectangle (called in Compositor).
     * @param window : window containing rectangle.
     */
    public void setSize(Window window){
        bounds.setHeight(height);
        bounds.setWidth(width);
    }

    /**
     * Returns the Bounds of the Rectangle.
     * @return bounds of the rectangle.
     */
    public Bounds getBounds(){ return bounds; }   
}
