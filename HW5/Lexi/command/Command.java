package command;

/**
 * First we define a Command abstract class to provide an interface for issuing a request.
The basic interface consists of a single abstract operation called "Execute." Subclasses
of Command implement Execute in different ways to fulfill different requests. Some
subclasses may delegate part or all ofthe work to other objects. Other subclasses may be
in a position to fulfill the request entirely on their own (seeFigure 2.11).Tothe requester,
however, a Command object is a Command object—they are treated uniformly.

Command Pattern
Lexi's commands are an application of the Command (233) pattern, which describes
how to encapsulate a request. The Command pattern prescribes a uniform interface
for issuing requests that lets you configure clients to handle different requests. The
interface shields clients from the request'simplementation. A command may delegate
all, part, or none of the request's implementation to other objects. This is perfect for
applications like Lexi that must provide centralized access to functionality scattered
throughout the application. The pattern also discusses undo and redo mechanisms
built on the basic Command interface.
*/

// Command (223): represents a Command
// Prototype (117): represents a Prototype

public abstract class Command {

    // main function for command pattern
    public abstract void execute();
    
    // functions for undo functionality
    public abstract void unexecute();
    public abstract boolean undoable();

}
