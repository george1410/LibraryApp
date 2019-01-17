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
                String[] split = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                if (split.length > 1) {
                    String author = split[0].replace("\"", "");
                    String title = split[1].replace("\"", "");
                    items.add(new Book(title, author, 30, ((int) Math.random() * 1500) + 1));
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error reading the book data!");
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader("dvds.csv"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] split = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                if (split.length > 2) {
                    String title = split[0].replace("\"", "");
                    String director = split[1].replace("\"", "");
                    int runtime = Integer.parseInt(split[2].replace("\"", ""));
                    items.add(new DVD(title, director, 20, runtime));
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error reading the DVD data!");
        }

        System.out.println(items.size() + " items loaded successfully.");

        /* search for a title */
        LinkedList<LoanableItem> results = searchByTitle("Harry Potter", items);
        System.out.println(results.size() + " results found: ");
        for (LoanableItem item : results) {
            System.out.println(item.simpleString());
        }

    }

    private static LinkedList<LoanableItem> searchByTitle(String query, LinkedList<LoanableItem> items) {
        System.out.println("\nSearching for \"" + query + "\"...");
        LinkedList<LoanableItem> results = new LinkedList<>();
        for (LoanableItem item : items) {
            if (item.getTitle().toLowerCase().contains(query.toLowerCase())) {
                results.push(item);
            }
        }
        return results;
    }
}