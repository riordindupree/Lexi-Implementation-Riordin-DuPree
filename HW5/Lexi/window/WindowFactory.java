package window;

/**
 * Factory for creating WindowImp Objects.
 * 
 * Class uses the AbstractFactory(87) design pattern. 
 *  - It represents an "AbstractFactory" from the pattern.
 * 
 * Class uses the Singleton(127) design pattern.
 *  - It represents a "Singleton" from the pattern.
 * 
 * Class uses the FactoryMethod(107) design pattern.
 *  - It represents a "Creator" from the pattern.
 * 
 * @author Riordin Dupree
 */


public abstract class WindowFactory {

    // declare variables
    private static WindowFactory instance; // unique instance

    // protected constructor for Window Factory
    protected WindowFactory(){}

    // getInstance method (from Singleton design pattern)
    public static WindowFactory window_instance(){
        // if instance is null, program initates a new instance.
        if (instance == null){
            // get string value from environment variable to determine window type.
            String s=System.getenv("LexiWindow");
            // decide window type based on environment variable
            if (s!=null && s.equals("Awt")){
                // get Green Factory
                instance = new SwingWindowFactory();
            }else{
                // get Red Factory
                instance = new AwtWindowFactory();
            }
        }
        // return instance
        return instance;
    }    

    // get Data methods + Create() methods
    public WindowImp createWindow(String title, Window window){
        return this.makeWindow(title, window);
    }

    // Factory Methods to be implemented by Concrete Creators
    protected abstract WindowImp makeWindow(String title, Window window);

}
