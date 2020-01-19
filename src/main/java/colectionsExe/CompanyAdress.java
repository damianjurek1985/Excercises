package colectionsExe;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

import static javax.swing.JOptionPane.showMessageDialog;

public class CompanyAdress {

    public static void main(String[] args) throws FileNotFoundException {

        HashMap<String, String> map = new HashMap<>();

        Scanner scan = new Scanner(new File(("C:\\Projects\\Excercises\\src\\main\\resources\\CompanyAdress.txt")));
        String companyName;
        String companyAdress;
        while (scan.hasNextLine()){
            companyName = scan.nextLine();
            companyAdress = scan.nextLine();
            map.put(companyName, companyAdress);
        }
        while ((companyName = JOptionPane.showInputDialog("company Name")) != null){
            companyAdress = map.get(companyName);
            if(companyAdress == null) companyAdress = "No such company";
            showMessageDialog(null, "Company: " + companyName + '\n' + "Adress: " + companyAdress);
        }
    }
}
