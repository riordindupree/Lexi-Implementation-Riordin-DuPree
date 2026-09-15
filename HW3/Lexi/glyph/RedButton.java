/**
 * Class acts as an implementation for a Red Button for the Lexi program.
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

public class RedButton extends Button{

    String color;

    public RedButton(Window window) {
        super(window);
        color = "red";
    }

    @Override
    public void drawEmbell(Window window) {
        Bounds child = this.getChild(0).getBounds();
        window.drawButton(child.getX(), child.getY(), child.getWidth(), child.getHeight(), color);
    }
}
