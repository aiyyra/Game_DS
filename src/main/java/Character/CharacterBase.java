/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Character;

import java.awt.Rectangle;
import java.io.Serializable;

/**
 *
 * @author HP
 */
public class CharacterBase implements Serializable{
    private final static int size = 20;
    private float x;
    private float y;
    private int score;
    
    public CharacterBase(int x,int y){
        this.x = x;
        this.y = y;
        this.score =0;
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
    
    public float getX() {
	return x;
    }
    
    public float getY() {
	return y;
    }

    public static int getSize() {
        return size;
    }

    public int getScore() {
        return score;
    }
    
    

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    @Override
    public String toString() {
        String s = "x: "+getX()+"\ny: "+getY();
        return s;
    }
    
    
    public void addscore(int add){
        score +=add;
    }
}
