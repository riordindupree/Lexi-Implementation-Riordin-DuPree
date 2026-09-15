/**
 * Function defines a Simple Compositor for the Lexi editor.
 * 
 * SimpleCompositor is a type of Compositor, so it extends generic class 'Compositor.java'.
 * 
 * Compositor is made to work with a composite.
 * 
 * Class uses the Strategy(315) design pattern. 
 *  - It represents a "ConcreteStrategy" from the pattern.
 * 
 * @author Riordin Dupree
 */
package compositor;

import glyph.*;
import point.*;
import window.*;

public class SimpleCompositor implements Compositor{
    // declare variables
    private Window window;
    private Glyph composite;
    private Bounds cursor;
    
    /* Constructor */
    public SimpleCompositor(Window w){ window = w; }

    /**
     * Sets composite variable for Compositor.
     * @param composition : starting composite for Compositor.
     */
    public void setComposite(Glyph composition){ composite = composition; }
    
    /**
     * Compose method based on algorithm in SimpleCompositor.
     * SetComposite must be called before compose is run.
     * 
     * @link https://github.com/BoiseState/CS472-resources/blob/29a797272569d8328b3b70c8060a790e67ec7d95/buff/classes/472/pub/ch2/SimpleCompositor#L1C1-L8C48 
     * @param window : window composite resides within
     */
    public void compose(){
        // create cursor based on parent
        cursor = new Bounds(composite.getBounds().getX(), composite.getBounds().getY(), 0, 0);
        
        for (int i = 0; i < composite.numChildren(); i++) {
            if (composite.getChild(i) != null){
                //SimpleCompositor simple = new SimpleCompositor();
                try{
                    // ask (leaf) child to set size, based on window
                    composite.getChild(i).setSize(window);
                    // ask child to set position, based on cursor
                    composite.getChild(i).setPosition(cursor.getX(), cursor.getY());    
                    // ask child to compose itself, recursively
                    composite.getChild(i).compose();
                } 
                catch (IllegalStateException e){}
                finally{
                    // ask parent to adjust itself and cursor, based on child
                    composite.setSize(window);
                    cursor = composite.composite(composite.getChild(i).getBounds());
                }
            }
        }
        // ask parent to adjust itself, based on cursor
        composite.composite(cursor);
    }
}
