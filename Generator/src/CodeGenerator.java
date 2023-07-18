import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
// import java.sql.Statement;
import java.sql.PreparedStatement;
// import java.sql.ResultSet;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CodeGenerator {

    // This class creates unique passwords and adds them to a SQL DB


    // Method that creates password
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

    // Method that creates sql query to add password
    public static String insertSql(String site, String user, String pwd, String description) {
        String insert = "INSERT INTO dbo.unqpsw (website, username, password, description) VALUES ('" +
                        site + "','" + user + "','" + pwd + "','" + description + "');";
        return insert;
    }

    public static String insertSql(String site, String user, String pwd) {
        String insert = "INSERT INTO dbo.unqpsw (website, username, password) VALUES ('" +
                        site + "','" + user + "','" + pwd + "');";
        return insert;
    }


    public static void main(String[] args) {

        // Create and string new password
        CodeGenerator newGen = new CodeGenerator();
        ArrayList<String> generatedPW = newGen.genPassword("yes");
        String stringPW = String.join("", generatedPW);
        System.out.print("Your new password is: ");
        System.out.println(stringPW);

        Cped cped = new Cped();

        String website = "crazyurl.com";
        String username = "MyDefaultUser";

        // SQL statement to add values
        String insertStatement = insertSql(website, username, stringPW);
        
        // ResultSet resultSet = null;


        // Connect to SQL DB and add pwd to it
        try (Connection connection = DriverManager.getConnection(cped.url, cped.username, cped.password)) {
        PreparedStatement prepsInsertProduct = connection.prepareStatement(insertStatement);
        int rowsAffected = prepsInsertProduct.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Data inserted successfully");
            } else {
                System.out.println("Data insertion failed.");
            }

        connection.close();
        } catch (SQLException e) {
        e.printStackTrace();
        }


        // Create new_pwd.txt file and write to it
        try {
            File myFile = new File("new_pwd.txt");
            if (myFile.createNewFile()) {
                System.out.println("File created: " + myFile.getName());

                try {
                    FileWriter myWriter = new FileWriter("new_pwd.txt");
                    myWriter.write("Your new information for " + website + " is: \n");
                    myWriter.write("username: " + username + "\n");
                    myWriter.write("password: " + stringPW);
                    myWriter.close();
                    System.out.println("Succesfully wrote to file");
                } catch (IOException e) {
                    System.out.println("An error occured");
                    e.printStackTrace();
                }
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }
}
