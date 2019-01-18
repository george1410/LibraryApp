import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        String query = new InputGrabber().grab("Search Term: ");
        SearchResult searchResult = library.search(new SearchManager.TitleSearcher(), query);

        System.out.println(searchResult.getNumberOfResultsInWords() + " found:");
        if (searchResult.hasResults()) {
            System.out.println(searchResult.stringifyAll());
        }
    }
}