package java4python;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.TreeMap;

public class Listing6 {
    public static void main(String[] args) {
        Scanner data = null;
        TreeMap<String, Integer> count = new TreeMap<String, Integer>();
        Integer idx = 0;
        String word;
        Integer wordCount;

        try {
            data = new Scanner(new File("alice30.txt"));
        }
        catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
            System.exit(0);
        }

        while (data.hasNext()) {
            word = data.next().toLowerCase().replaceAll("\\W", "");
            wordCount = count.get(word);
            if (wordCount == null) {
                wordCount = 0;
            }
            count.put(word, ++wordCount);
        }

        for (String i: count.keySet()) {
            System.out.printf("%-20s occured %5d times\n", i, count.get(i));
        }
    }
}
