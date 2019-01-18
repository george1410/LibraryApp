public class DVD extends LoanableItem {
    private String director;
    private int runtime;

    DVD(String title, String director, int maxLoanPeriod, int runtime) {
        super(title, maxLoanPeriod);
        this.director = director;
        this.runtime = runtime;
    }

    String getDirector() { return this.director; }

    int getRuntime() { return this.runtime; }

    void setDirector(String director) { this.director = director; }

    void setRuntime(int runtime) { this.runtime = runtime; }


    @Override
    public String toString() {
        return "DVD: {\n" +
            "  director: " + getDirector() + "\n" +
            "  runtime: " + getRuntime() + "\n" +
            "  " + super.toString() + "\n" +
            "}";
    }
}