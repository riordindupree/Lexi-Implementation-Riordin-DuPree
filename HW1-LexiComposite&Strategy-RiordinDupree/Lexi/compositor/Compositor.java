/** 
 * Function acts as a genric class for a Compositor in the Lexi Editor.
 * 
 * Class uses the Strategy(315) design pattern. 
 *  - It represents a "Strategy" from the pattern.
 * 
 * @author Riordin Dupree
 */
package compositor;

import glyph.*;
import window.*;

public class Compositor {
    public void setComposite(CompositeGlyph composition){}
    public void compose(Window window){}
}
