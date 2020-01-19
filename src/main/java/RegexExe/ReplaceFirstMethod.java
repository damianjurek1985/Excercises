package RegexExe;


import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceFirstMethod {
    public static void main(String[] args) throws IOException {
    Path in =  Paths.get("C:\\Projects\\Excercises\\src\\main\\resources\\text.txt");
    Path out = Paths.get("C:\\Projects\\Excercises\\src\\main\\resources\\text2.txt");

        String regex = "\\s*//.*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher("");

        ArrayList<String> newLines = new ArrayList<>();

        Charset cs = Charset.defaultCharset();
        for(String line : Files.readAllLines(in, cs)){
            matcher.reset(line);
            String nline = matcher.replaceFirst("");
            newLines.add(nline);
        }
        Files.write(out, newLines, cs);
   }
}
