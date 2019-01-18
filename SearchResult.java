import java.util.*;

public class SearchResult extends LinkedList<LoanableItem> {
    public boolean hasResults() {
        return !this.isEmpty();
    }

    public String getNumberOfResultsInWords() {
        if (this.size() == 0) {
            return "No results";
        } else if (this.size() == 1) {
            return "1 result";
        } else {
            return this.size() + " results";
        }
    }

    public String stringifyAll() {
        String output = "";
        for (LoanableItem item : this) {
            output += item.toString() + "\n";
        }
        return output;
    }
}