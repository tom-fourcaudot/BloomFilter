 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Benchmark;
import bloomfilter.ArrayBloomFilter;
import bloomfilter.ArrayListBloomFilter;
import bloomfilter.IBloomFilter;
import bloomfilter.LinkListBloomFilter;
import java.util.HashSet;
import java.util.Random;

/**
 *
 * @author tfourcaudot
 */
public class Benchmark {
    HashSet<Integer> subjects;
    IBloomFilter ArrayFilter;
    IBloomFilter AListFilter;
    IBloomFilter LinkekFilter;
    int n;
            
    public Benchmark(int size, int k, int n, int seed) {
        ArrayFilter = new ArrayBloomFilter(size, k, seed);
        AListFilter = new ArrayListBloomFilter(size, k, seed);
        LinkekFilter = new LinkListBloomFilter(size, k, seed);
        this.n = n;
        Random r = new Random();
        subjects = new HashSet<>();
        for (int i = 0; i < n; i++){
            subjects.add(r.nextInt(size*100));
        }
        // Adding header to CSV
        System.out.println("START BENCHMARK");
    }
    
    public void BenchAdd() {
        System.out.println("--- Adding elements for test ---");
        for (int elem : subjects){
            ArrayFilter.add(elem);
        }
        System.out.println("Array BloomFilter done");
        for (int elem : subjects){
            AListFilter.add(elem);
        }
        System.out.println("ArrayList BloomFilter done");
        for (int elem : subjects){
            LinkekFilter.add(elem);
        }
        System.out.println("LinkedList BloomFilter done");
        
        System.out.println("--- Elements added ---");
    }
    
    public long[] BenchContains() {
        System.out.println("--- Contains ---");
        long[] res = new long[3];
        long stop;
        long start;
        // test Array
        long tmp = 0;
        for (int elem : subjects){
            start = System.nanoTime();
            ArrayFilter.contains(elem);
            stop = System.nanoTime();
            tmp += stop - start;
        }
        res[0] = tmp / n;
        System.out.println("Array : "+res[0]);
        // test ArrayList
        tmp = 0;
        for (int elem : subjects){
            start = System.nanoTime();
            AListFilter.contains(elem);
            stop = System.nanoTime();
            tmp += stop - start;
        }
        res[1] = tmp / n;
        System.out.println("ArrayList : "+res[1]);
        // test LinkedList
        tmp = 0;
        for (int elem : subjects){
            start = System.nanoTime();
            LinkekFilter.contains(elem);
            stop = System.nanoTime();
            tmp += stop - start;
        }
        res[2] = tmp / n;
        System.out.println("LinkedList : "+res[2]);
        return res;
    }
    
    public double benchError() {
        for (int elem : subjects){
            ArrayFilter.add(elem);
        }
        int error = 0;
        int nb_test = 0;
        int elem = -1000000;
        while (elem < 1000000) {
            if (!subjects.contains(elem)){
                if (ArrayFilter.contains(elem)) {
                    error++;
                }
                nb_test++;
            }
            elem++;
        }
        System.out.println(nb_test);
        System.out.println(error);
        return ((1.0*error)/nb_test)*100;
    }
}
    
