/**
 * Creates an Abstract class for a Button for the Lexi program.
 * 
 * A Button is a type of Glyph.
 * 
 * Class uses the AbstractFactory(87) design pattern. 
 *  - It represents an "AbstractProduct" from the pattern.
 * 
 * Class uses the FactoryMethod(107) design pattern.
 *  - It represents a "Product" from the pattern.
 * 
 * It also partially fills the role of a "ConcreteDecorator" for
 * Widget's Decorator(175), with Button's children filling the rest
 * of that role.
 * 
 * @author Riordin Dupree
 */

package glyph;

import point.Bounds;
import window.Window;
import command.*;

public abstract class Button extends Widget {
    
    // constructor
    public Button(Window window) {
        super(window);
    }

    // overloaded constructor
    public Button(Window window, Command command){
        super(window, command);
    }

    /*@Override
    public void drawEmbell(Window window) {
        Bounds child = this.getChild(0).getBounds();
        window.drawButton(child.getX(), child.getY(), child.getWidth(), child.getHeight(), color);
    }*/

    // Button must implement borrowed methods from Embellishment (Widgets parent class)

    @Override
    public void setEmbellSize(Window window) {
        Bounds child = this.getChild(0).getBounds();
        this.setBounds(child.getX(), child.getY(), child.getWidth(), child.getHeight());
    }

    @Override
    public Bounds embellComposite(Bounds bounds) {
        return bounds;
    }

    @Override
    public void offsetChild() {
        return;
    }
}
