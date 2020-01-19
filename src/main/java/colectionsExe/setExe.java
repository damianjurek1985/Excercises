package colectionsExe;

import java.util.HashSet;
import java.util.Set;

public class setExe {
    public static void main(String[] args) {

        Set<String> stringSet = new HashSet<>();
        stringSet.add("dupa1");
        stringSet.add("dupa2");
        System.out.println(stringSet.size());
        System.out.println(stringSet.contains("dupa2"));

        for (String li : stringSet){
            System.out.println(li);
        }

        System.out.println(stringSet.hashCode());

        stringSet.add("dupa2");
        System.out.println(stringSet.size());
        for (String lis : stringSet){
            System.out.println(lis);
        }

    }
}
