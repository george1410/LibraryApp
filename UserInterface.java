public class UserInterface {
    Library library;

    UserInterface(Library library) {
        this.library = library;

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
        System.out.println("Hello, " + library.getCurrentCustomer().getName());
    }

    private void mainMenu() {

    }

    private void searchByTitle() {
        String query = new InputGrabber().grab("Search Term: ");
        SearchResult searchResult = library.search(new SearchManager.TitleSearcher(), query);

        System.out.println(searchResult.getNumberOfResultsInWords() + " found:");
        if (searchResult.hasResults()) {
            System.out.println(searchResult.stringifyAll());
        }
    }
}