package regexExe;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matcher1 {
    public static void main(String[] args) {
        String regex = "[0-9]+";
        String txt = "123 456";

        System.out.println("Text: \n" + "'" + txt + "'" + "\nTemplate: " + "'" + regex + "'");

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher= pattern.matcher(txt);

        String result = "";

        while ( matcher.find()){
            result += "\n The substring matched '" + matcher.group() + "'" +
                    "\n from position " + matcher.start() +
                    "\n to position " + matcher.end();
        }
        if(result.equals("")) result = "No find any substring " + "\n macher to template";

        System.out.println(result);
    }
}
