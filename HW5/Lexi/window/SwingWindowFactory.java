package window;

/**
 * AbstractFactory(87): ConcreteFactory
 * Singleton(127): Singleton
 * FactoryMethod(107): ConcreteCreator
 * 
 * @author Riordin Dupree
 */

public class SwingWindowFactory extends WindowFactory {
    // protected constructor for AwtWindowFactory
    protected SwingWindowFactory(){}
    
    // Factory Methods (from Factory Method design pattern)
    @Override
    protected WindowImp makeWindow(String title, Window window) {
        return new SwingWindow(title, window);
    }
}
