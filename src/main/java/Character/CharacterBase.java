/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Character;

import java.awt.Rectangle;

/**
 *
 * @author HP
 */
public class CharacterBase {
    private final static int size = 20;
    private float x;
    private float y;
    private float pixelsPerStep;
    private Rectangle bounds;
    
    public CharacterBase(int x,int y){
        this.x = x;
        this.y = y;
        this.bounds = new Rectangle((int)this.x,(int)this.y,25,25);
        this.pixelsPerStep = 1.5f;
    }
    
    public void move(float x,float y){
        this.x +=x;
        this.y +=y;
    }
    
    public enum Move{
	DOWN(0, 1),
	UP(0, -1), 
	RIGHT(1, 0),
	LEFT(-1, 0);

	private final int deltaX;
	private final int deltaY;
	Move(final int deltaX, final int deltaY) {
	    this.deltaX = deltaX;
	    this.deltaY = deltaY;
	}
    }
    
    public void move(Move move) {
	y += move.deltaY * pixelsPerStep;
	x += move.deltaX * pixelsPerStep;
        
    }

    
    public float getX() {
	return x;
    }
    
    public float getY() {
	return y;
    }

    public static int getSize() {
        return size;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }
    
    
   
}
