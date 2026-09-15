package command;

// Singleton (127)
// Command (223): represents a Receiver

public class FontFunctionality {
    private int font_size = 10;
    private static FontFunctionality func;

    private FontFunctionality(){}

    public static FontFunctionality getFontFunction(){
        if (func == null){
            return new FontFunctionality();
        }else{
            return func;
        }
    }

    // returns document font size
    public int getFontSize(){
        return font_size;
    }

    // sets Font size to a given integer
    public void setFontSize(int i){
        font_size = i;
    }

    // increments Font Size by 1
    public void incrFontSize(){
        font_size++;
    }

    // decrements Font Size by 1 (if font size > 1)
    public void decrFontSize(){
        if (font_size > 1){
            font_size--;
        }
    }
}
