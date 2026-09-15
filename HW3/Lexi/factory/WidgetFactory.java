/**
 * Function acts as an interface of a Factory for making widgets.
 * 
 * Class uses the AbstractFactory(87) design pattern. 
 *  - It represents an "AbstractFactory" from the pattern.
 * 
 * Since it is an AbstractFactory, it must be only an interface for creating products.
 * 
 * Class uses the Singleton(127) design pattern.
 *  - It represents a "Singleton" from the pattern.
 * 
 * Class uses the FactoryMethod(107) design pattern.
 *  - It represents a "Creator" from the pattern.
 * 
 * @author Riordin Dupree
 */

package factory;

import glyph.*;
import window.*;

public abstract class WidgetFactory {
    // declare variables
    private static WidgetFactory instance; // unique instance

    // protected constructor for Widget Factory
    protected WidgetFactory(){}

    // getInstance method (from Singleton design pattern)
    public static WidgetFactory instance(){
        // if instance is null, program initates a new instance.
        if (instance == null){
            // get string value from environment variable to determine look and feel.
            String s=System.getenv("LexiWidget");
            // decide look and feel based on environment variable
            if (s!=null && s.equals("Green")){
                // get Green Factory
                instance = new GreenFactory();
            }else{
                // get Red Factory
                instance = new RedFactory();
            }
        }
        // return instance
        return instance;
        
    }

    // get Data methods + Create() methods
    public Label createLabel( Window window){
        return this.makeLabel(window);
    }
    public Button createButton( Window window ){
        return this.makeButton(window);
    }

    // Factory Methods to be implemented by Concrete Creators
    public abstract Label makeLabel(Window window);
    public abstract Button makeButton(Window window);
}
