public class Expense {
    double amount;
    String category;
    Expense(double amount, String category) {
        this.amount = amount;
        this.category = category;
    }
    @Override
    public String toString() {
      return category + " : ₹" + amount;
    }
}
