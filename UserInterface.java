public class UserInterface {
    Library library;
    Menu mainMenu;

    UserInterface(Library library) {
        this.library = library;

        mainMenu = new Menu("Main Menu", new String[]{"Search all by title", "Search books by title", "Search DVDs by title"});

        while(true) {
            runUI();
        }
    }

    private void runUI() {
        int customerId;
        do {
            try {
                customerId = Integer.parseInt(new InputGrabber().grab("Enter Customer ID to log in: "));
            } catch (NumberFormatException e) {
                customerId = -1;
            }        
        } while (library.getCustomerById(customerId) == null);

        library.setCurrentCustomer(library.getCustomerById(customerId));
        System.out.println("Hello, " + library.getCurrentCustomer().getName() + "\n");

        int selection = mainMenu.show();

        switch (selection) {
            case 0:
                showSearch(new SearchManager.TitleSearcher());
                break;
            case 1: 
                System.out.println("Search Books by Title");
                break;
            case 2: 
                System.out.println("Search DVDs by Title");
                break;
            default:
                break;
        }
    }


    private void showSearch(SearchManager.Searcher searcher) {
        String query = new InputGrabber().grab("Search Term: ");
        SearchResult searchResult = library.search(searcher, query);

        System.out.println(searchResult.getNumberOfResultsInWords() + " found:");
        if (searchResult.hasResults()) {
            System.out.println(searchResult.stringifyAll());
        }
    }
}