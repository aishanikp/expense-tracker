import java.util.Scanner;

public class ExpenseTracker {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    // Main method implementation
    while (true) {
      // Display menu and handle user input
      System.out.println("-- Expense Tracker --");
      System.out.println("1. Add Expense");
      System.out.println("2. View Expenses");
      System.out.println("3. Exit");
      
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
          // Exit logic
          System.out.println("Thank you for using the Expense Tracker!");
          System.exit(0);
        default:
          System.out.println("Invalid choice. Please try again.");
      }
    }
  }
  static void addExpense() {
    
    System.out.println("Adding an expense...");
    
  }
  static void viewExpenses() {
    
    System.out.println("Viewing expenses...");
    
  }
}
