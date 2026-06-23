import java.util.Scanner;
import java.util.ArrayList;

public class ExpenseTracker {
  static ArrayList<Double> expenses = new ArrayList<>();
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    // Main method implementation
    while (true) {
      // Display menu and handle user input
      System.out.println("-- Expense Tracker --");
      System.out.println("1. Add Expense");
      System.out.println("2. View Expenses");
      System.out.println("3. Show Total");
      System.out.println("4. Exit");
      
      // Get user input and perform actions based on choice
      System.out.print("Enter your choice: ");
      
      int choice = scanner.nextInt();

      switch (choice) {
        case 1:
          addExpense();
          break;
        case 2:
          viewExpenses();
          break;
        case 3:
          total();
          break;
        case 4:
          // Exit logic
          System.out.println("Thank you for using the Expense Tracker!");
          System.exit(0);
        default:
          System.out.println("Invalid choice. Please try again.");
      }
    }
  }
  static void addExpense() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter expense amount: ");
    double amount = scanner.nextDouble();
    expenses.add(amount);
    System.out.println("\n");
    
  }
  static void total() {
    double total = 0;
    for (double expense : expenses) {
      total += expense;
    }
    System.out.println("Total Expenses: " + total);
    System.out.println("\n");
    
  }
  static void viewExpenses() {
    if (expenses.isEmpty()) {
      System.out.println("No expenses recorded.");
      return;
    }
    int c=1;
    for (double expense : expenses) {
      System.out.println("Expense " + c + " : " + expense);
      c++;
    }
    System.out.println("\n");
    
  }
}
