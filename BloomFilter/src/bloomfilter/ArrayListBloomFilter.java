/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloomfilter;

import java.util.ArrayList;

/**
 *
 * @author tfourcaudot
 */
public class ArrayListBloomFilter extends AbstractBloomFilter {

    protected ArrayList<Byte> container;
    
    public ArrayListBloomFilter(int size, int k) {
        super(size, k);
        container = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            container.add((byte)0);
        }
    }
    
    @Override
    public void add(int element) {
        for (int i = 0; i < k; i++) {
            int index = hashs[i].hash(element);
            container.set(index, (byte)1);
        }
    }

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
