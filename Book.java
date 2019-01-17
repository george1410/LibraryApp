public class Book extends LoanableItem {
    private String author;
    private int pageCount;

    Book(String title, String author, int maxLoanPeriod, int pageCount) {
        super(title, maxLoanPeriod);
        this.author = author;
        this.pageCount = pageCount;
    }

    String getAuthor() { return this.author; }

    int getPageCount() { return this.pageCount; }

    void setAuthor(String author) { this.author = author; }

    void setPageCount(int pageCount) { this.pageCount = pageCount; }


    @Override
    public String toString() {
        return "Book: {" +
            " author='" + getAuthor() + "'" +
            ", pageCount='" + getPageCount() + "'" +
            "}";
    }

    public String simpleString() {
        return "Book: {" +
            "Title: " + getTitle() + ", " +
            "Author: " + getAuthor() + ", " + 
            "Pages: " + getPageCount() + "}";
    }

}