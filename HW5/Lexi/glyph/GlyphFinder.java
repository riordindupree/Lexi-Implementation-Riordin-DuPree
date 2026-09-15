package glyph;

import command.Command;
import point.*;

public class GlyphFinder{

    // Constructor
    public GlyphFinder(){}

    /**
     * Function recursively searches through the elements of a glyph tree
     * @param root - root node of a Glyph tree
     * @param click - x, y coordinate of click
     */
    public Command clickGlyph(Glyph root, Point click){
        // create return value;
        Command retval = null;
        // check if current glyph intersects point. If not, return
        if (root.intersects(click)){
            try{
                // first, call click on all children of glyph
                for(int i = 0; i <= root.numChildren() - 1; i++){
                    // call clickGlyph on all children
                    retval = clickGlyph(root.getChild(i), click);
                    // if a child returns a command, return the command
                    if (retval != null){ return retval; }
                }
                // call click on root
                return root.click();
            } 
            catch (IllegalStateException e){}
            return retval;
        } else{
            return retval;
        }
    }
}
