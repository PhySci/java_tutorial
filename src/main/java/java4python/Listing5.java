package java4python;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Listing5 {
    public static void main(String[] args) {
        Scanner data = null;
        Integer[] count = {0,0,0,0,0,0,0,0,0,0,0};
        Integer val;
        Integer pos;

        try {
            data = new Scanner(new File("test.dat"));

        }
        catch (IOException e) {
            System.out.println("Unable to open data file");
            e.printStackTrace();
            System.exit(0);
        }

        while (data.hasNextInt()) {
            val = data.nextInt();
            count[val] = count[val] + 1;
        }

        pos = 0;
        for (Integer i: count) {
            System.out.println(pos + " occured " + i + " times.");
            pos += 1;
        }

    }
}
