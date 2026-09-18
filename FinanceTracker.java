import java.io.File;
import java.util.ArrayList;

/**
 * Manages a collection of financial transactions and provides methods for
 * tracking income, expenses, and calculating balances.
 */
public class FinanceTracker {
    private ArrayList<Transaction> transactions;

    /**
     * Constructs a new FinanceTracker and loads existing transactions from file if available.
     */
    public FinanceTracker() {
        this.transactions = new ArrayList<>();
        if (new File(FileHandler.FILENAME).exists()) {
            this.transactions.addAll(FileHandler.loadTransactions());
        }
    }

    /**
     * Adds a transaction to the tracker.
     *
     * @param t the transaction to add
     */
    public void addTransaction(Transaction t) {
        if (t != null) {
            transactions.add(t);
        }
    }

    /**
     * Calculates the current balance by summing all incomes and subtracting all expenses.
     *
     * @return the current balance
     */
    public double getBalance() {
        double total = 0.0;
        for (Transaction t : transactions) {
            if ("INCOME".equals(t.getType())) {
                total += t.getAmount();
            } else if ("EXPENSE".equals(t.getType())) {
                total -= t.getAmount();
            }
        }
        return total;
    }

    /**
     * Returns a copy of all transactions in the tracker.
     *
     * @return a new ArrayList containing all transactions
     */
    public ArrayList<Transaction> getAllTransactions() {
        return new ArrayList<>(transactions);
    }
}
