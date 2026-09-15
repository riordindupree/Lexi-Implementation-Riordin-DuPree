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

import window.*;

public class Rectangle extends Glyph {
    // variable declarations
    int width;
    int height;

    /* Constructor */
    public Rectangle(int w, int h){
        super( 0, 0, h, w);
        width = w;
        height = h;
    }

    /**
     * Draws Rectangle in window.
     * @param window : window to draw rectangle in. 
     */
    public void draw(Window window){
        window.drawRectangle(bounds.getX(), bounds.getY(), bounds.getWidth(), bounds.getHeight());
    }

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
}
