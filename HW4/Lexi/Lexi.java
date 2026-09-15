
/** 
 * Function acts as the builder for the Lexi Program.
 * It contains test input for Lexi, and the functions for Composite
 * 
 * To run the program, use javac in the Lexi Folder through the terminal.
 *  $ javac Lexi.java
 * 
 * Then run the program using the java keyword in the terminal in the following format.
 *  $ java Lexi '#' 'window_name'
 * 
 * Where
 *  - In 'window_name,' type in a name for the window, or leave it blank.
 *  - In '#', type in an integer value '4' to run example 4, '3' to run example 3, '2' to run example 2.
 *    Leaving the space blank, or typing in any other integer value will run example 1. 
 * 
 * Note: Any integer value placed before the 'name' is assumed to be the 'mode'. 
 *       To input an integer as the windows name, a mode must be given.
 * 
 * If option 4 is selected, System will look for a runtime variable which must be set in the terminal.
 * To set up this run time variable, simple type either of the following in the terminal:
 *      1)   $ export LexiWidget="Red"
 *      2)   $ export LexiWidget="Green"
 * 
 * If "Green" is typed, Lexi will use the Green Widget Factory.
 * If "Red" is typed, Lexi will use the Red Widget Factory.
 * 
 * If no value is given, the default value of "Red" is choosen.
 * 
 * @author Riordin Dupree
 */ 

//import compositor.*;
import factory.WidgetFactory;
import glyph.*;
import glyph.Character;
import window.*;

public class Lexi {
    // declare variables
    private static Window window;
    private static WidgetFactory widgetFactory;

    // define strings/string arrays for window
    private static String[] tusk = {
            "Why don't you ask him if he's going to stay?",
            "Why don't you ask him if he's going away?",
            " ",
            "Why don't you tell me what's going on?", 
            "Why don't you tell me who's on the phone?",
            " ",
            "Why don't you ask him what's going wrong?",
            "Why don't you ask him the latest on his throne?",
            " ",
            "Don't say that you love me!",
            " ",
            "Just tell me that you want me",
            " ",
            "Tusk!"
        };
    private static String buttonText = "I am a button";
    private static String labelText = "I am a label";

    // main program
    public static void main(String[] args){
        // set default project name and mode
        String project_title = "Unnamed Project";
        int mode = 1;

        // get Window name and mode from args
        if (args.length > 0){ // if false, no mode or title given.
            try{
                // get mode for window.
                mode = Integer.parseInt(args[0]);
                
                // check if name was given after mode.
                if (args.length > 1){
                    project_title = args[1];
                }
            }
            catch(NumberFormatException e){ // exception thrown if no mode given
                // if no mode given, what's left must be title.
                project_title = args[0];
            }

        }

        // Create SwingWindow
        window = new ApplicationWindow(project_title);

        // get instance for creation of button and label.
        widgetFactory = WidgetFactory.instance();

        // Add input into SwingWindow (based on example on assignment sheet).
        try{
            // Load Content
            if (mode == 4){
                Example4(window);
            } else if(mode == 3){ // if mode = 3; run example 3.
                Example3(window);
            } else if (mode == 2){ // mode = 2; run example 2.
                Example2(window);
            } else{ // any other input for mode; run default example.
                Example1(window);
            }
            
            // set contents to window
            //window.setContents(content);
            // load compositor
            //loadCompositor(content, window);
        } finally {

        }
    }

    /**
     * Function creates an example input for Lexi.
     */
    public static void Example1(Window window){
        // set up compostion
        Composition root = new Column(window);
        // set contents to root
        window.setContents(root);
        
        // create initial Glyphs
        Row row_1 = new Row(window);
        Row row_2 = new Row(window);
        Column col = new Column(window);

        // populate Glyphs into their respective arrays
        col.insert(new Character('X'), 0);
        col.insert(new Character('Y'), 1);
        col.insert(new Character('Z'), 2);

        row_1.insert(new Character('a'), 0);
        row_1.insert(new Rectangle(15, 30), 1);
        row_1.insert(col, 2);
        row_1.insert(new Character('b'), 3);

        row_2.insert(new Character('y'), 2);
        row_2.insert(new Rectangle(30, 15), 1);
        row_2.insert(new Character('x'), 0);

        root.insert(row_2, 1); // these should populate window
        root.insert(row_1, 0); 
        // return inital column

    }

     /**
     * Function creates an example input for Lexi.
     */
    public static void Example2(Window window){
        window.setContents( new Column(tusk, window) );
    }

    /**
     * Function creates an example input for Lexi.
     */
    public static void Example3(Window window){
        // create column of string array and set contents to column
        
        // test border
        Border border1 = new Border(window);
        border1.insert(new Row("Look at me!",window));
        
        // test scroller
        Scroller scroll1 = new Scroller(window);
        scroll1.insert(new Row("Look at me!",window));
        
        // test scroll in border
        Border border2 = new Border(window);
        Scroller scroll2 = new Scroller(window);
        scroll2.insert(new Column(tusk, window));
        border2.insert(scroll2);
        
        // test border in scroll
        Border border3 = new Border(window);
        Scroller scroll3 = new Scroller(window);
        border3.insert(new Column(tusk, window));
        scroll3.insert(border3);

        // declare rows to contain border elements
        Row row1 = new Row(window);
        Row row2 = new Row(window);

        // insert border elements into rows
        row1.insert(border1, 0);
        row1.insert(scroll1, 1);
        row2.insert(border2, 0);
        row2.insert(scroll3, 1);

        // declare root
        Column root = new Column(window);
        window.setContents(root);

        // insert rows into root
        root.insert(row1, 0);
        root.insert(row2, 1);
    }

    /**
     * Function creates an example input for Lexi to test button and label elements
     * as well as Factory Implementation.
     */
    public static void Example4(Window window){
        // create buttons and labels
        Button button = widgetFactory.createButton(window);
        Label label = widgetFactory.createLabel(window);

        // set contents of buttons and labels
        Row buttcont = new Row(buttonText, window);
        Row buttcont2 = new Row(buttonText, window);
        Row labcont = new Row(labelText, window);
        button.insert(buttcont);
        label.insert(labcont);
        
        // create collum to hold button and label 
        Column col = new Column(window);
        col.insert(button, 0);
        col.insert(buttcont2, 1);
        col.insert(label, 2);

        // create border and scroller nodes
        Border border = new Border(window);
        Scroller scroll = new Scroller(window);

        border.insert(scroll);
        scroll.insert(col);

        // establish root row
        Row root = new Row(window);
        root.insert(border, 0);

        // set contents for window to root
        window.setContents(root);
    }

    /**
     * Function loads an input into the Lexi Compositor, then runs the Compositor
     * @param content : a single Glyph which holds all the input for the compositor.
     * @param window : window that the Glyphs are displayed within.
     */
    /*public static void loadCompositor(Glyph content, Window window){
        // create compositor
        Compositor compositor = new SimpleCompositor();
        // load content into compositor
        compositor.setComposite(content);
        // run composite
        compositor.compose(window);
    }*/
}
