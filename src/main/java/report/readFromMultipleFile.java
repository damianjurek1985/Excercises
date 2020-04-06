package report;

import java.io.*;
import java.lang.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class readFromMultipleFile {
    public static void main(String[] args) {
        File directory = new File("src/main/resources/html");
        File[] list =  directory.listFiles();
        assert list != null;
//        printNames(list);
        try {
            printContents(list);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //print file from folder
    private static void printNames(File[] list) {
        System.out.println("Files: ");
        for (File file : list) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }
    }

    //print print file contents from all text files
    public static void printContents(File[] list) throws IOException {
        for (File file : list) {
            String fileName = file.getPath();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            System.out.println("File: " + fileName);
            //getting file contents
            String line = null;

            File file1 = new File("GlobalReport.txt");
            FileWriter fileWriter = new FileWriter(file1, true);
            PrintWriter pw = new PrintWriter(fileWriter);
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                pw.println(line);

            }
            System.out.println("===========================================");
            pw.close();
        }
    }
}
