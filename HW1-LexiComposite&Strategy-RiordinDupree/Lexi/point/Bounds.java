/** 
 * Function represents the bounds of a given object.
 * 
 * @author Riordin Dupree
 */

package point;

public class Bounds {
    private Point point;
    private int width;
    private int height;

    /* Constructor (1 with Point, one with x & y?) */
    public Bounds(Point p, int w, int h){
        point = p;
        width = w;
        height = h;
    }
    /* Constructor (1 with Point, one with x & y?) */
    public Bounds(int x, int y, int w, int h){
        point = new Point(x, y);
        width = w;
        height = h;
    }

    /* See if click touched area defined by bounds */
    public boolean touched(int x, int y){ 
        int x_1 = point.getX();
        int y_1 = point.getY();
        int x_2 = x_1 + width;
        int y_2 = y_1 + height;
        if ((x_1 <= x && x <= x_2) && (y_1 <= y && y <= y_2)){
            return true;
        }
        return false;
    }
    /* Get Width */
    public int getWidth(){ return width; }
    /* Get Height */
    public int getHeight(){ return height; }
    /* Get X */
    public int getX(){ return point.getX(); }
    /* Get Y */
    public int getY(){ return point.getY(); }
    /* Set Width */
    public void setWidth( int w ){ width = w; }
    /* Set Height */
    public void setHeight( int h ){ height = h; }
    /* Set X */
    public void setX(int x){ point.setX(x); }
    /* Set Y */
    public void setY(int y){ point.setY(y); }
}
