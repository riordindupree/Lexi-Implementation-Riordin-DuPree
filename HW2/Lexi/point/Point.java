/** 
 * Stores an x and y value representing a position.
 * 
 * @author Riordin Dupree
 */
package point;

public class Point {
    private int x;
    private int y;

    /* Constructor */
    public Point(int p_x, int p_y){
        x = p_x;
        y = p_y;
    }
    
    /* Get X */
    public int getX(){ return x; }
    /* Get Y */
    public int getY(){ return y; }
    /* Set X */
    public void setX( int new_x){ x = new_x; }
    /* Set Y */
    public void setY( int new_y){ y = new_y; }
}
