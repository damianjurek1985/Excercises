package StreamExe;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class exeStream {

    private static void printRange(){
        IntStream
                .range(1,10)
                .forEach(System.out::println);
    }

    private static void printRangeWithSkipValue(){
        IntStream
                .range(1,10)
                .skip(5)
                .forEach(x -> System.out.println(x));
    }

    private static void printRangeSum(){
        System.out.println(
        IntStream
                .range(1,5)
                .sum());
    }

    private static void printFirsthFromList(){

        Stream.of("Dora", "Wera", "Suza")
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);
    }

    private static void printFromArray(){

        String[] names = {"Al", "Anna", "Katia", "Suzana", "Ela", "Anita", "Ivana", "Irmina"};
        Arrays.stream(names)
                .filter(x -> x.startsWith("I"))
                .sorted()
                .forEach(System.out::println);
    }

    private static void printAvarageOfSquares(){
        Arrays.stream(new int[] {2, 4, 6, 8, 10})
                .map(x -> x * x)
                .average()
                .ifPresent(System.out::println);

    }

    private static void printFromList(){
        List<String> people = Arrays.asList("Al", "Anna", "Katia", "Suzana", "Ela", "Anita", "Ivana", "Irmina", "Hans", "Sabina", "Roran");
        people
                .stream()
                .map(String::toLowerCase)
                .filter(x -> x.startsWith("a"))
                .forEach(System.out::println);
    }

    private static void printFromFileWithLength() throws IOException {
        Stream<String> bands = Files.lines(Paths.get("/home/dzamal/Documents/inneProjekty/Excercises/src/main/resources/bands.txt"));
        bands
                .sorted()
                .filter(x -> x.length() > 13)
                .forEach(System.out::println);
        bands.close();
    }

    private static void printFromFileWithContains() throws IOException {
        List<String> bands2 = Files.lines(Paths.get("/home/dzamal/Documents/inneProjekty/Excercises/src/main/resources/bands.txt"))
                .filter(x -> x.contains("ee"))
                .collect(Collectors.toList());
        bands2.forEach(System.out::println);
    }

    private static void printFromFileRowsAndCount() throws IOException {
        Stream<String> rows = Files.lines(Paths.get("/home/dzamal/Documents/inneProjekty/Excercises/src/main/resources/data.txt"));
        int rowCount = (int)rows
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .count();
        System.out.println(rowCount + " rows. ");
        rows.close();
    }

    private static void printFromFileRowsAndPars() throws IOException {
        Stream<String> rows = Files.lines(Paths.get("/home/dzamal/Documents/inneProjekty/Excercises/src/main/resources/data.txt"));
        rows
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .filter(x -> Integer.parseInt(x[1]) > 15)
                .forEach(x -> System.out.println(x[0] + " " + x[1] + " " + x[2]));
        rows.close();
    }

    private static void printFromFileRowsAndStoreInHasMapp() throws IOException {
        Stream<String> rows = Files.lines(Paths.get("/home/dzamal/Documents/inneProjekty/Excercises/src/main/resources/data.txt"));
        Map<String, Integer> map;
        map = rows
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .filter(x -> Integer.parseInt(x[1]) > 13)
                .collect(Collectors.toMap(
                        x -> x[0],
                        x -> Integer.parseInt(x[1])));
        rows.close();
        for (String key : map.keySet()) System.out.println(key + " " + map.get(key));
    }

    private static void printReductionSum() {
        double total = Stream.of(7.3, 1.5, 4.8)
                .reduce(0.0, (Double a, Double b) -> a + b);
        System.out.println("Total = " + total);
    }

    private static void printReductionSumStat() {
        IntSummaryStatistics summary = IntStream.of(7, 2, 19, 88, 73, 4, 10)
                .summaryStatistics();
        System.out.println(summary);
    }

    public static void main(String[] args) throws IOException {
        printReductionSumStat();
    }
}
