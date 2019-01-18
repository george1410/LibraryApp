public abstract class LoanableItem {
    private int maxLoanPeriod;
    private boolean available;
    private String title;
    private Customer loanedTo;
    private int timeRemaining;
    private int renewCount;
    private int maxRenews;

    LoanableItem(String title, int maxLoanPeriod) {
        this.title = title;
        this.maxLoanPeriod = maxLoanPeriod;
        this.available = true;
        this.loanedTo = null;
        this.timeRemaining = maxLoanPeriod;
        this.renewCount = 0;
        this.maxRenews = 1;
    }

    public void setMaxLoanPeriod(int maxLoanPeriod) { this.maxLoanPeriod = maxLoanPeriod; }

    public void setAvailable(boolean available) { this.available = available; }

    public void setTitle(String title) { this.title = title; }

    public boolean isAvailable() { return this.available; }

    public int getMaxLoanPeriod() { return this.maxLoanPeriod; }

    public String getTitle() { return this.title; }

    public Customer getLoanedTo() { return this.loanedTo; }

    public int getTimeRemaining() { return this.timeRemaining; }

    public boolean isOverdue() { 
        return this.timeRemaining < 1; 
    }

    public boolean lendTo(Customer customer) {
        if (customer.borrowItem()) {
            this.loanedTo = customer;
            this.available = false;
            this.timeRemaining = maxLoanPeriod;
            return true;
        } else {
            return false;
        }
    }

    public boolean returnItem() {
        if(this.loanedTo.returnItem()) {
            this.loanedTo = null;
            this.available = true;
            this.timeRemaining = maxLoanPeriod;
            this.renewCount = 0;
            return true;
        } else {
            return false;
        }
    }

    public boolean renewItem() {
        if (this.renewCount < this.maxRenews) {
            this.timeRemaining = maxLoanPeriod;
            this.renewCount++;
            return true;
        } else {
            return false;
        }
    }

    public boolean titleContains(String query) {
        return this.title.toLowerCase().contains(query.toLowerCase());
    }

    @Override
    public String toString() {
        return "LoanableItem: {\n" +
            "    maxLoanPeriod: " + getMaxLoanPeriod() + "\n" +
            "    available:" + isAvailable() + "\n" +
            "    title: " + getTitle() + "\n" +
            "    loanedTo: " + getLoanedTo() + "\n" +
            "    timeRemaining: " + getTimeRemaining() + "\n" +
            "    renewCount: " + this.renewCount + "\n" +
            "    maxRenews: " + this.maxRenews + "\n" +
            "  }";
    }

    public String simpleString() {
        return getTitle();
    }

}