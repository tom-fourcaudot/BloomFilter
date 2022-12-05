/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloomfilter;

import java.util.ArrayList;

/**
 * ArrayList version of the BloomFilter
 * @author tfourcaudot
 */
public class ArrayListBloomFilter extends AbstractBloomFilter {

    // protected for the test
    protected ArrayList<Byte> container;
    
    /**
     * Contructor of ArrayBloomFilter
     * @param size size of the filter
     * @param k number of hash functions
     */
    public ArrayListBloomFilter(int size, int k) {
        super(size, k);
        container = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            container.add((byte)0);
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
            container.set(index, (byte)1);
        }
    }

    /**
     * Verify if an element is in the filter
     * @param element the element to check
     * @return True if the elemtn is in the filter, False else
     */
    @Override
    public boolean contains(int element) {
        byte inside = 1;
        for (int i = 0; i < k; i++) {
            int index = hashs[i].hash(element);
            inside &= container.get(index);
        }
        return inside == 1;
    }
    
    
}
