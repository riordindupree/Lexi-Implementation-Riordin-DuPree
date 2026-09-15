******************
# Lexi - Homework 4
* CS 472
* 4/15/26
* Riordin Dupree
******************

## Overview:

This program consists of an updated version of the Lexigraphical editing program known as Lexi. This update adds functionality to allow different Windows to be open using an environment variable.

## Included Files:

**lexi files:**
- Lexi.java : main program for Lexi

**compositor files:**
- Compositor.java : a generic implementation of a compositor
- SimpleCompositer : a simple compositor based on a simple compositor system.

**factory files:**
- WidgetFactory.java : a generic class for a factory that works over widgets.
- RedFactory.java : the red widget factory.
- GreenFactory.java : the green widget factory.

**glyph files:**
- Glyph.java : a generic class for all Glyphs in Lexi
- Character.java : a class representing a Character in Lexi
- Rectangle.jave : a class representing a Rectangle in Lexi

- CompositeGlyph.java : a generic class for a composite glyph
- Composition.java : a generic class for the implementation of a glyph capable of being run through a compositor.
- Row.java : a composite glyph order horizontally
- Column.java : a composite glyph order vertically

- Embellishment.java : an abstract class for the implementation of Embellishments.
- Border.java : an implementation of Embellishment which creates a border around a composition.
- Scroller.java : an implementation of Embellishment which creates a Scroller next to a composition.

- Widget.java : a generic class for a glyph based on widgets.
- Button.java : a generic class for a button glyph for the Lexi editor.
- Label.java : a generic class for a label glyph for the Lexi editor.
- RedButton.java : an implementation of a Button made to work with RedFactory
- GreenButton.java : an implementation of a Button made to work with GreenFactory
- RedLabel.java : an implementation of a Label made to work with RedFactory
- GreenLabel.java : an implementation of a Label made to work with GreenFactory

**bound files:** 
- Bounds.java : a representation of the bounds of a given object
- Point.java : a representation of a point (x, y)

**window files:**



**Non-Programming Files:** 
- readme.md : this file.
- Lexi_UML_Drawing_HMWK4.pdf : A pdf file showing the UML for the Lexi Program.
    
## Running The Program:

The main process for running the program is explained at the top of Lexi.java. The Lexi program has several different "modes" which were used to ensure that newer systems did not mess with the output for older models of the Lexi program.

Before running Lexi, it is best to first set a run time variable for a desire window type through the terminal.
To set up this run time variable, simply type either of the following in the terminal:

    $ export LexiWindow="Awt" 

*or*

    $ export LexiWindow="Swing"

- If "Awt" is typed, Lexi will create an Awt Window.
- If "Swing" is typed, Lexi will create a Swing Window.

*Note:* The default value of "Swing" will be choosen if the input is invalid or not set.

To run the program, use javac in the Lexi Folder through the terminal.

    $ javac Lexi.java

Then run the program using the java keyword in the terminal in the following format.

    $ java Lexi '#' 'window_name'

Where: 
- In 'window_name,' type in a name for the window, or leave it blank.
- In '#', type in an integer value '4' to run example 4, '3' to run example 3, '2' to run example 2. Leaving the space blank, or typing in any other integer value will run example 1. 
    - Note: Any integer value placed before the 'name' is assumed to be the 'mode'. To input an integer as the windows name, a mode must be given.

If option 4 is selected, System will look for a runtime variable which must be set in the terminal.
To set up this run time variable, simply type either of the following in the terminal:
    
    $ export LexiWidget="Red" 
    
*or*

    $ export LexiWidget="Green"

- If "Green" is typed, Lexi will use the Green Widget Factory.
- If "Red" is typed, Lexi will use the Red Widget Factory.

*Note:* The default value of "Red" will be choosen if the input is invalid or not set.

## Program Design:

Before getting started on development, I first reviewed the lecture notes, as well as the textbook, taking notes on what was important for the assignment. This gave me a good idea of what I needed to do, and allowed me to know what I needed better clarification on when I actually got working on the assingment. At this point, I had also gotten started on, but had not quite finished the UML design.

In terms of developing the program, I first started with the creation of the WindowFactory system. I since, when starting on this project, I had recently just finished the previous factory assignment. This meant that I had a very easy place to start for implementation for Window factory, since I could just copy the commands from Widget Factory as a starting point. On top of this, having just finished the previous factory system meant that I still had a lot of the ideas on the original on mind, so I had a really good understanding of the way in which the system worked.

The process of making the factory for Window also helped me better understand how the Bridge(151) pattern was supposed to be used. First I spent some time trying to figure out the construction of the system, asking the instructor a few questions in class, as well as finishing the UML design.

With all of the work done, I then got to the process of implementing the Bridge(151) functionality, which was relatively easy given all the previous work. After that, I looked back at the readme.md file for Homework 3 to help with testing, as well as beginning the editting of it for this assingment.