/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloomfilter;

import java.util.Random;

/**
 *
 * @author tfourcaudot
 */
public class HashFunction {
    private final int SIZE;
    private final int MULT;
    private final int OFFSET;
    
    public HashFunction(int size) {
        this.SIZE = size;
        Random r = new Random();
        MULT = r.nextInt(size)+1;
        OFFSET = r.nextInt(size)+1;
    }
    
    public int hash(int element) {
        return Math.abs(((element + SIZE/2)*MULT + OFFSET)%SIZE);
    }
}
