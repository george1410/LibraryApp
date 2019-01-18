public class UserInterface {
    Library library;

    UserInterface(Library library) {
        this.library = library;

        while(true) {
            runUI();
        }
    }

    private void runUI() {
        String query = new InputGrabber().grab("Search Term: ");
        SearchResult searchResult = library.search(new SearchManager.TitleSearcher(), query);

        System.out.println(searchResult.getNumberOfResultsInWords() + " found:");
        if (searchResult.hasResults()) {
            System.out.println(searchResult.stringifyAll());
        }
    }
}