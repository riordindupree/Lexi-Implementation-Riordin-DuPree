/** 
 * Function acts as a genric class for a Glyph in the Lexi Editor.
 * 
 * Class uses the Composite(163) design pattern. 
 *  - It represents a "Component" in the pattern.
 * 
 * @author Riordin Dupree
 */

package glyph;

import window.*;
import point.*;

public abstract class Glyph {
    // Variable Declarations
    private Glyph parent;
    Bounds bounds;

    /* Constructor */
    public Glyph( int x, int y, int h, int w ) {
        bounds = new Bounds(x, y, w, h);
        parent = null;
    }

    /* Parent Methods */

    /** 
     * returns parent of Glyph
     * @return parent.
     */
    public Glyph getParent(){ return parent; }
    /** 
     * sets Parent of Glyph (called during insert).
     * @param parent - the new parent of a glyph node.
     */
    public void setParent(Glyph p){ parent = p; }
    /** 
     * returns first glyph in sequence which has no parent.
     * @return root of the Glyph Tree.
     */
    public Glyph getRoot(){
        if (parent.getRoot() == null){ return parent; }
        return parent.getRoot();
    }

    /* Bounds Functions */   
    
    /** 
     * returns the bounds of the Glyph.
     * @return the bounds of the Glyph.
     */
    public Bounds getBounds(){ return bounds; }
    
    /** 
     * sets the bounds 
     * @return the Bounds of a Character
     */
    public void setBounds(int x, int y, int w, int h){
        bounds = new Bounds(x, y, w, h);
    }
    /**
     * Function sets position of the Glyph
     * @param x : x coordinate for the Glyph
     * @param y : y coordinate for the Glyph
     */
    public void setPosition(int x, int y){
        bounds.setX(x);
        bounds.setY(y);
    }
    // set width and height of Glyph
    public abstract void setSize( Window window );
    
    /* Required Functions */

    /** 
     * returns true if a given point is within the characters bounds. 
     * @return true if the point is within bounds, false otherwise.
     */
    public boolean intersects(Point point){
        return bounds.touched(point.getX(), point.getY());
    }
    // Method to draw
    public abstract void draw(Window window);

    /* Abstract Methods */

    // insert a child node into Glyph
    public void insert(Glyph glyph, int i){ throw new IllegalStateException(); }
    // remove child node "glyph" from this Glyph
    public void remove(Glyph glyph){ throw new IllegalStateException(); }
    // get ith child of this Glyph
    public Glyph getChild(int i){ throw new IllegalStateException(); }
    // get  Glyph
    public int numChildren(){ throw new IllegalStateException(); }
    // get composite from Glyph
    public Bounds composite(Bounds bound){ throw new IllegalStateException(); }
    //
    public void compose(Window window){ throw new IllegalStateException(); }

}
