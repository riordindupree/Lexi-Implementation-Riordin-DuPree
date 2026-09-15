/**
 * The Widget Class Represents an abstract class for Glyph types
 * which are given a Look-And-Feel from a Lexi Factory.
 * 
 * Class inherits the functionality from Embellishment class,
 * making it also share the Decorator(175) design pattern.
 *  - It represents a decorator from the design pattern, like Embellishment.
 * 
 * Unlike Embelish, Widget must be drawn before its Glyph to prevent it from covering said Glyph.
 * 
 * @author Riordin Dupree
 */

package glyph;

import window.Window;

public abstract class Widget extends Embellishment {

    public Widget(Window window) {
        super(window);
    }

    /** 
     * Updated draw method for Widget:
     *  - Unlike Embellishment, Widget needs to draw itself before drawing component inside it
     *    to prevent the widget from covering up the component.
     */
     @Override
    public void draw(Window window){
        // draw widget below child
        this.drawEmbell(window);
        // draw child
        this.getChild(0).draw(window);
    }

}
