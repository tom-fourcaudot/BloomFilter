/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloomfilter;

/**
 *
 * @author tfourcaudot
 */
public class ArrayBloomFilter extends AbstractBloomFilter {

    // This is protected for the tests
    protected byte[] container;

    public ArrayBloomFilter(int size, int k) {
        super(size, k);
        container = new byte[size];
        for (int i = 0; i < size; i++) {
            container[i] = 0;
        }
    }

    @Override
    public void add(int element) {
        for (int i = 0; i < k; i++) {
            int index = hashs[i].hash(element);
            container[index] = 1;
        }
    }

    @Override
    public boolean contains(int element) {
        byte inside = 1;
        for (int i = 0; i < k; i++) {
            int index = hashs[i].hash(element);
            inside &= container[index];
        }
        return inside == 1;
    }

}
