package colectionsExe;

import java.util.HashMap;
import java.util.Map;

public class test {

    private static HashMap<String, String> map = new HashMap<String, String>();
    private static int valueCount;

    public static void main(String[] args) {
        map.put("doge", "test");
        map.put("derp", "test");
        map.put("herp", "test1");
        map.put("hello", "bye");
        System.out.println(getValueOccurances(map));
    }

    public static  <T> Map<T, Integer> getValueOccurances(Map<?, T> original) {
        Map<T, Integer> back = new HashMap<>();
        for (T val : original.values()) {
            if (back.containsKey(val)) {
                back.put(val, back.get(val) + 1);
            } else {
                back.put(val, 1);
            }
        }
        return back;
    }
}
