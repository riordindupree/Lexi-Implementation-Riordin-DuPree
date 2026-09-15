******************
# Lexi - Homework 5
* CS 472
* 4/27/26
* Riordin Dupree
******************

## Overview:

This program consists of an updated version of the Lexigraphical editing program known as Lexi. It implements keyboard shortcuts and button commands.

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
- GlyphFinder.java : implements click glyph method

**bound files:** 
- Bounds.java : a representation of the bounds of a given object
- Point.java : a representation of a point (x, y)

**window files:**

**command files:**
- Command.java : abstract command class
- DecrFontCommand.java : represents a "Decrement Font" command.
- IncrFontCommand.java : represents a "Increment Font" command.
- SetFont14Command.java : represents a command to set font size to 14.
- SetFont20Command.java : represents a command to set font size to 20.
- UndoCommand.java : represents a "Undo" command.
- RedoCommand.java : represents a "Redo" command.
- FontFunctionality.java : implements all commands with font in the title
- CommandHistory.java : unimplemented class


**Non-Programming Files:** 
- readme.md : this file.
- Design Pattern Assignment 5 Drawing.pdf : drawing Lexi program design was inspired by.

## Program Design:

I first took the time to create the UML drawing so that I would have a basic idea for the programs structure, occasionally updating the drawing as I worked on the program as I better understood how it functioned.

After copying the files from the github, I first started with planning out the implementations for the command package. I decided to first implement the Font related functions, since that would give me a good basis which could be built off of to test the Command History.

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

    if issues arise where certain java classes won't load, the following can also be run:
    
    $ javac Lexi.java ./command/*.java ./compositor/*.java ./factory/*.java ./compositor/*.java ./glyph/*.java ./point/*.java ./window/*.java  

Then run the program using the java keyword in the terminal in the following format.

    $ java Lexi '#' 'window_name'

Where
  - In 'window_name,' type in a name for the window, or leave it blank.
  - In '#', type in an integer value '5' to run example 5, '4' to run example 4, '3' to run example 3, '2' to run example 2. Leaving the space blank, or typing in any other integer value will run example 1. 
     - Note: Any integer value placed before the 'name' is assumed to be the 'mode'. To input an integer as the windows name, a mode must be given. 

If option 4 or 5 is selected is selected, System will look for a runtime variable which must be set in the terminal.
To set up this run time variable, simply type either of the following in the terminal:
    
    $ export LexiWidget="Red" 
    
*or*

    $ export LexiWidget="Green"

- If "Green" is typed, Lexi will use the Green Widget Factory.
- If "Red" is typed, Lexi will use the Red Widget Factory.

*Note:* The default value of "Red" will be choosen if the input is invalid or not set.