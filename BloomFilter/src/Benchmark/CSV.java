/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Benchmark;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
/**
 *
 * @author Pompom
 */
public class CSV {
    
    public static void createCSV(String fileName) {
        try {
            File f = new File(fileName);
            if (f.createNewFile()) {
                System.out.println("File created: " + f.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    public static void deleteFile(String fileName) {
        File f = new File(fileName);
        if (f.delete()) {
            System.out.println("Deleted the file: " + fileName);
        } else {
            System.out.println("Failed to delete the "+fileName);
        }
    }

    public static void appendLine(String fileName, String content) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(fileName, true));
            writer.println(content);
            writer.close();
            System.out.println("line append in "+fileName);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
