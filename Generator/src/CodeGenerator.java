import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CodeGenerator {

    public ArrayList<String> genPassword(String special) {
        
        Random rand = new Random();
        List<String> upper = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"));
        List<String> lower = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"));
        List<String> numbers = new ArrayList<>(Arrays.asList("0","1","2","3","4","5","6","7","8","9"));
        List<String> specials = new ArrayList<>(Arrays.asList("!", "-", "?", "*"));
        ArrayList<String> newPassword = new ArrayList<String>();

        for (int i = 1; i < 13; i ++) {
            if (i % 5 == 0) {
                String randomUpper = upper.get(rand.nextInt(upper.size()));
                newPassword.add(randomUpper);
                continue;
            } else if (i % 6 == 0) {
                String randomNumber = numbers.get(rand.nextInt(numbers.size()));
                newPassword.add(randomNumber);
                continue;
            } else if (i % 7 == 0 && special.equals("yes")) {
                String randomSpecial = specials.get(rand.nextInt(specials.size()));
                newPassword.add(randomSpecial);
                continue;
            }

            String randomItem = lower.get(rand.nextInt(lower.size()));
            newPassword.add(randomItem);

        }

        return newPassword;
    
    }

    public static void main(String[] args) {
        CodeGenerator newGen = new CodeGenerator();
        ArrayList<String> generatedPW = newGen.genPassword("yes");

        Cped cped = new Cped();

        System.out.println(cped.url);
        System.out.println(cped.username);
        System.out.println(cped.password);
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(cped.url, cped.username, cped.password);
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        System.out.println(generatedPW);

        String listString = String.join("", generatedPW);
        System.out.println(listString);
    }
}
