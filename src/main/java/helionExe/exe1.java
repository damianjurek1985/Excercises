package helionExe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exe1 {
    public static void main(String[] args) throws IOException {
        double a, b, c, x;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = Double.parseDouble(br.readLine());
        if (a==0){
            System.out.println("Not allowed value");
        } else {
            b = Double.parseDouble(br.readLine());
            c = Double.parseDouble(br.readLine());

            x = (c-b)/a;
            System.out.print("Dla a = ");
            System.out.printf("%4.2f,", a);
            System.out.print(" b = ");
            System.out.printf("%4.2f", b);
            System.out.print(" c = ");
            System.out.printf("%4.2f", c);
            System.out.print(" wartość x = ");
            System.out.printf("%4.2f.\n", x);
        }
    }
}
