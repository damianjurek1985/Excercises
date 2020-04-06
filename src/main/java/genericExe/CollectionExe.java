package genericExe;

import java.util.ArrayList;
import java.util.List;

public class CollectionExe {

    public static int listSize(ArrayList<Integer> list){
        return list.size();
    }

    public static double countNumber(List<Integer> count) {
        int s = 0;

        for (int elem : count) {
            s += elem;
        }
        return s;
    }

    public static <T> void write(T object)  {
        System.out.println(object);
    }

    public static <T> void revers(List<T> list){
        for (int i = 0; i < list.size() / 2; i++){
            T o= list.get(i);

            list.set(i, list.get(list.size() - i -1));
            list.set(list.size() - i -1, o);
        }
    }

    public static void main(String[] args) {
//        write(5);
//        write("text");
//        write(new ArrayList<>());

        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        revers(list);
        write(list);
        List<Character> list1 = new ArrayList<>();
        list1.add('w');
        list1.add('s');
        list1.add('a');
        revers(list1);
        write(list1);
    }
}
