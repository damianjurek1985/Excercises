package interview;

import java.util.*;

public class CompareList {


    public static void main(String[] args) {
        compareByCollection();
    }

    public static List<String> one = new ArrayList<>(Arrays.asList("milan", "dingo", "elpha", "hafil", "meat", "iga", "neeta.peeta"));
    public static List<String> two = new ArrayList<>(Arrays.asList("hafil", "iga", "binga", "mike", "dingo"));


    public static void compareByCollection(){
        Collection<String> similar = new HashSet<>( one );
        Collection<String> different = new HashSet<>();
        different.addAll( one );
        different.addAll( two );

        similar.retainAll( two );
        different.removeAll( similar );
        System.out.printf("One:%s%nTwo:%s%nSimilar:%s%nDifferent:%s%n", one, two, similar, different);

        two.removeIf(one::contains);
        //return initial - two.size();
    }
}
