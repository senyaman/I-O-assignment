package directories;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the path to the root directory:");
        String path = sc.nextLine();

        System.out.println("Enter the name of the output file:");
        String outputFile = sc.nextLine();

        FileMerger fileMerger = new FileMerger(path, outputFile);
        fileMerger.appendFiles();

    }

}
