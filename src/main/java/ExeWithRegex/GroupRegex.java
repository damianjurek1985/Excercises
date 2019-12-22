package ExeWithRegex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroupRegex {
    public static void main(String[] args) {
        String regex = "([0-9]+)\\s+(\\p{L}+)\\s+([1-9][0-9]*)";
        String txt = "2222 vacumCleaner 20";

        System.out.println("Text: " + "'" + txt + "'" + "\nTemplete: " + "'" + regex + "'");

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(txt);

        boolean isMatching = matcher.matches();
        if (isMatching){
            int n = matcher.groupCount();
            for (int i = 1; i <= n; i++) {
                String group = matcher.group(i);
                System.out.println("Group " + i + " = '" + group + "'");
            }
        }else System.out.println("The text does not match the pattern");

    }
}
