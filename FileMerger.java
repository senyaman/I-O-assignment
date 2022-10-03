package directories;

import java.io.*;
import java.util.Scanner;

public class FileMerger {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the path to the root directory:");
        String path = sc.nextLine().replace('\\', '/');

        System.out.println("Enter the name of the output file:");
        String outputFile = sc.nextLine();

        File dir = new File(path);
        File outputFileDir = new File(dir, outputFile);

        PrintWriter pw = null;

        try {
            pw = new PrintWriter(new FileWriter(outputFileDir));
        } catch (IOException e) {
            System.out.println(e);
        }

        String[] fileNames = dir.list();

        for (String fileName : fileNames) {
            File file = new File(dir, fileName);
            BufferedReader br = null;

            try {
                br = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException e) {
                System.out.println(e);
            }

            String readLine = null;

            try {
                readLine = br.readLine();
            } catch (IOException e) {
                System.out.println(e);
            }

            while (readLine != null) {
                pw.println(readLine);
                try {
                    readLine = br.readLine();
                } catch (IOException e) {
                    System.out.println(e);
                }
            }

            try {
                br.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        pw.close();
        pw.flush();
    }

}
