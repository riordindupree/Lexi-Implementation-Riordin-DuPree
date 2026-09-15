package glyph;

import point.*;
import window.*;

/**
 * Class defines a Border Embelishment for the Lexi editor.
 * 
 * Class uses the Decorator(175) design pattern. 
 *  - It represents "ConcreteDecoratorA" from the pattern.
 * 
 * @author Riordin Dupree
 */

public class Border extends Embellishment {
    // instance variables
    int border_width = 5;

    // constructor
    public Border(Window window) {
        super(window);
    }
    // declare width constructor
    public Border(int i, Window window) {
        super(window);
        border_width = i;
    }
    
    @Override
    public void draw(Window window){
        // update child x and y position based on border width.
        //Bounds bounds = this.getChild(0).getBounds();
        //bounds.setX(bounds.getX() + border_width);
        //bounds.setY(bounds.getY() + border_width);
        // call super.draw(), then draw border.
        super.draw(window);
        drawBorder(window);
    }

    /**
     * Updated Set Position Method for border.
     * @param x : x coordinate for the Glyph inside border.
     * @param y : y coordinate for the Glyph inside border.
     */
    public void setPosition(int x, int y){
        // call super with values taking account of border width.
        super.setPosition(x - border_width, y - border_width);
    }

    /**
     * Updated Set Size Method for border.
     * @param window : window border is found inside of.
     */
    public void setSize(Window window){
        // call super: sets width and height to match elements inside of border. 
        super.setSize(window);
        // update width and height based on predefined border width.
        Bounds inborder = this.getBounds();
        int offset = border_width * 2; // offset = length added from border width.
        this.setBounds(inborder.getX(), inborder.getY(), inborder.getWidth() + offset, inborder.getHeight() + offset);
    }

    /**
     * Draws the boarder object based on the window.
     * @param window
     */
    public void drawBorder(Window window){
        Bounds b = this.getChild(0).getBounds();
        int x_1 = b.getX();
        int y_1 = b.getY();
        int x_2 = x_1 + b.getWidth();
        int y_2 = y_1 + b.getHeight();
        // adjust border height based on 
        window.addBorder(x_1, y_1, x_2, y_2, border_width);
    }

    /* Update composite to account for border */
    @Override
    public Bounds composite(Bounds bound) {
        return new Bounds(bound.getX(), bound.getY(), bound.getWidth(), bound.getHeight());
    }
    
    /**
     * Border Compose Method Updates childs position before calling super.          
     */
    @Override
    public void compose(){
        // update child position based on border
        Glyph child = this.getChild(0);
        Bounds childBound = child.getBounds();
        child.setPosition(childBound.getX() + border_width, childBound.getY() + border_width);
        // ask parent to call compose.
        super.compose();
    }

}
