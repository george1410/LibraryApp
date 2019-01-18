import java.util.*;

public class SearchManager {
    public interface Searcher {
        public SearchResult execute(String query, ItemContainer items);
    }

    public static class TitleSearcher implements Searcher {
        public SearchResult execute(String query, ItemContainer items) {
            SearchResult results = new SearchResult();
            for (LoanableItem item : items) {
                if (item.titleContains(query)) {
                    results.add(item);
                }
            }
            return results;
        }
    }
}