import java.util.*;

public class SearchManager {
    public interface Searcher {
        public LinkedList<LoanableItem> execute(String query, ItemContainer items);
    }

    public static class TitleSearcher implements Searcher {
        public LinkedList<LoanableItem> execute(String query, ItemContainer items) {
            LinkedList<LoanableItem> results = new LinkedList<>();
            for (LoanableItem item : items) {
                if (item.titleContains(query)) {
                    results.add(item);
                }
            }
            return results;
        }
    }
}