package RegexExe;

import java.util.Arrays;
import java.util.Scanner;

public class AnaliseText {
    public static void main(String[] args) {
        String txt = "1/2 /3/ 4";
        String delim = "[ /]";

        Scanner scan = new Scanner(txt).useDelimiter(delim);
        System.out.print("Text : " + quote(txt) + "Separate: " + quote(delim));

        while (scan.hasNext())
            System.out.print(quote(scan.next()) + " ");

        delim = "[ /]+";

        scan = new Scanner(txt).useDelimiter(delim);
        System.out.print("\nText : " + quote(txt) + " Separate: " + quote(delim));

        while (scan.hasNext())
            System.out.print(quote(scan.next()) + " ");

        txt = " 1/2 /3/ 4";
        scan = new Scanner(txt).useDelimiter(delim);
        System.out.print("\nText : " + quote(txt) + " Separate: " + quote(delim));

        while (scan.hasNext())
            System.out.print(quote(scan.next()) + " ");
        System.out.print("\nAnd split make:\n" + Arrays.toString(txt.split(delim)));
    }

    public static String quote(String s){
        return "'" + s + "'" + " ";
    }
}
