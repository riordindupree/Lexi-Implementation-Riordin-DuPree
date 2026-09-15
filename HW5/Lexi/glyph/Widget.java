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

import command.Command;
import window.Window;

public abstract class Widget extends Embellishment {
    // declare variables
    Command comm = null;
    
    public Widget(Window window) {
        super(window);
    }

    // overloaded Constructor
    public Widget(Window window, Command command){
        super(window);
        comm = command;
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

    /**
     * returns the command of the Widget
     */
    @Override
    public Command click(){
        return comm;
    }

    /**
     * Function assigns a given command to a Widget
     * @param command : a given command
     */
    public void assignCommand(Command command){
        comm = command;
    }

}
