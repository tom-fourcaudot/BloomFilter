/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloomfilter;

import java.util.Random;

/**
 * Class to store a generic hash function
 * @author tfourcaudot
 */
public class HashFunction {
    // Size of the filter
    private final int SIZE;
    // Attribute to randomize the hash function
    private final int MULT;
    private final int OFFSET;
    
    /**
     * Constructor of HashFunction
     * @param size size of the filter we will hash
     */
    public HashFunction(int size, Random r) {
        // Initialize atributes
        this.SIZE = size;
        MULT = r.nextInt()+1;
        OFFSET = r.nextInt()+1;
    }
    
    /**
     * Hash an element
     * @param element the element to hash
     * @return the hashed element
     */
    public int hash(int element) {
        return Math.abs(((element + SIZE)*MULT + OFFSET)%SIZE);
    }
}
