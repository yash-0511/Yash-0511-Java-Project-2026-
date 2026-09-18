import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Handles file I/O operations for saving and loading transactions.
 */
public class FileHandler {
    /** The default filename for storing transaction data. */
    public static final String FILENAME = "finance_data.txt";

    /**
     * Saves a list of transactions to a CSV file.
     *
     * @param list the list of transactions to save
     */
    public static void saveTransactions(List<Transaction> list) {
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(FILENAME))) {
            for (Transaction t : list) {
                writer.printf("%d,%s,%s,%s,%s%n",
                        t.getId(),
                        t.getAmount(),
                        t.getCategory(),
                        t.getDate(),
                        t.getType());
            }
        } catch (IOException e) {
            System.err.println("Error saving transactions: " + e.getMessage());
        }
    }

    /**
     * Loads transactions from the data file.
     *
     * @return a list of loaded transactions, or an empty list if the file does not exist
     */
    public static List<Transaction> loadTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(FILENAME))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    int id = Integer.parseInt(parts[0]);
                    double amount = Double.parseDouble(parts[1]);
                    String category = parts[2];
                    String date = parts[3];
                    String type = parts[4];
                    Transaction t = new Transaction(id, amount, category, date, type);
                    transactions.add(t);
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading transactions: " + e.getMessage());
        }
        return transactions;
    }
}
