/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloomfilter;

/**
 *
 * @author tfourcaudot
 */
public abstract class AbstractBloomFilter implements IBloomFilter {

    protected int size;
    protected int k;
    protected HashFunction[] hashs;

    public AbstractBloomFilter(int size, int k) {
        this.size = size;
        this.k = k;
        hashs = new HashFunction[k];
        for (int i = 0; i < k; i++) {
            hashs[i] = new HashFunction(size);
        }
    }

}
