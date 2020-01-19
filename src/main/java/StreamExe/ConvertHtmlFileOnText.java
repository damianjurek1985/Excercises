package StreamExe;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertHtmlFileOnText {
    public static void main(String[] args) throws IOException {
        List<String> stringList = Files.lines(Paths.get("C:\\Projects\\Excercises\\src\\main\\resources\\TypyOp.html"))
                .filter(line -> line.contains("<h2>"))
                .map(line -> line.trim().replaceAll("<h2>", "")
                .replaceAll("</h2>", ""))
                .collect(Collectors.toList());
        System.out.println(stringList);


    }
}
