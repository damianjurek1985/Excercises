package report;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class SortData {
    public static void main(String[] args) throws IOException {

        System.out.println(searchString().size());




    }


    public static void countLineInReport() throws IOException {
        String line;
        int count= 0;
        String problem = "";

        try (BufferedReader br = new BufferedReader(new FileReader("GlobalReport.txt"))) {
            while ((line = br.readLine()) != null) {
                count++;
            }
        }
        System.out.println(count);
//        System.out.println(problem);
    }

    public static void countText() throws IOException {
        FileReader r = new FileReader("GlobalReport.txt");
        BufferedReader bfr = new BufferedReader(r);
        String Y = "";
        int count= 0;
        Matcher m;
        while ((Y=bfr.readLine())!=null)
        {
            String[] words = Y.split(" ");
            Pattern p = Pattern.compile("(?<=[1-9]\\))(.*)(?=https)");
            for (String word : words) {
                m = p.matcher(word);
                if(m.find())
                    count++;
            }
        }
        System.out.println(count);
    }

    public static int count(String pattern, String input) {
        return (input.split(pattern, -1).length-1);
    }

    public static List searchString() throws IOException{
        Scanner fileScanner = new Scanner(new File("GlobalReport.txt"));
        int lineID = 0;
        List lineNumbers = new ArrayList();
        Pattern pattern = Pattern.compile("(?<=[1-9]\\))(.*)(?=https)");
        Matcher matcher = null;
        while(fileScanner.hasNextLine()){
            String line = fileScanner.nextLine();
            lineID++;
            matcher = pattern.matcher(line);
            if(matcher.find()){
                lineNumbers.add(lineID);

            }


        }
        return lineNumbers;
    }




}
