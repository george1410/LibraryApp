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

        SearchResult searchResult = library.search(new SearchManager.TitleSearcher(), query);

        if (searchResult.hasResults()) {
            System.out.println(searchResult.getNumberOfResultsInWords() + " found:");
            for (LoanableItem item : searchResult) {
                System.out.println(item.toString());
            }
        } else {
            System.out.println("No results found.");
        }
    }
}