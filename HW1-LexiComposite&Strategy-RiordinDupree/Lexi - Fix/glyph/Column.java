/**
 * Function defines a Column for the Lexi editor.
 * 
 * Column is an extension of the abstract Composition, so it shares many of its properties.
 * 
 * Class uses the Decorator(175) design pattern. 
 *  - It represents a "ConcreteComponent" from Decorator(175).
 * 
 * @author Riordin Dupree
 */

package glyph;

import point.*;
import window.*;

public class Column extends Composition {
    int spacer = 5;

    // Constructors
    public Column(Window window){
        super(window);
    }
    // Fancy Constructor
    public Column(String[] strings, Window window) {
        super(window);
        try {
            for (int i=0; i<strings.length; i++)
            this.insert(new Row(strings[i],window), i);
        } catch (Exception e) {
        System.out.println(e);
        }
    }


    /**
     * Function to be called by Column's Compositor. Updates the size of Column, and moves cursor for next input.
     * @param bound : bounds for last composited data.
     * @return : cursor position for next composite data.
     */
    @Override
    public Bounds composite(Bounds bound){
        // get variables from given bounds.
        int x = bound.getX();
        int y = bound.getY();
        int w = bound.getWidth();
        int h = bound.getHeight();
        
        // update size of row.
        //height += h;
        //if (width < w){
        //    width = w;
        //}
        //setSize(width, height);

        // get new cursor y position.
        int new_y = y + h + spacer; // spacer puts a small buffer between characters so they are not touching.

        // return next cursor location.
        return new Bounds(x, new_y, w, h);
    }

    // Function sets the size of Column based on width and height.
    /*public void setSize(Window window){
        int x = 0;
        int y = 0;
        int w = 0;
        int h = 0;
        int l = super.numChildren();
        for(int i = 0; i < l; i++){

        }
    }*/
}
