/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manager;

import Objects.Tile;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import helps.LoadSave;
/**
 *
 * @author HP
 */
public class TileManager {
    
    public Tile EMPTY_SPACES,OBSTACLES,STATIONS,FINAL_DESTINATION;
    public BufferedImage atlas;
    
    public ArrayList<Tile> tiles = new ArrayList<>();

    public TileManager() {
        
        loadAtlas();
        paintTiles();
    }

    private void paintTiles() {
//        tiles.add(EMPTY_SPACES = new Tile(Color.WHITE,1));
//        tiles.add(OBSTACLES = new Tile(Color.BLACK,2));
//        tiles.add(STATIONS = new Tile(Color.orange,3));
//        tiles.add(FINAL_DESTINATION = new Tile(Color.RED,4));
        tiles.add(EMPTY_SPACES = new Tile(getSprite(0, 0)));
        tiles.add(OBSTACLES = new Tile(getSprite(2, 1)));
        tiles.add(STATIONS = new Tile(getSprite(0, 2)));
        tiles.add(FINAL_DESTINATION = new Tile(getSprite(1, 2)));

    }
    
    public Color getColor(int id){
        return tiles.get(id).getColor();
    }
    
    public int getVal(int id){
        return tiles.get(id).getVal();
    }
    
    public void loadAtlas(){
        atlas = LoadSave.getSpriteAtlas();
    }
    
    public BufferedImage getSprite(int id){
        return tiles.get(id).getSprite();
    }
    
    private BufferedImage getSprite(int x, int y){
        return atlas.getSubimage(x*25, y*25, 25, 25);
    }
    
    //Boleh tgok balik utk ganti paint dgn gambar (eps 5)
}
