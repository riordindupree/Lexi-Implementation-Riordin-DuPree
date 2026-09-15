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

public class Glyph {
    // Method to draw
    public void draw(Window window){ throw new IllegalStateException(); }
    // checks if click at "point" intersects the bounds of the glyph.
   public boolean intersects(Point point){ throw new IllegalStateException(); }
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

    // set position of Glyph
    public void setPosition(int x, int y){ throw new IllegalStateException(); }
    // set width and height of Glyph
    public void setSize(Window window){ throw new IllegalStateException(); }
    // get Bounds
    public Bounds getBounds(){ throw new IllegalStateException(); }

}
