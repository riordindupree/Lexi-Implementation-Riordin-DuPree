/**
 * Function defines a genric composite glyph for the Lexi editor.
 * 
 * CompositeGlyph is a type of Glyph, so it extends generic class 'Glyph.java'.
 * 
 * CompositeGlyph holds an array of types Glyphs. CompositeGlyph cannot know or check what 
 * types of Glyphs for the sake of reusability.
 * 
 * Class uses the Composite(163) design pattern. 
 *  - It represents a "Composite" from Composite(163).
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
    
    
    /* Constructors */
    public CompositeGlyph() {
        super(0, 0, 0, 0);
        contents = new ArrayList<Glyph>();
    }

    // formats the Composite and its Children (ran after insert/remove)
    //public abstract void format();

    /**
     * Draw method for Composite Glyph.
     * @param window : where character will be drawn.
     */
    public void draw(Window window){
        for(Glyph child : contents){ child.draw(window); }
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
            // set glyph parents
            glyph.setParent(this);
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
    public Glyph getChild(int i){ 
        // first, check if index can be reached
        if (contents.size() > i){
            // if it can, return element at i
            return contents.get(i); 
        }
        // otherwise, return null
        return null;
    }

    /**  
     * Get size of content list.
     * @return number of children.
     */
    public int numChildren(){ return contents.size(); }
 
    /**
     * Sets size of compositor based on elements inside the compositor.
     * @param h : window compositor is found within
     */ 
    public void setSize(Window window){
        Bounds bounds = this.getBounds();
        int w = 0;
        int h = 0;
        Bounds c_b; // child bounds
        int c_width; // width from composites start to bounds end  
        int c_height; // height from composites start to bounds end
        for (Glyph child : contents){
            if(child != null){
                // find width and height from composite start to bounds end
                c_b = child.getBounds();
                c_width = c_b.getWidth() + (c_b.getX() - bounds.getX());
                c_height = c_b.getHeight() + (c_b.getY() - bounds.getY());
                // make width bigger to fit these values if needed.
                if (c_width > w){ w = c_width; }
                if (c_height > h){ h = c_height; }
            }
        }
        // set width
        bounds.setWidth(w);
        bounds.setHeight(h);
    }
}
