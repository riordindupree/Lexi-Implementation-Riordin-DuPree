package glyph;

import command.Command;
import point.*;
import window.*;

/**
 * Class defines a Border Embelishment for the Lexi editor.
 * 
 * Class uses the Decorator(175) design pattern. 
 *  - It represents "ConcreteDecoratorA" from the pattern.
 * 
 * Class should avoid calling super on Composite Methods
 * 
 * @author Riordin Dupree
 */

public class Border extends Embellishment {
    // instance variables
    int border_width = 5;
    int border_spacing = 10; // defines spacing between border and element inside of border.

    // constructor
    public Border(Window window) {
        super(window);
    }
    // declare width constructor
    public Border(int i, Window window) {
        super(window);
        border_width = i;
        border_spacing = i + 5;
    }
    

    /**
     * Updated Set Position Method for border.
     * @param x : x coordinate for the Glyph inside border.
     * @param y : y coordinate for the Glyph inside border.
     */
    public void setPosition(int x, int y){
        // set childs to have poistion account for border_spacing
        this.getChild(0).setPosition(x + border_spacing, y + border_spacing);
        // call super with values taking account of border width.
        super.setPosition(x, y);
    }

    /**
     * Updated Set Size Method for border.
     * @param window : window border is found inside of.
     */
    public void setEmbellSize(Window window){
        // get child element of border.
        Glyph child = this.getChild(0);
        // update width and height based on predefined border width of child.
        Bounds inborder = child.getBounds();
        int offset = border_spacing * 2; // offset = length added from border width.
        this.setBounds(inborder.getX(), inborder.getY(), inborder.getWidth() + offset, inborder.getHeight() + offset);
    }

    /**
     * Draws the boarder object based on the window.
     * @param window
     */
    public void drawEmbell(Window window){
        Bounds b = this.getChild(0).getBounds();
        // get x1 and y1
        int x_1 = this.getBounds().getX();
        int y_1 = this.getBounds().getY();
        // get x2 and y2
        int offset = border_spacing * 2; // offset = length added from border width.
        int x_2 = x_1 + b.getWidth() + offset;
        int y_2 = y_1 + b.getHeight() + offset;
        // adjust border height based on 
        window.addBorder(x_1, y_1, x_2, y_2, border_width);
    }

    /* Update composite to account for border */
    @Override
    public Bounds embellComposite(Bounds bounds) {
        // update childs composite to account for border
        bounds.setX(bounds.getX()+border_spacing); // account for increased width caused by border. also create some spacing after the element.
        bounds.setY(bounds.getY()-border_spacing); // account for lowered y value caused by border
        // return updated bounds
        return bounds;
    }
    
    /**
     * offsets position of child before compose gets called on it in parents compose() method.          
     */
    @Override
    public void offsetChild(){
        // update child position based on border
        Glyph child = this.getChild(0);
        Bounds childBound = child.getBounds();
        child.setPosition(childBound.getX() + border_spacing, childBound.getY() + border_spacing);
    }

    @Override
    public Command click() { throw new IllegalStateException(); }

}
