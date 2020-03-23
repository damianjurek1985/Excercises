//Nie posiada stanu
// Operacja nie może posiadać stanu.
// Przykładem operacji, która taki stan posiada jest metoda modify:
package StreamExe;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StatefullOperation {

    private final Set<Integer> seen = new HashSet<>();

    private int modify(int number) {
        if (seen.contains(number)) {
            return number;
        }
        seen.add(number);
        return 0;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Stream<Integer> numbers = Stream.of(1, 2, 3, 1, 2, 3, 1, 2, 3);
            StatefullOperation requriements = new StatefullOperation();
            int sum = numbers.parallel()
                    .map(requriements::modify)
                    .mapToInt(n -> n.intValue()).sum();
            System.out.println(sum);
        }
        //leniwość strumieni (przetwarzanie elementów po metodzie kończącej strumien np.
        // forech,count,allMatch,collect
        IntStream numbersStream = IntStream.range(0, 8);
        System.out.println("Przed");
        numbersStream = numbersStream.filter(n -> n % 2 == 0);
        System.out.println("W trakcie 1");
        numbersStream = numbersStream.map(n -> {
            System.out.println("> " + n);
            return n;
        });
        System.out.println("W trakcie 2");
        numbersStream = numbersStream.limit(4);
        System.out.println("W trakcie 3");
        numbersStream.forEach(System.out::println);
        System.out.println("Po");

    }

}