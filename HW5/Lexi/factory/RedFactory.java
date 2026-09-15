/**
 * Creates a Red Factory based on the Abstract Widget Factory.
 * 
 * Class uses the AbstractFactory(87) design pattern. 
 *  - It represents an "ConcreteFactory" in the pattern.
 * 
 * Class uses the Singleton(127) design pattern.
 *  - It represents a "Singleton" from the class.
 * 
 * Concrete Factories are made into Singletons, as generally, 
 * only one Concrete Factory should ever be needed at a time.
 * 
 * Class uses the FactoryMethod(107) design pattern.
 *  - It represents a "ConcreteCreator" from the pattern.
 * 
 * @author Riordin Dupree
 */

package factory;

import glyph.*;
import window.*;

public class RedFactory extends WidgetFactory {

    // private package constructor for RedFactory
    protected RedFactory(){}
    
    // Factory Methods (from Factory Method design pattern)
    @Override
    protected Label makeLabel(Window window) {
        return new RedLabel(window);
    }

    @Override
    protected Button makeButton(Window window) {
        return new RedButton(window);
    }
    
}
