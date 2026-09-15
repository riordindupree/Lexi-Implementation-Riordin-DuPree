/**
 * Creates a Green Factory based on the Abstract Widget Factory.
 * 
 * Class uses the AbstractFactory(87) design pattern. 
 *  - It represents an "ConcreteFactory" from the pattern.
 * 
 *  Class uses the Singleton(127) design pattern.
 *  - It represents a "Singleton" from the pattern.
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

public class GreenFactory extends WidgetFactory {

    // private package constructor for GreenFactory
    GreenFactory(){}

    // Factory Methods (from Factory Method design pattern)
    @Override
    public Label makeLabel(Window window) {
        return new GreenLabel(window);
    }

    @Override
    public Button makeButton(Window window) {
        return new GreenButton(window);
    }
    
}
