package colectionsExe;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapVsFlatMap {
    public static void main(String[] args) {

        Map<String, List<String>> peopleNamesAndPhone = new HashMap<>();
        peopleNamesAndPhone.put("KK", Arrays.asList("999-999-999", "888-888-888"));
        peopleNamesAndPhone.put("SK", Arrays.asList("777-777-777", "666-666-666"));
        peopleNamesAndPhone.put("PK", Arrays.asList("555-555-555", "444-444-444"));

        //use flat map  Stream to get all phone
        List<String> phoneList = peopleNamesAndPhone.values().stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        phoneList.forEach(System.out::println);


        //use of map to get all phones

        List<Stream<String>> phonesList = peopleNamesAndPhone.values().stream()
                .map(Collection::stream)
                .collect(Collectors.toList());

        for (Stream<String> phoneStream : phonesList) {
            List<String> phones = phoneStream.collect(Collectors.toList());
            System.out.println(phones);
        }
        //use of map to get all users names

            Set<String> namesList = peopleNamesAndPhone.keySet().stream()
                    .map(s->s)
                    .collect(Collectors.toSet());
            namesList.forEach(System.out::println);

        
    }


}
