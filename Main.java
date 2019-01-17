import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        LinkedList<LoanableItem> items = new LinkedList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("books.csv"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] split = line.split(",");
                if (split.length > 1) {
                    String author = split[0];
                    String title = split[1];
                    items.add(new Book(title, author, 30, ((int) Math.random() * 1500) + 1));
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error reading the book data!");
        }
    }
}