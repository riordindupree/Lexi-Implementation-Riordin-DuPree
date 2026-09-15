package command;

// Command (223): represents a ConcreteCommand
// Prototype (117): represents a ConcretePrototype

public class DecrFontCommand extends Command {
    FontFunctionality func;

    public DecrFontCommand(){
        // gets static instance of FontFunctionality
        func = FontFunctionality.getFontFunction();
    }

    // function decrements the fontSize
    @Override
    public void execute() {
        // command should be added to undo list before execute is called
        func.decrFontSize();
    }

    // increments fontSize to undo the decrement
    @Override
    public void unexecute() {
        func.incrFontSize();
    }

    // returns true if following decrement would be undoable
    @Override
    public boolean undoable() {
        return func.getFontSize() > 1;
    }
    
}
