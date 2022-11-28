/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainPackage;
import bloomfilter.*;

/**
 *
 * @author tfourcaudot
 */
public class main {

    public static void main(String[] args) {
        ArrayBloomFilter filter = new ArrayBloomFilter(1000, 100);
        filter.add(100);
        filter.add(500);
        filter.add(354);
        filter.add(-534);
        filter.add(365754);
        System.out.println(filter.contains(100));
        System.out.println(filter.contains(654654));
        System.out.println(filter.contains(453));
        System.out.println(filter.contains(45342));
        System.out.println(filter.contains(653));
        System.out.println(filter.contains(23));
        System.out.println(filter.contains(745));
        System.out.println(filter.contains(5786));
        System.out.println(filter.contains(654654));
        System.out.println(filter.contains(23472375));
        System.out.println(filter.contains(75752));
        System.out.println(filter.contains(5671242));
    }
}
