/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloomfilter;

import java.util.Random;

/**
 * Generic Bloom Filter class.
 * Use to store all the datas sharing by all version of the Bloom Filter
 * @author tfourcaudot
 */
public abstract class AbstractBloomFilter implements IBloomFilter {
    
    // size of the filter
    protected int size;
    // number of hash functions
    protected int k;
    // collection to store all the hash functions
    protected HashFunction[] hashs;
    
    /**
     * Getter of hashs
     * Only for tests
     * @return hashs attribute
     */
    public HashFunction[] getHashs(){
        return hashs;
    }

    /**
     * Constructor of AbstractBloomFilter
     * @param size the size of the filter
     * @param k number of hash functions
     */
    public AbstractBloomFilter(int size, int k, int seed) {
        // Initialize attributes
        this.size = size;
        this.k = k;
        // Initialize the collection
        hashs = new HashFunction[k];
        
        // Create the random offset
        Random r = new Random();
        r.setSeed(seed);
        // Generate the k hash functions and store it in hashs
        for (int i = 0; i < k; i++) {
            hashs[i] = new HashFunction(size, r);
        }
    }

}
