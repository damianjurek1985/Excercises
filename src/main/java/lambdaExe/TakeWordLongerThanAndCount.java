package lambdaExe;

import java.util.Arrays;
import java.util.List;

public class TakeWordLongerThanAndCount {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("Ala", "has", "black", "cat", "a", "name", "Bonifacy");

        long count = words.stream()
                .filter(s -> s.length() > 3)
                .peek(System.out::println)
                .count();

        System.out.println("Elements: " + count);
    }
}
