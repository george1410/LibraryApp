import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        /* search for a title */
        System.out.print("Search Term: ");
        Scanner kb = new Scanner(System.in);
        String query = kb.nextLine();
        kb.close();

        LinkedList<LoanableItem> results = library.search(new SearchManager.TitleSearcher(), query);

        if (results.size() > 0) {
            String term = results.size() > 1 ? "results" : "result";
            System.out.println(results.size() + " " + term + " found: ");
            for (LoanableItem item : results) {
                System.out.println(item.simpleString());
            }
        } else {
            System.out.println("No results found.");
        }
    }
}