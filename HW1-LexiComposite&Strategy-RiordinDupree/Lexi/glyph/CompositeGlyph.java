/**
 * Function defines a genric composite glyph for the Lexi editor.
 * 
 * CompositeGlyph is a type of Glyph, so it extends generic class 'Glyph.java'.
 * 
 * CompositeGlyph holds an array of types Glyphs. CompositeGlyph cannot know or check what 
 * types of Glyphs for the sake of reusability.
 * 
 * Class uses the Composite(163) & Strategy(315) design pattern. 
 *  - It represents a "Composite" from Composite(163).
 *  - It represents a "Context" from Strategy(315).
 * 
 * @author Riordin Dupree
 */

package glyph;

import java.util.ArrayList;

import point.*;
import window.*;

public abstract class CompositeGlyph extends Glyph {
    // variable declarations
    private ArrayList<Glyph> contents;
    private Bounds bounds;
    
    /* Constructor */
    public CompositeGlyph() {
        contents = new ArrayList<Glyph>();
        Point point = new Point(0, 0);
        bounds = new Bounds(point, 0, 0);
    }

    /**
     * Draw method for Composite Glyph.
     * @param window : where character will be drawn.
     */
    public void draw(Window window){
        for(Glyph child : contents){ child.draw(window); }
    }

    // checks if click at "point" intersects the bounds of the glyph.
   public boolean intersects(Point point){
        // do not need to worry about implementing at the moment
        return false;
    }

    /**  
     * Insert a child node into Composite.
     * @param glyph : glyph to be inserted.
     * @param i : position to insert glyph.
     */
    public void insert(Glyph glyph, int i){
        // check if value at 'i' can have set called on it.
        if (i >= contents.size()){
            // if set cannot be called, fill with null elements before index.
            for(int j = contents.size(); j < i; j++){ contents.add(null); }
            // then add glyph at index
            contents.add(glyph);
        } else { contents.set(i, glyph); } // call set
    }

    /**  
     * Remove child node "glyph" from Composite.
     * @param glyph : glyph to be removed.
     */
    public void remove(Glyph glyph){ contents.remove(glyph); }
    
    /** 
     * Get ith child of Composite.
     * @param i : child to get from Composite.
     */
    public Glyph getChild(int i){ return contents.get(i); }
    /**  
     * Get size of content list.
     * @return number of children.
     */
    public int numChildren(){ return contents.size(); }

    /** 
     * Set position of Composite.
     * @param x : x coordinate of glyph.
     * @param y : y coordinate of glyph.
     */
    public void setPosition(int x, int y){ 
        bounds.setX(x); 
        bounds.setY(y);
    }
 
    /**
     * Set size function to get called in compositor.
     * @param h : new height of Glyph.
     * @param w : new width of Glyph.
     */ 
    public void setSize(int h, int w){
        bounds.setHeight(h);
        bounds.setWidth(h);
    }

    /**
     * Get Bounds of Composite.
     * @return bounds of composite glyph.
     */
    public Bounds getBounds(){ return bounds; }
}
