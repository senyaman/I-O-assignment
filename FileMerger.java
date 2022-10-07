package directories;

import java.io.*;

public class FileMerger {

    private String rootPath;
    private String outputFile;

    public FileMerger(String rootPath, String fileName) {
        this.rootPath = rootPath;
        this.outputFile = fileName;
    }

    public void appendFiles() {

        File dir = new File(rootPath);
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
