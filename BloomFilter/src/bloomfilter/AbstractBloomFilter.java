/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloomfilter;

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
     * Constructor of AbstractBloomFilter
     * @param size the size of the filter
     * @param k number of hash functions
     */
    public AbstractBloomFilter(int size, int k) {
        // Initialize attributes
        this.size = size;
        this.k = k;
        // Initialize the collection
        hashs = new HashFunction[k];
        // Generate the k hash functions and store it in hashs
        for (int i = 0; i < k; i++) {
            hashs[i] = new HashFunction(size);
        }
    }

}
