/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Character;

import Manager.CharacterManager;
import Scenes.Playing;
import main.game;
import helps.LevelBuilder;
/**
 *
 * @author HP
 */
public class player extends CharacterBase {
    
    private final static int PLAYER_START_X = 10;
    private final static int PLAYER_START_Y = 10;
    private final static int PLAYER_PIXELS_BY_STEP = 4;
    private  game game;
    private Playing playing;
    
    
    
    
//    private game game;

    public player(game game) {
        super(PLAYER_START_X, PLAYER_START_Y);
        this.game = game;
        playing = game.getPlaying();
        
    }
    
    public void movePlayer(Move move){
        move(move);
        if(collisionWithObstacle()){System.out.println("colide");
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
    
    
    private boolean squareCircleInstersect(int row, int col) {
	//http://stackoverflow.com/questions/401847/circle-rectangle-collision-detection-intersection
	int characterX = (int) this.getX();
	int characterY = (int) this.getY();

	int circleRadius = this.getSize() / 2;
	int squareSize = playing.getTilesSize();
	int squareCenterX = (row*squareSize)+(squareSize/2);
	int squareCenterY = (col*squareSize)+(squareSize/2);

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
    

}
    

