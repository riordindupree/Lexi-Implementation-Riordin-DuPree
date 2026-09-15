package window;

/**
 * AbstractFactory(87): ConcreteFactory
 * Singleton(127): Singleton
 * FactoryMethod(107): ConcreteCreator
 * 
 * @author Riordin Dupree
 */

public class AwtWindowFactory extends WindowFactory {
    // private package constructor for AwtWindowFactory
    protected AwtWindowFactory(){}
    
    // Factory Methods (from Factory Method design pattern)
    @Override
    protected WindowImp makeWindow(String title, Window window) {
        return new AwtWindow(title, window);
    }
}
