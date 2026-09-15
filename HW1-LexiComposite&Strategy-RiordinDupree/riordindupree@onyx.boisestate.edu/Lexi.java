
/** 
 * Function acts as the builder for the Lexi Program.
 * It contains test input for Lexi, and the functions for Composite
 * 
 * To run the program, use javac in the Lexi Folder through the terminal.
 *  $ javac Lexi.java
 * 
 * Then run the program using java. In 'window_name,' either type in a
 * name for the window, or leave it blank.
 *  $ java Lexi 'window_name'
 * 
 * @author Riordin Dupree
 */ 
import compositor.*;
import glyph.*;
import glyph.Character;
import window.*;

public class Lexi {
    public static void main(String[] args){
        // set default project name
        String project_title = "Unnamed Project";
        // get Window name from args
        if (args.length > 0){
            project_title = args[0];
        }

        // Create SwingWindow
        SwingWindow window = new SwingWindow(project_title);

        // Add input into SwingWindow (based on example on assignment sheet).
        try{
            // Load Content
            Example1(window);
            // set contents to window
            //window.setContents(content);
            // load compositor
            //loadCompositor(content, window);
        } finally {

        }
    }

    /**
     * Function creates an example input for Lexi.
     * @return : example input.
     */
    public static void Example1(Window window){
        // set up compostion
        Compositor comp = new SimpleCompositor();
        Composition root = new Composition(comp, window);
        
        // create initial Glyphs
        Row row_1 = new Row();
        Row row_2 = new Row();
        Character a = new Character('a');
        Rectangle rect_1 = new Rectangle(15, 30);
        Column col = new Column();
        Character x_1 = new Character('X');
        Character y_1 = new Character('Y');
        Character z = new Character('Z');
        Character b = new Character('b');
        Character x_2 = new Character('x');
        Rectangle rect_2 = new Rectangle(30, 15);
        Character y_2 = new Character('y');

        // populate Glyphs into their respective arrays
        col.insert(x_1, 0);
        col.insert(y_1, 0);
        col.insert(z, 0);

        row_1.insert(a, 0);
        row_1.insert(rect_1, 1);
        row_1.insert(col, 2);
        row_1.insert(b, 3);

        row_2.insert(y_2, 2);
        row_2.insert(rect_2, 1);
        row_2.insert(x_2, 0);

        root.insert(row_2, 1); // these should populate window
        root.insert(row_1, 0); 
        // return inital column

    }

    /**
     * Function loads an input into the Lexi Compositor, then runs the Compositor
     * @param content : a single Glyph which holds all the input for the compositor.
     * @param window : window that the Glyphs are displayed within.
     */
    public static void loadCompositor(Glyph content, Window window){
        // create compositor
        Compositor compositor = new SimpleCompositor();
        // load content into compositor
        compositor.setComposite(content);
        // run composite
        compositor.compose(window);
    }
}
