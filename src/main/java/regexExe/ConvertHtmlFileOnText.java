package regexExe;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ConvertHtmlFileOnText {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner fscan = new Scanner(new File("C:\\Projects\\Excercises\\src\\main\\resources\\TypyOp.html"));
        String h2regex = "(?s)(?i)<h2>(.+?)</h2>";
        while (fscan.findWithinHorizon(h2regex, 0) != null){
            String title = fscan.match().group(1);
            System.out.println(title);
        }
        fscan.close();
    }
}
