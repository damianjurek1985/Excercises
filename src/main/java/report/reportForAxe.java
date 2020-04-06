package report;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class reportForAxe {

    public static void main (String args []) throws IOException {
        Scanner stdin = new Scanner (System.in);
        System.out.print ("File name to read from : ");
        String inputFileName = stdin.next();
        Scanner sf = new Scanner(new File (inputFileName));
        String outputFileName = inputFileName + "_AXE.txt";
        System.out.println ("Opening for writing: " + outputFileName);
        FileWriter fw = new FileWriter (outputFileName);
        BufferedWriter bw = new BufferedWriter (fw);
        PrintWriter pw = new PrintWriter (bw);
        String line;
        int count = 0;

// My code goes here that modifies each line of the text file and resaves it to the new file....

        pw.close(); // finish and close the output text file

    } // end main
}

