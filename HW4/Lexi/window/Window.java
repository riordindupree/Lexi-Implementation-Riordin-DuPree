package window;

import glyph.*;

/**
 * Window interface represents single codified caller for Window functions.
 * 
 * Instead of making Glyph programs have to worry about calling the correct
 * functions for Window, they can be called through Window.
 * 
 * Class uses the Bridge(151) design pattern. 
 *  - It represents an "Abstraction" from Bridge(151). 
 */

public abstract class Window {
    // declare variables
    private String name;
    private WindowImp imp;
    private Glyph contents;

    /* Window Methods */

    // Constructor uses Window Factory to create singleton instance of window
    public Window(String title){
        // set title
        name = title;
        // create factory
        WindowFactory fact = WindowFactory.window_instance();
        // get implementation from factory
        imp = fact.createWindow(title, this);
    }

    // draw contents of window
    public abstract void draw();
    
    // functions for managing the root Glyph.
    public Glyph getContents(){ return contents; }
    public void setContents(Glyph glyph){
        // set contents of window
        contents = glyph;
        // call set contents for imp
        imp.setContents();
    }

    /* Operation() methods for Window */
    //   - Based on Bridge(151) Pattern: Operation(){ imp.OperationImp() }

    public void drawCharacter(char c, int x, int y){ imp.drawCharacter(c, x, y); }
    public void drawRectangle(int x, int y, int w, int h){ imp.drawRectangle(x, y, w, h); }

    public int charWidth(char c){ return imp.charWidth(c); }
    public int charHeight(char c){ return imp.charHeight(c); }

    public void addBorder(int x1, int y1, int x2, int y2, int w){ imp.addBorder(x1, y1, x2, y2, w); }
    public void addScrollBar(int x, int y, int w, int h){ imp.addScrollBar(x, y, w, h); }

    public void drawButton(int x, int y, int w, int h, String c){ imp.drawButton(x, y, w, h, c); }
    public void drawLabel(int x, int y, int w, int h, String c){ imp.drawLabel(x, y, w, h, c); }

}
