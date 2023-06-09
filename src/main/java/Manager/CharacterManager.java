/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manager;

import Character.CharacterBase;
import Scenes.Playing;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Stack;

/**
 *
 * @author HP
 */
public class CharacterManager {
    
    private Playing playing;
    public CharacterBase testChar;
    private float speed = 3f;
    private Stack<location> stationstack = new Stack();
    private location location = new location();

    public CharacterManager(Playing playing) {
        this.playing = playing;
        testChar = new CharacterBase(24*0,24*0);
    }
    
    //undo position without save
    public void respawn(){
        stationstack.pop();
        if(stationstack.isEmpty()){
            playing.setEndgame(true);
        }
        else {
            location temp = stationstack.peek();
            this.testChar = new CharacterBase(temp.x,temp.y);
            stationstack.pop();
        }
        
    }
    
    // undo position while save checkpoint
//    public void respawn(){
//        stationstack.pop();
//        if(stationstack.isEmpty()){
//            playing.setEndgame(true);
//        }
//        else {
//            location temp = stationstack.peek();
//            this.testChar = new CharacterBase(temp.x,temp.y);
//        }
//        
//    }
    
    public void respawn(int x, int y){
        this.testChar = new CharacterBase(x,y);
    }
    
    public void Update(){
        if(collisionWithExit())playing.setEndgame(true);
    }
    
    public void goup(){
        testChar.setY(testChar.getY()-speed);
        if(collisionWithObstacle())godown();
        if(collisionWithStation()){
            System.out.println("collide");
            playing.setTicTacToeStatus(true);
        }
    }
    public void godown(){
        testChar.setY(testChar.getY()+speed);
        if(collisionWithObstacle())goup();
        if(collisionWithStation()){
            System.out.println("collide");
            playing.setTicTacToeStatus(true);
        }
    }
    public void goright(){
        testChar.setX(testChar.getX()+speed);
        if(collisionWithObstacle())goleft();
        if(collisionWithStation()){
            System.out.println("collide");
            playing.setTicTacToeStatus(true);
        }
    }
    public void goleft(){
        testChar.setX(testChar.getX()-speed);
        if(collisionWithObstacle())goright();
        if(collisionWithStation()){
            System.out.println("collide");
            playing.setTicTacToeStatus(true);
        }
    }
    
    public void Draw(Graphics g){
        drawCharacter(testChar,g);
        
    }

    private void drawCharacter(CharacterBase e, Graphics g) {
        int size = 21;
        int x = (int)e.getX()+2;
        int y = (int)e.getY()+2;
        g.setColor(Color.cyan);
        g.fillOval(x, y, size, size);
    }

    public Stack<location> getStationstack() {
        return stationstack;
    }
    
    public location getlocation(){
        this.setLocation();
        return location;
    }
    
    public void setLocation() {
        int x= (int)testChar.getX();
        int y= (int)testChar.getY();
        
        location.x=x;
        location.y=y;
    }
    
public class location{
    int x=24;
    int y=24;

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
}
    
    public boolean collisionWithObstacle(){
        int [][] tiles = playing.getMap();
	//Maybe create if statements to only check nearby squares
	for (int i = 0; i < tiles.length; i++) {
	    for (int j = 0; j < tiles[0].length; j++) {
		if(tiles[i][j] == 1 ){
		    boolean isIntersecting = squareCircleInstersect(i, j);
                    
		    if (isIntersecting) {
			return true;
		    }
		}
	    }
	}
	return false;
    }
    
    public boolean collisionWithStation(){
        int [][] tiles = playing.getMap();
	//Maybe create if statements to only check nearby squares
	for (int i = 0; i < tiles.length; i++) {
	    for (int j = 0; j < tiles[0].length; j++) {
		if(tiles[i][j] == 2 ){
		    boolean isIntersecting = stationInstersect(i, j);
                    
		    if (isIntersecting) {
                        stationstack.push(getlocation());
                        this.location = new location();
			return true;
		    }
		}
	    }
	}
	return false;
    }
    
    public boolean collisionWithExit(){
        int [][] tiles = playing.getMap();
	//Maybe create if statements to only check nearby squares
	for (int i = 0; i < tiles.length; i++) {
	    for (int j = 0; j < tiles[0].length; j++) {
		if(tiles[i][j] == 3 ){
		    boolean isIntersecting = stationInstersect(i, j);
                    
		    if (isIntersecting) {
			return true;
		    }
		}
	    }
	}
	return false;
    }
    
    
    private boolean squareCircleInstersect(int row, int col) {
	//http://stackoverflow.com/questions/401847/circle-rectangle-collision-detection-intersection
	int characterX = (int) testChar.getX();
	int characterY = (int) testChar.getY();

	int circleRadius = testChar.getSize() / 2;
	int squareSize = playing.getTilesSize();
	int squareCenterX = (row*squareSize);//+(squareSize/2);
	int squareCenterY = (col*squareSize);//(squareSize/2);

	int circleDistanceX = Math.abs(characterX - squareCenterX);
	int circleDistanceY = Math.abs(characterY - squareCenterY);

	if (circleDistanceX > (squareSize/2 + circleRadius)) { return false; }
	if (circleDistanceY > (squareSize/2 + circleRadius)) { return false; }

	if (circleDistanceX <= (squareSize/2)) { return true; }
	if (circleDistanceY <= (squareSize/2)) { return true; }

	int cornerDistance = (circleDistanceX - squareSize/2)^2 +
							      (circleDistanceY - squareSize/2)^2;

	return (cornerDistance <= (circleRadius^2));
    }
    
    private boolean stationInstersect(int row, int col) {
	//http://stackoverflow.com/questions/401847/circle-rectangle-collision-detection-intersection
	int characterX = (int) testChar.getX();
	int characterY = (int) testChar.getY();

	int circleRadius = testChar.getSize() / 2;
	int squareSize = playing.getTilesSize();
	int squareCenterX = (row*squareSize)+1;//+(squareSize/2);
	int squareCenterY = (col*squareSize)+1;//(squareSize/2);

	int circleDistanceX = Math.abs(characterX - squareCenterX);
	int circleDistanceY = Math.abs(characterY - squareCenterY);

	if (circleDistanceX > 1) { return false; }
	if (circleDistanceY > 1) { return false; }

	if (circleDistanceX <= (squareSize/2)) { return true; }
	if (circleDistanceY <= (squareSize/2)) { return true; }

	int cornerDistance = (circleDistanceX - squareSize/2)^2 +
							      (circleDistanceY - squareSize/2)^2;

	return (cornerDistance <= (circleRadius^2));
    }
    
    
}
