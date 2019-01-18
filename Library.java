import java.util.*;
import java.io.*;

public class Library {
    private ItemContainer itemContainer = new ItemContainer();
    private LinkedList<Customer> customersList = new LinkedList<>();

    Library() {
        itemContainer.loadBooksFromFile("books.csv");
        itemContainer.loadDVDsFromFile("dvds.csv");
        loadCustomersFromFile("customers.csv");
    }

    public LinkedList<LoanableItem> getAllItems() {
        return this.itemContainer;
    }

    public SearchResult search(SearchManager.Searcher searcher, String query) {
        return searcher.execute(query, itemContainer);
    }

    public LinkedList<Customer> getAllCustomers() {
        return this.customersList;
    }

    public Customer getCustomerById(int id) {
        for (Customer customer : customersList) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    public void addNewCustomer(Customer customer) {
        customersList.add(customer);
    }

    private void loadCustomersFromFile(String filepath) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            String line;
            while ((line = br.readLine()) != null) {
                customersList.add(new Customer(line));
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error reading the book data!");
            e.printStackTrace();
        }
    }

}