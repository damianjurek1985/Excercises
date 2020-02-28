package interview;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CompareList {


    public static void main(String[] args) {
        findTheMostRepeatString();
    }

    public static List<String> one = new ArrayList<>(Arrays.asList("milan", "dingo", "elpha", "hafil", "meat", "iga", "neeta.peeta"));
    public static List<String> two = new ArrayList<>(Arrays.asList("hafil", "iga", "binga", "mike", "dingo"));

    public static List<String> tree = new ArrayList<>(Arrays.asList("hafil", "iga", "binga", "mike", "dingo", "hafil","hafil","binga", "binga", "binga", "mike"));

    public static void findTheMostRepeatString(){
        Map<String, Long> countElementByName = tree.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        String maxRepeatValue = Collections.max(countElementByName.entrySet(), Comparator.comparingLong(Map.Entry::getValue)).getKey();
        System.out.println(maxRepeatValue);
        System.out.println(countElementByName);

        System.out.println( tree.stream()
                .collect(Collectors.toMap(Function.identity(), e -> 1, Math::addExact)));

        Map<String, Integer> accumulator = new HashMap<>();
        tree.forEach(s -> accumulator.merge(s, 1, Math::addExact));

        System.out.println(accumulator);
    }

    public static void compareByCollection(){
        Collection<String> similar = new HashSet<>( one );
        Collection<String> different = new HashSet<>();
        different.addAll( one );
        different.addAll( two );

        similar.retainAll( two );
        different.removeAll( similar );
        System.out.printf("One:%s%nTwo:%s%nSimilar:%s%nDifferent:%s%n", one, two, similar, different);

        //two.removeIf(one::contains);
        //return initial - two.size();
    }
}
