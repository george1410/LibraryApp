import java.io.*;
import java.util.*;

public class ItemContainer extends LinkedList<LoanableItem> {

    public void loadBooksFromFile(String filepath) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            String line;
            while ((line = br.readLine()) != null) {
                String[] split = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                if (split.length > 1) {
                    String author = split[0].replace("\"", "");
                    String title = split[1].replace("\"", "");
                    this.add(new Book(title, author, 30, (int)(( Math.random() * 1500) + 1)));
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error reading the book data!");
            e.printStackTrace();
        }
    }

    public void loadDVDsFromFile(String filepath) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            String line;
            while ((line = br.readLine()) != null) {
                String[] split = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                if (split.length > 2) {
                    String title = split[0].replace("\"", "");
                    String director = split[1].replace("\"", "");
                    int runtime = Integer.parseInt(split[2].replace("\"", ""));
                    this.add(new DVD(title, director, 20, runtime));
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error reading the DVD data!");
        }
    }
}