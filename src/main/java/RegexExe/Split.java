package RegexExe;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Split {

    public static void main(String[] args) {
        String value = "      Element has insufficient color contrast of 1.93 (foreground color: #ffffff, background color: #2ed1b1, font size: 18.0pt, font weight: normal). Expected contrast ratio of 3:1";

//        System.out.println(value);
        //System.out.println(value.split("(?<=[1-9]\\))"));


        value = value.replaceAll("[a-z]\\) ", "").replaceAll(": https:.*", "");
        System.out.println(value);
    }

}
