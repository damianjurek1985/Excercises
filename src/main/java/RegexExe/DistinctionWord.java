package RegexExe;

import java.util.regex.Pattern;

public class DistinctionWord {
    public static void main(String[] args) {
        String regex = "[\\s\\p{Punct}]+";
        String txt = "Ela(11), cat,; dog-1 <cat2>[ant]";

        Pattern pattern = Pattern.compile(regex);
        String[] words = pattern.split(txt);

        System.out.println("Number of separate words: " + words.length);

        for (String w : words){
            System.out.println(w);
        }
    }
}
