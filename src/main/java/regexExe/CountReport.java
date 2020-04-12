package regexExe;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountReport {

    private String report;

    private double sum(String what) {
        Scanner sc = new Scanner(report);
        String regex = "\\d\\." + what + ":";

        if (sc.findWithinHorizon(regex, 0) == null){
            throw new IllegalArgumentException("No required category");
        }
        double sum = 0;
        do {
            while (sc.hasNextDouble()) {
                sum += sc.nextDouble();
            }
        } while (sc.findWithinHorizon(regex, 0) != null);
        return sum;
    }

    private CountReport(String fname)throws FileNotFoundException{
        Scanner fs = new Scanner( new File(fname));
        report = fs.useDelimiter("\\Z").next();
        fs.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        CountReport rep = new CountReport("C:\\Projects\\Excercises\\src\\main\\resources\\earnings");

        double earnings = rep.sum("earnings"),
               expenses = rep.sum("expenses");

        System.out.println("Earnings: " + earnings + "\nExpenses: " + expenses);
    }
}
