package window;

import glyph.*;
/**
 * ApplicationWindow implements the Window Abstract Class.
 * 
 * Class uses the Bridge(151) design pattern. 
 *  - It represents an "RefinedAbstraction" from Bridge(151).
 */

public class ApplicationWindow extends Window {
    // calls constructor
    public ApplicationWindow(String title) {
        super(title);
    }
    
    // draw method
    public void draw(){ 
        Glyph contents = this.getContents();
        if (contents != null){
            // passes a concrete class to WindowImp
            contents.draw(this); 
        } 
    }
}
