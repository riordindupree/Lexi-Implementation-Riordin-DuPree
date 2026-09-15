package window;

import glyph.*;
import point.*;
import command.*;
/**
 * ApplicationWindow implements the Window Abstract Class.
 * 
 * Class uses the Bridge(151) design pattern. 
 *  - It represents an "RefinedAbstraction" from Bridge(151).
 */

public class ApplicationWindow extends Window {
    // declare variables
    private KeyMap map;
    private GlyphFinder finder;
    private FontFunctionality font_func;

    
    // calls constructor
    public ApplicationWindow(String title) {
        // call super
        super(title);
        
        // get command related classes
        font_func = FontFunctionality.getFontFunction();

        // generate glyphfinder
        finder = new GlyphFinder();

        // generate keymap
        map = new KeyMap();
        // i: Increment the font size by one
        map.put('i', new IncrFontCommand());
        //d: Decrement the font size by one
        map.put('d', new DecrFontCommand());
        //u: Undo
        //map.put('u', new UndoCommand());
        //r: Redo
        //map.put('r', new RedoCommand());

    }
    
    // draw method
    public void draw(){ 
        // first, set font size
        this.setFontSize(font_func.getFontSize());
        // then, draw contents
        Glyph contents = this.getContents();
        if (contents != null){
            // passes a concrete class to WindowImp
            contents.draw(this); 
        } 
    }

    // preforms the command of a clicked glyph
    public void click(int x, int y){
        // get contents and create point
        Glyph contents = this.getContents();
        Point clicked = new Point(x, y);
        if (contents != null){
            // get command from glyph
            Command comm = finder.clickGlyph(contents, clicked);
            if (comm == null){ return; } // return no if there is no command
            // add command to CommandHistory
            // execute command
            comm.execute();
            // redraw window
            this.redraw();
        } 
    }

    // preforms command based on character of pressed key
    public void key(char c) {
        Glyph contents = this.getContents();
        if (contents != null){
            // get command from key
            Command comm = map.get(c);
            if (comm == null){ return; } // return no if there is no command
            // add command to CommandHistory
            // execute command
            comm.execute();
            // redraw window
            this.redraw();
        } 
    }
}
