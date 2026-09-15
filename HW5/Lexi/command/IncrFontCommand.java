package command;

// Command (223): represents a ConcreteCommand
// Prototype (117): represents a ConcretePrototype

public class IncrFontCommand extends Command {
    FontFunctionality func;

    public IncrFontCommand(){
        // gets static instance of FontFunctionality
        func = FontFunctionality.getFontFunction();
    }

    // function decrements the fontSize
    @Override
    public void execute() {
        // command should be added to undo list before execute is called
        func.incrFontSize();
    }

    // increments fontSize to undo the decrement
    @Override
    public void unexecute() {
        func.decrFontSize();
    }

    // increment is always undoable
    @Override
    public boolean undoable() {
        return true;
    }
    
}