/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloomfilter;

import java.util.Arrays;

/**
 * The array version of the bloom version
 * @author tfourcaudot
 */
public class ArrayBloomFilter extends AbstractBloomFilter {

    // This is protected for the tests
    protected byte[] filter;

    /**
     * Constructor of ArrayBloomFilter
     * @param size the size of the filter
     * @param k the number of hash functions
     */
    public ArrayBloomFilter(int size, int k, int seed) {
        super(size, k, seed);
        filter = new byte[size];
        for (int i = 0; i < size; i++) {
            filter[i] = 0;
        }
    }

    /**
     * Add an element in the filter
     * @param element The element to add 
     */
    @Override
    public void add(int element) {
        for (int i = 0; i < k; i++) {
            int index = hashs[i].hash(element);
            filter[index] = 1;
        }
    }

    /**
     * Verify if an element is in the filter
     * @param element The element we look for
     * @return True if the element in the filter, else instead
     */
    @Override
    public boolean contains(int element) {
        for (int i = 0; i < k; i++) {
            int index = hashs[i].hash(element);
            // System.out.println(index);
            if (filter[index] == 0) {
                return false;
            }
        }
        return true;
    }

}
