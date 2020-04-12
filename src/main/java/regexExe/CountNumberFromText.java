package regexExe;

import java.util.Scanner;

public class CountNumberFromText {
    public static void main(String[] args) {
        String txt = "Lorem Ipsum is simply dummy text of the 15 printing and typesetting industry.\n" +
                " Lorem Ipsum has been the industry's standard 20 dummy text ever since the 1500, when\n" +
                " an unknown printer took a galley of type and 10 scrambled it to make a type specimen book.";
        String delim = "[^0-9]+";

        Scanner scan = new Scanner(txt).useDelimiter(delim);
        int sum = 0;
        while (scan.hasNextInt()){
            sum += scan.nextInt();
        }
        System.out.println("Text:\n" + txt + "\n\nCount number: " + sum);
    }
}
