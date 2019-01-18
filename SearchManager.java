import java.util.*;

public class SearchManager {
    public static final int ALL = 0;
    public static final int BOOK = 1;
    public static final int DVD = 2;

    public interface Searcher {
        public SearchResult execute(String query, ItemContainer items);
    }

    public static class TitleSearcher implements Searcher {
        private int type;

        TitleSearcher(int type) {
            this.type = type;
        }

        public SearchResult execute(String query, ItemContainer items) {
            SearchResult results = new SearchResult();
            for (LoanableItem item : items) {
                if (item.titleContains(query)) {
                    if (type == 0) {
                        results.add(item);
                    } else if (type == 1 && item.getClass() == Book.class) {
                        results.add(item);
                    } else if (type == 2 && item.getClass() == DVD.class) {
                        results.add(item);
                    }
                }
            }
            return results;
        }
    }
}