/**
 * Creates an Abstract class for a Label for the Lexi program.
 * 
 * A Label is a type of Glyph.
 * 
 * Class uses the AbstractFactory(87) design pattern. 
 *  - It represents an "AbstractProduct" from the pattern.
 * 
 * Class uses the FactoryMethod(107) design pattern.
 *  - It represents a "Product" from the pattern.
 * 
 * It also partially fills the role of a "ConcreteDecorator" for
 * Widget's Decorator(175), with Label's children filling the rest
 * of that role.
 * 
 * @author Riordin Dupree
 */

package glyph;

import point.Bounds;
import window.Window;

public abstract class Label extends Widget {

    public Label(Window window) {
        super(window);
    }

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
