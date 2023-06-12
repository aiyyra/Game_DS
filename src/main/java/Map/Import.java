/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Map;

/**
 *
 * @author HP
 */

import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;


public class Import {
    
    public static void main(String[] args) throws IOException{
        
        int[][] matrix = {{1,2},{3,4}};
        int[][] myInt = new int[4][4];
        System.out.println(Arrays.deepToString(myInt));
        System.out.println("");
        for(int i = 0; i< matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                myInt[i+2][j] = matrix[i][j];
            }
        }
        System.out.println(Arrays.deepToString(matrix));
        System.out.println(Arrays.deepToString(myInt));
        
    }
}
