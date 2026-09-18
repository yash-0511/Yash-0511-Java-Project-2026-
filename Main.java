import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The main entry point for the Finance Tracker application.
 * Provides a command-line interface for managing financial transactions.
 */
public class Main {
    /**
     * The main method that runs the Finance Tracker application.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FinanceTracker tracker = new FinanceTracker();
        int nextId = 1;

        while (true) {
            System.out.println("\n=== Finance Tracker ===");
            System.out.println("1. Add Transaction");
            System.out.println("2. View Balance");
            System.out.println("3. View History");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter amount: ");
                    double amount;
                    try {
                        amount = scanner.nextDouble();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid amount. Please enter a valid number.");
                        scanner.nextLine();
                        continue;
                    }
                    scanner.nextLine();

                    System.out.print("Enter type (INCOME/EXPENSE): ");
                    String type = scanner.nextLine();

                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();

                    System.out.print("Enter date: ");
                    String date = scanner.nextLine();

                    Transaction transaction = new Transaction(nextId++, amount, category, date, type);
                    tracker.addTransaction(transaction);
                    System.out.println("Transaction added successfully!");
                    break;
                case 2:
                    double balance = tracker.getBalance();
                    System.out.printf("Current Balance: $%.2f%n", balance);
                    break;
                case 3:
                    for (Transaction t : tracker.getAllTransactions()) {
                        System.out.println(t.toString());
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
