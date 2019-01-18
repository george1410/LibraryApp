public class Customer {
    private static int count = 0;
    private String name;
    private int id;
    private int currentLoans;
    private int maxLoans;

    Customer(String name) {
        this.name = name;
        this.id = ++count;
        this.currentLoans = 0;
        this.maxLoans = 10;
    }

    Customer(String name, int maxLoans) {
        this.name = name;
        this.id = ++count;
        this.currentLoans = 0;
        this.maxLoans = maxLoans;
    }

    public String getName() { return this.name; }

    public int getId() { return this.id; }

    public int getCurrentLoans() { return this.currentLoans; }

    public int getMaxLoans() { return this.maxLoans; }

    public void setName(String name) { this.name = name; }

    public void setMaxLoans(int maxLoans) { this.maxLoans = maxLoans; }

    public boolean canBorrowItem() {
        if (this.currentLoans < this.maxLoans) {
            this.currentLoans++;
            return true;
        } else {
            return false;
        }
    }

    public boolean returnItem() {
        if (this.currentLoans > 0) {
            this.currentLoans--;
            return true;
        } else {
            return false;
        }
    }
}