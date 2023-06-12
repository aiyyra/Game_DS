/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manager;

import Objects.Tile;
import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class TileManager {
    
    public Tile EMPTY_SPACES,OBSTACLES,STATIONS,FINAL_DESTINATION;
    
    public ArrayList<Tile> tiles = new ArrayList<>();

    public TileManager() {
        
        createTiles();
    }

    private void createTiles() {
        tiles.add(EMPTY_SPACES = new Tile(Color.WHITE,1));
        tiles.add(OBSTACLES = new Tile(Color.BLACK,2));
        tiles.add(STATIONS = new Tile(Color.orange,3));
        tiles.add(FINAL_DESTINATION = new Tile(Color.RED,4));
    }
    
    public Color getColor(int id){
        return tiles.get(id).getColor();
    }
    
    public int getVal(int id){
        return tiles.get(id).getVal();
    }
    
    
    
    //Boleh tgok balik utk ganti paint dgn gambar (eps 5)
}
