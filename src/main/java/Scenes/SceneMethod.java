/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Scenes;

import java.awt.Graphics;

/**
 *
 * @author HP
 */
public interface SceneMethod {
    public void render(Graphics g);
    public void mouseClicked(int x, int y);
    public void mouseMoved(int x, int y);
    public void mousePressed(int x, int y); 
    public void mouseReleased(int x, int y); 
//    public void mouseDragged(int x,int y);
}
