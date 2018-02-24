import java.util.*;

public class UserInput {
    
    private static String press;

    public static String takeInput() {
        boolean counter = true;
        while (counter == true){
            System.out.print("Enter your move: ");
            Scanner pressed = new Scanner(System.in);
            press = pressed.nextLine();
            if (Arrays.asList("w","a","s","d").contains(press)) {
                counter = false;
            }
            else {
                System.out.println("Invalid input, please try again.");
            }
        }
        return press;
    }
    
    public static String getPress(){
        return press;
    }
    
}
