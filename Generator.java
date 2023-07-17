import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;


public class Generator {

    public char genPassword(String special) {
        List<Character> noSpecials = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z','0','1','2','3','4','5','6','7','8','9'));
        // List<Character> withSpecials = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z','0','1','2','3','4','5','6','7','8','9','?','!','-','*'));

        Random rand = new Random();
        char randomItem = noSpecials.get(rand.nextInt(noSpecials.size()));

        return randomItem;
    
    }
    public static void main(String[] args) {
        Generator newGen = new Generator();
        System.out.println(newGen.genPassword("Yes"));
    }
}