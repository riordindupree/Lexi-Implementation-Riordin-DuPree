package command;

// Command (223): represents a ConcreteCommand
// Prototype (117): represents a ConcretePrototype

public class SetFont20Command extends Command {
    FontFunctionality func;

    public SetFont20Command(){
        // gets static instance of FontFunctionality
        func = FontFunctionality.getFontFunction();
    }

    // function sets the fontSize to 20
    @Override
    public void execute() {
        // command should be added to undo list before execute is called
        func.setFontSize(20);
    }

    // reverts font size to previous font size
    @Override
    public void unexecute() {
        // unimplemented
    }

    // returns true if font size does not equal 20
    @Override
    public boolean undoable() {
        return func.getFontSize() != 20;
    }
    
}

