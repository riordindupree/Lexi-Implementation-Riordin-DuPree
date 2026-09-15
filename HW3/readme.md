******************
* Lexi - Homework 3
* CS 472
* 4/6/26
* Riordin Dupree
******************

**Overview:**

    This program consists of an updated version of the Lexigraphical editing program known as Lexi.

**Included Files:**

    lexi files:
    - Lexi.java : main program for Lexi

    compositor files:
    - Compositor.java : a generic implementation of a compositor
    - SimpleCompositer : a simple compositor based on a simple compositor system.
    
    factory files:
    - WidgetFactory.java : a generic class for a factory that works over widgets.
    - RedFactory.java : the red widget factory.
    - GreenFactory.java : the green widget factory.

    glyph files:
    - Glyph.java : a generic class for all Glyphs in Lexi
    - Character.java : a class representing a Character in Lexi
    - Rectangle.jave : a class representing a Rectangle in Lexi
    - CompositeGlyph.java : a generic class for a composite glyph
    - Composition.java : a generic class for the implementation of a glyph capable of being run through a compositor.
    - Row.java : a composite glyph order horizontally
    - Column.java : a composite glyph order vertically

    - Widget.java : a generic class for a glyph based on widgets.
    - Button.java : a generic class for a button glyph for the Lexi editor.
    - Label.java : a generic class for a label glyph for the Lexi editor.
    - RedButton.java : an implementation of a Button made to work with RedFactory
    - GreenButton.java : an implementation of a Button made to work with GreenFactory
    - RedLabel.java : an implementation of a Label made to work with RedFactory
    - GreenLabel.java : an implementation of a Label made to work with GreenFactory

    bound files: 
    - Bounds.java : a representation of the bounds of a given object
    - Point.java : a representation of a point (x, y)

    window files:
    - Window.java : a generic class for a window
    - SwingWindow.java : an implementation of a window for Lexi

    
    Non-Programming Files: 
    - readme.md : this file.
    - Homework3-UML-Design.pdf : A pdf file showing the UML for the Lexi Program.
    
**Running The Program:**

The main process for running the program is explained at the top of Lexi.java. The Lexi program has several different "modes" which, which were used to ensure that newer systems did not mess with the output for older models of the Lexi program.

  To run the program, use javac in the Lexi Folder through the terminal.
   $ javac Lexi.java
  
  Then run the program using the java keyword in the terminal in the following format.
   $ java Lexi '#' 'window_name'
  
  Where
   - In 'window_name,' type in a name for the window, or leave it blank.
   - In '#', type in an integer value '4' to run example 4, '3' to run example 3, '2' to run example 2.
     Leaving the space blank, or typing in any other integer value will run example 1. 
  
  Note: Any integer value placed before the 'name' is assumed to be the 'mode'. 
        To input an integer as the windows name, a mode must be given.
  
  If option 4 is selected, System will look for a runtime variable which must be set in the terminal.
  To set up this run time variable, simple type either of the following in the terminal:
       1)   $ export LexiWidget="Red"
       2)   $ export LexiWidget="Green"
  
  If "Green" is typed, Lexi will use the Green Widget Factory.
  If "Red" is typed, Lexi will use the Red Widget Factory.
  
  If no value is given, the default value of "Red" is choosen.

**Program Design:**

A lot of the program was made with help from the textbook "Design Patterns Elements of Reusable Object-Oriented Software" by Erich Gamma, Richard Helm, etc.

Namely, I found pages 107 to 115 extremely helpful for understanding how the AbstractFactory was supposed to work, as well as for help with understanding the concept of a Singleton.

An issue was noticed with this version of the program related to the Embellishment class. The issue causes the program to not always format Glyph's properly when the root Glyph is a type of Embellishment. However, so long as the root node is of a type column, or row, the program will function correctly.

Since Widgets extend the Embellishment class, it is reasonable to assume that they also have this issue (However, it should be noted that I did not have the time to test if this was the case myself).