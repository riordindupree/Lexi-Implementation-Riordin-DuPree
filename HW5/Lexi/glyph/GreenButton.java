/**
 * Class acts as an implementation for a Green Button for the Lexi program.
 * 
 * Class uses the AbstractFactory(87) design pattern. 
 *  - It represents an "ConcreteProduct" from the pattern.
 * 
 * Class uses the FactoryMethod(107) design pattern.
 *  - It represents a "ConcreteProduct" from the pattern.
 * 
 */

package glyph;

import command.Command;
import point.Bounds;
import window.Window;

public class GreenButton extends Button{

    String color;

    public GreenButton(Window window) {
        super(window);
        color = "green";
    }

    // overloaded constructor
    public GreenButton(Window window, Command command){
        super(window, command);
    }

    @Override
    public void drawEmbell(Window window) {
        Bounds child = this.getChild(0).getBounds();
        window.drawButton(child.getX(), child.getY(), child.getWidth(), child.getHeight(), color);
    }
}
