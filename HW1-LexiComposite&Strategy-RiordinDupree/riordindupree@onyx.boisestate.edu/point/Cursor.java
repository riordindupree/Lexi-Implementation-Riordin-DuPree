package point;

public class Cursor extends Bounds {

    public Cursor(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    public Cursor(Point point, int w, int h){
        super(point, w, h);
    }
    
}
