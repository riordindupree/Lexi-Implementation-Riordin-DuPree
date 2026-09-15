package command;

// Command (223): represents a ConcreteCommand
// Prototype (117): represents a ConcretePrototype

public class SetFont14Command extends Command {
    FontFunctionality func;

    public SetFont14Command(){
        // gets static instance of FontFunctionality
        func = FontFunctionality.getFontFunction();
    }

    // function sets the fontSize to 14
    @Override
    public void execute() {
        // command should be added to undo list before execute is called
        func.setFontSize(14);
    }

    // function reverts font size to previous font size
    @Override
    public void unexecute() {
        // unimplemented
    }

    // returns true if font size != 14
    @Override
    public boolean undoable() {
        return func.getFontSize() != 14;
    }
    
}
