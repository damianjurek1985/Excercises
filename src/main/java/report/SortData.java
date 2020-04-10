package report;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SortData {

    private static String violationPattern = "(?<=[1-99]\\))(.*)(?=https)";
    private static String selectorsPattern = "([a-z]\\))(.*])";
    private static String foregroundColorPattern =  "#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3}), background";//"(?:#|0x)(?:[a-f0-9]{3}|[a-f0-9]{6})\\b|(?:rgb|hsl)a?\\([^\\)]*\\)"; //"foreground color: #([0-9a-f]{3,6}), background color";
    private static String backgroundColorPattern = "foreground color: .*, background";

    public static void main(String[] args) throws IOException {


        //System.out.println(getOnlyViolations());
        //getOnlyViolations().values().iterator().forEachRemaining(System.out::println);


//        Map<String, Integer> result = new TreeMap<>();
//        for (Map.Entry<Integer, String> entry:getOnlyViolations().entrySet()) {
//            String value = entry.getValue();
//            Integer count = result.get(value);
//            if (count == null)
//                result.put(value, new Integer(1));
//            else
//                result.put(value, new Integer(count+1));
//        }


        System.out.println(getValueOccurances(getOnlyViolations(foregroundColorPattern)));



//        public static void countFrequencies(ArrayList<String> list)
//        {
//            // hashmap to store the frequency of element
//            Map<String, Integer> hm = new HashMap<String, Integer>();
//
//            for (String i : list) {
//                Integer j = hm.get(i);
//                hm.put(i, (j == null) ? 1 : j + 1);
//            }
//
//            // displaying the occurrence of elements in the arraylist
//            for (Map.Entry<String, Integer> val : hm.entrySet()) {
//                System.out.println("Element " + val.getKey() + " "
//                        + "occurs"
//                        + ": " + val.getValue() + " times");
//            }
//        }
    }



    public static  <T> Map<T, Integer> getValueOccurances(Map<?, T> original) {
        Map<T, Integer> back = new HashMap<>();
        for (T val : original.values()) {
            if (back.containsKey(val)) {
                back.put(val, back.get(val) + 1);
            } else {
                back.put(val, 1);
            }
        }
        return back;
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

    public static List<Integer> countViolations() throws IOException{
        Scanner fileScanner = new Scanner(new File("GlobalReport.txt"));
        int lineID = 0;
        List<Integer> lineNumbers = new ArrayList<Integer>();
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

    public static HashMap<Integer, String> getOnlyViolations(String patterns) throws IOException{
        Scanner fileScanner = new Scanner(new File("GlobalReport.txt"));
        int lineID = 0;
        HashMap<Integer, String> lineValue = new HashMap<>();
        Pattern pattern = Pattern.compile(patterns);
        Matcher matcher = null;
        while(fileScanner.hasNextLine()){
            String line = fileScanner.nextLine();
            lineID++;
            matcher = pattern.matcher(line);
            if(matcher.find()){
                lineValue.put(lineID, line)
                        .replaceAll("[1-9]\\) ", "")
                        .replaceAll(": https:.*", "")
                        .replaceAll("[a-z]\\) ", "");
           }
        }
        return lineValue;
    }

    public static ArrayList<String> getOnlyViolationsArray() throws IOException{
        Scanner fileScanner = new Scanner(new File("GlobalReport.txt"));
        int lineID = 0;
        ArrayList<String> lineValue = new ArrayList<String>();
        Pattern pattern = Pattern.compile("(?<=[1-9]\\))(.*)(?=https)");
        Matcher matcher = null;
        while(fileScanner.hasNextLine()){
            String line = fileScanner.nextLine();
            lineID++;
            matcher = pattern.matcher(line);
            if(matcher.find()){
                 lineValue.add(line.replaceAll("[1-9]\\) ", "").replaceAll(": https:.*", ""));
            }
        }
        return lineValue;
    }

    public static  List test1() throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File("GlobalReport.txt"));
        int lineID = 0;
        List<String> allMatches = new ArrayList<String>();
        Matcher m = Pattern.compile("foreground color: #([0-9a-f]{3,6})")
                .matcher("GlobalReport.txt");


        while(fileScanner.hasNextLine()){
            String line = fileScanner.nextLine();
            lineID++;

            while (m.find()) {
                allMatches.add(m.group(1));
            }
        }
        return allMatches;
        //===


    }
}
