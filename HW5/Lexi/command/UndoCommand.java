package command;

// Command (223): represents a ConcreteCommand
// Prototype (117): represents a ConcretePrototype

public class UndoCommand extends Command {
    CommandHistory func;

    public UndoCommand(){
        // save instance of command history
    }

    // function decrements the fontSize
    @Override
    public void execute() {
        // call undo function in CommandHistory
    }

    // increments fontSize to undo the decrement
    @Override
    public void unexecute() {
        throw new  IllegalStateException(); 
    }

    // undo cannot be undone.
    @Override
    public boolean undoable() {
        return false;
    }
}
