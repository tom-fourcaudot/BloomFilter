/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloomfilter;

import java.util.LinkedList;

/**
 * Linked list version of the Bloom Filter
 * @author tfourcaudot
 */
public class LinkListBloomFilter extends AbstractBloomFilter {

    // protected for test functions
    protected LinkedList<Byte> container;

    /**
     * Construcor of LinkListBloomFilter
     * @param size
     * @param k 
     */
    public LinkListBloomFilter(int size, int k) {
        super(size, k);
        container = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            container.push((byte)0);
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
     * @param element The element we look for
     * @return True if the element in the filter, else instead
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
