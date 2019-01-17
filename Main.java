public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Harry Potter", "J.K. Rowling", 30, 750);
        System.out.println(book1.getMaxLoanPeriod()); // '30'
        System.out.println(book1.isAvailable()); // 'true'
        book1.setAvailable(false);
        System.out.println(book1.isAvailable()); // 'false'
    }
}