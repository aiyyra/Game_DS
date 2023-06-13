/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Map;

import java.util.ArrayList;
import java.util.Collections;

public class AnswerDecryption {
    public static void main(String[] args) {
        System.out.println(decrypt(17355, 7));
    }

        public static int decrypt(int number, int key) {
        String binary = Integer.toBinaryString(number);
        while (binary.length() % 3 != 0) {
            binary = "0" + binary;
        }

        ArrayList<String> blocks = new ArrayList<>();
        for (int i = 0; i < binary.length(); i += 3) {
            blocks.add(binary.substring(i, i + 3));
        }

        Collections.reverse(blocks);

        ArrayList<String> decryptedBlocks = new ArrayList<>();
        for (String block: blocks) {
            int blockValue = Integer.parseInt(block, 2);
            if (blockValue == 0) {
                decryptedBlocks.add(block);
            }
            else {
                blockValue -= key % 2;
                block = Integer.toBinaryString(blockValue);
                while (block.length() < 3) {
                    block = "0" + block;
                }
                decryptedBlocks.add(block);
                key = key >> 1;
            }

        }
        Collections.reverse(decryptedBlocks);

        StringBuilder decryptedBinary = new StringBuilder();
        for (String block : decryptedBlocks) {
            decryptedBinary.append(block);
        }
        return Integer.parseInt(decryptedBinary.toString(), 2);
    }
}
