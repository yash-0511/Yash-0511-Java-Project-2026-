/**
 * Represents a financial transaction with details such as amount, category, date, and type.
 */
public class Transaction {
    private int id;
    private double amount;
    private String category;
    private String date;
    private String type;

    /**
     * Constructs a new Transaction with the specified details.
     *
     * @param id       the unique identifier for this transaction
     * @param amount   the monetary amount of the transaction
     * @param category the category of the transaction (e.g., "Food", "Salary")
     * @param date     the date of the transaction
     * @param type     the type of transaction ("INCOME" or "EXPENSE")
     */
    public Transaction(int id, double amount, String category, String date, String type) {
        this.id = id;
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.type = type;
    }

    /**
     * Returns the unique identifier of this transaction.
     *
     * @return the transaction ID
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the monetary amount of this transaction.
     *
     * @return the transaction amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Returns the category of this transaction.
     *
     * @return the transaction category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Returns the date of this transaction.
     *
     * @return the transaction date
     */
    public String getDate() {
        return date;
    }

    /**
     * Returns the type of this transaction.
     *
     * @return the transaction type ("INCOME" or "EXPENSE")
     */
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s: $%.2f (%s)", date, type, amount, category);
    }
}
