package report;

import com.sun.istack.internal.NotNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommonAxeAssertion {

    private static String VIOLATION_PATTERN = "(?<=[1-99]\\))(.*)(?=https)";
    private static String SELECTORS_PATTERN = "([a-z]\\))(.*])";

    public void generateGlobalReport() {
        try (Stream<Path> walk = Files.walk(Paths.get(System.getProperty("user.dir") + "/target/surefire-reports/html/"))) {
            List<String> result = walk.map(Path::toString)
                                      .filter(f -> f.endsWith("__AXE__.txt"))
                                      .collect(Collectors.toList());
            for (String file : result) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                String line = null;
                File newReport = new File(System.getProperty("user.dir") + "/target/surefire-reports/html/" + "GlobalReport__AXE__.txt");
                FileWriter fileWriter = new FileWriter(newReport, true);
                PrintWriter pw = new PrintWriter(fileWriter);
                while ((line = bufferedReader.readLine()) != null) {
                    pw.println(line);
                }
                pw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, Long> getSelectedViolations(Pattern pattern, List<String> allLines) {
        return allLines.stream()
                       .filter(currentLine -> pattern.matcher(currentLine)
                                                     .find())
                       .map(CommonAxeAssertion::replace)
                       .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    @NotNull
    private static String replace(String line) {
        return line.replaceAll("[1-9]\\) ", "")
                   .replaceAll(": https:.*", "")
                   .replaceAll("[a-z]\\) ", "");
    }

    public void createGeneralReportForSpecificViolations() throws IOException {
        List<String> allLines = Files.readAllLines(new File(System.getProperty("user.dir") + "/target/surefire-reports/html/GlobalReport.txt").toPath(), Charset.defaultCharset());
        generateGlobalReport();
        getSelectedViolations(Pattern.compile(VIOLATION_PATTERN), allLines);
        getSelectedViolations(Pattern.compile(SELECTORS_PATTERN), allLines);
    }

    public static String convertEntryToOneLine(String violation, Long count) {
        return String.format("%s - %d", violation, count);
    }

    public static void writeViolationsToFile() throws IOException {
        File newReport = new File("GlobalReportsss.txt");
        FileWriter fileWriter = new FileWriter(newReport, false);
        PrintWriter pw = new PrintWriter(fileWriter);
        List<String> allLines = Files.readAllLines(new File("GlobalReport.txt").toPath(), Charset.defaultCharset());
        Map<String, Long> resultViolations = getSelectedViolations(Pattern.compile(VIOLATION_PATTERN), allLines);
        resultViolations.forEach( (key, val) -> {
            pw.println(convertEntryToOneLine(key, val));
            pw.println();
        });
        pw.close();
    }

    public static void main(String[] args) throws IOException {
        writeViolationsToFile();
    }
}
