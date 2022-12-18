/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloomfilter;

/**
 * Interface of all Bloom Filter version
 * @author tfourcaudot
 */
public interface IBloomFilter {

    /**
     * Add an element in the filter
     * @param element the element to add
     */
    public void add(int element);

    /**
     * Verify if an element is in the filter
     * @param element The element we looking for
     * @return True if the filter contain the element, False else
     */
    public boolean contains(int element);
}
