import java.util.*;

public class InputGrabber {
    static Scanner kb = new Scanner(System.in);

    public String grab() {
        String input = "";
        input = kb.nextLine();
        return input;
    }

    public String grab(String prompt) {
        String input = "";
        System.out.print(prompt);
        input = kb.nextLine();
        return input;
    }
}