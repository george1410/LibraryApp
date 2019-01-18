import java.util.*;

public class InputGrabber {
    static Scanner kb = new Scanner(System.in);

    public String grab() {
        return readInput();
    }

    public String grab(String prompt) {
        System.out.print(prompt);
        return readInput();
    }

    private String readInput() {
        String input = "";
        input = kb.nextLine();
        return input;
    }
}