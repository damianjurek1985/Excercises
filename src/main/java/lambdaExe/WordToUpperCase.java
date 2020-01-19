package lambdaExe;

import java.util.Arrays;
import java.util.List;

public class WordToUpperCase {


    public static void main(String[] args) {
        List<String> words = Arrays.asList("Ala", "has", "black", "cat", "a", "name", "Bonifacy");

        words.stream()
                .map(String::toUpperCase)
                .filter(s -> s.length() > 3)
                .forEach(System.out::println);
    }
}
