/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helps;

/**
 *
 * @author HP
 */
import Map.*;
import java.util.List;
import java.util.Random;
public class LevelBuilder {
    
    
    public static int [][] getshortpath(){
        //declare for all pic
        FirstSearch CompMap = new FirstSearch();
        CompMap.ImageReader();
        
        //find path
        List<List<String>> ShortestPathsCollection = ShortestPath.FindShortestPaths(CompMap.FullMap());

        //get and return path
        Random rnd = new Random();
        List<String> path = ShortestPathsCollection.get(rnd.nextInt(ShortestPathsCollection.size()));
        
        int[][] MatrixNew = AllAboutMatrix.GenNewMatrix(path);
        
        return MatrixNew;
    }
    
    public static int[][] getLevelData(){
        //create 2d array
        //place every tiles
        int [][] map = new Map.FinalMap().getFin();
        return map;
        //could also create other level
    }
}
