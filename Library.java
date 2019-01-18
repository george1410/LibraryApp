import java.util.*;

public class Library {
    private ItemContainer itemContainer = new ItemContainer();

    Library() {
        itemContainer.loadBooksFromFile("books.csv");
        itemContainer.loadDVDsFromFile("dvds.csv");
    }

    public LinkedList<LoanableItem> getAllItems() {
        return this.itemContainer;
    }

    public LinkedList<LoanableItem> search(Searcher searcher, String query) {
        return searcher.execute(query, itemContainer);
    }

}