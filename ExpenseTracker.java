import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ExpenseTracker {
  static ArrayList<Expense> expenses = new ArrayList<>();
  
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    loadExpenses();
    // Main method implementation
    while (true) {
      // Display menu and handle user input
      System.out.println("-- Expense Tracker --");
      System.out.println("1. Add Expense");
      System.out.println("2. View Expenses");
      System.out.println("3. Show Total");
      System.out.println("4. Exit");
      System.out.println("\n");
      
      // Get user input and perform actions based on choice
      System.out.print("Enter your choice: ");
      
      int choice = scanner.nextInt();
      System.out.println("\n");

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
          saveExpenses();
          System.out.println("Thank you for using the Expense Tracker!");
          System.exit(0);
        default:
          System.out.println("Invalid choice. Please try again.");
      } 
    }
  }
  static void addExpense() {
    
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter expense category: ");
    String category = scanner.next();
    System.out.println("Enter expense amount: ");
    double amount = scanner.nextDouble();
    expenses.add(new Expense(amount, category));
    System.out.println("\n");
    saveExpenses();
    
  }
  static void total() {
    double total = 0;
    for (Expense expense : expenses) {
      total += expense.amount;
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
    for (Expense expense : expenses) {
      System.out.println(expense);
      c++;
    }
    System.out.println("\n");
    
  }
  static void saveExpenses(){
    try {
      FileWriter writer= new FileWriter("expenses.txt");
      for (Expense expense : expenses) {
        writer.write(expense.category + "," + expense.amount + "\n");
      }
      writer.close();
    }  
    catch (IOException e) {
      System.out.println("An error occurred while saving expenses.");
      e.printStackTrace();

    }
  
}
static void loadExpenses() {
    try {
      BufferedReader file = new BufferedReader(new FileReader("expenses.txt"));
      String line;
      while ((line = file.readLine()) != null) {
        String[] parts = line.split(",");
        if (parts.length != 2) {
          continue;
        }
        String category = parts[0];
        double amount = Double.parseDouble(parts[1]);
        expenses.add(new Expense(amount, category));
      }
      file.close();
    } catch (IOException e) {
      System.out.println("An error occurred while loading expenses.");
      e.printStackTrace();
    } catch (NumberFormatException e) {
      System.out.println("Invalid expense amount format in file.");
      e.printStackTrace();

    } catch (Exception e) {
      System.out.println("Unexpected error while loading expenses.");
      e.printStackTrace();
    }
  }
}  

