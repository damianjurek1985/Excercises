package lambdaExe;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortExe {
    public static void main(String[] args) {

        List<String> words = Arrays.asList("Ala", "has", "black", "cat", "a", "name", "Bonifacy");

        Collections.sort(words, (String o1, String o2) -> {return o2.compareTo(o1);}); // lambda

        //or Collections.sort(words, String::compareTo);
        System.out.println(words);

    }
}
