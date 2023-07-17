import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;


public class Generator {

    public ArrayList<Character> genPassword(String special) {
        
        Random rand = new Random();
        List<Character> noSpecials = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z','0','1','2','3','4','5','6','7','8','9'));
        // List<Character> upper = new ArrayList<>(Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'));
        // List<Character> lower = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));
        List<Character> numbers = new ArrayList<>(Arrays.asList('0','1','2','3','4','5','6','7','8','9'));
        // List<Character> specials = new ArrayList<>(Arrays.asList('!', '-', '?', '*'));
        ArrayList<Character> newPassword = new ArrayList<Character>();

        for (int i = 0; i <5; i ++) {
            if (i == 2) {
                char randomNumber = numbers.get(rand.nextInt(numbers.size()));
                newPassword.add(randomNumber);
                continue;
            }

            char randomItem = noSpecials.get(rand.nextInt(noSpecials.size()));
            newPassword.add(randomItem);

        }

        

        return newPassword;
    
    }
    public static void main(String[] args) {
        Generator newGen = new Generator();
        System.out.println(newGen.genPassword("Yes"));
    }
}