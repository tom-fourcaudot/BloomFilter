/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainPackage;

import Benchmark.Benchmark;
import Benchmark.CSV;
import java.util.Random;

/**
 *
 * @author tfourcaudot
 */
public class main {

    public static void main(String[] args) {
        final int N = 10000;
        final String CSVFileError = "error.csv";
        final String CSVFileTime = "time.csv";
        final int[] KTest = {1, 3, 5};
        final int[] SizeTest = {N, N * 10, N * 100};

        // reset / create CSV files
        CSV.deleteFile(CSVFileError);
        CSV.createCSV(CSVFileError);
        CSV.deleteFile(CSVFileTime);
        CSV.createCSV(CSVFileTime);
        // add Header to csv
        CSV.appendLine(CSVFileError, "M,K,N,error");
        CSV.appendLine(CSVFileTime, "type,M,K,N,time");

        // Test the time of each
        Random r = new Random();
        for (int k : KTest) {
            for (int s : SizeTest) {
                int seed = r.nextInt();
                Benchmark b = new Benchmark(s, k, N, seed);
                b.BenchAdd();
                long[] res = b.BenchContains();
                for (int i = 0; i < 3; i++) {
                    CSV.appendLine(CSVFileTime, i+","+ s + "," + k + "," + N + "," + res[i]);
                }
            }
        }

        for (int k : KTest) {
            for (int s : SizeTest) {
                int seed = r.nextInt();
                Benchmark b = new Benchmark(s, k, N, seed);
                CSV.appendLine(CSVFileError, "" + s + "," + k + "," + N + "," + b.benchError());
            }
        }
    }
}
