/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloomfilter;

/**
 *
 * @author tfourcaudot
 */
public interface IBloomFilter {

    public void add(int element);

    public boolean contains(int element);

}
