package colectionsExe;

import java.util.LinkedList;

public class LinkedListExe {

    public static void main(String[] args) {

        java.util.List<String> list = new LinkedList<>();
        list.add("dup1");
        list.add("dup2");
        list.add("dup3");

        System.out.println(list.size());
        for(String li : list){
            System.out.println(li);
        }

        list.add("dupa3");

        System.out.println(list.size());
    }
}
