package ExeWithRegex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceAllMethod {
    public static void main(String[] args) {
        String regex = "\\((\\d):(\\d)\\)";
        Pattern pattern = Pattern.compile(regex);
        String text = "text 1 (but) (2) (1:2) call f() (3:4) (8:9)(10:11)";
        Matcher matcher = pattern.matcher(text);

        String newTxt = matcher.replaceAll("[$2:$1]");

        System.out.println("Text before change: ");
        System.out.println(text);
        System.out.println("Text after change: ");
        System.out.println(newTxt);
    }
}
