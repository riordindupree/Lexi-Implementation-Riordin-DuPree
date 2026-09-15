/**
 * Class acts as an implementation for a Red Label for the Lexi program.
 * 
 * Class uses the AbstractFactory(87) design pattern. 
 *  - It represents an "ConcreteProduct" from the pattern.
 * 
 * Class uses the FactoryMethod(107) design pattern.
 *  - It represents a "ConcreteProduct" from the pattern.
 * 
 */

package glyph;

import point.Bounds;
import window.Window;

public class RedLabel extends Label{

    String color;

    public RedLabel(Window window) {
        super(window);
        color = "red";
    }

    @Override
    public void drawEmbell(Window window) {
        Bounds child = this.getChild(0).getBounds();
        // extends label to slightly outside the bounds of the element inside of it.
        window.drawLabel(child.getX()-1, child.getY()-1, child.getWidth()+2, child.getHeight()+2, color);
    }
}
