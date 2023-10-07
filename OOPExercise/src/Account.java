import java.util.Arrays;
import java.util.Objects;

public class Account {

    private static final int DEFAULT_TRANSACTIONS_AMOUNT = 10;

    private int id;
    private Transaction[] transactions;
    private int lastTransactionIndex;

    {
        transactions = new Transaction[DEFAULT_TRANSACTIONS_AMOUNT];
    }

    public Account(int id) {
        this.id = id;
    }

    private void addTransaction(Transaction transaction) {
        if (transaction == null) {
            return;
        }
        if (transactions.length <= lastTransactionIndex) {
            transactions = Arrays.copyOf(transactions, transactions.length << 1);
        }
        transactions[lastTransactionIndex++] = transaction;
    }

    public void withdrawMoney(double moneyAmount) {
        Transaction transaction = new Transaction(this,null,moneyAmount, StandardAccountOperations.WITHDRAW);
        addTransaction(transaction);
    }

    private void receiveMoney(Account accountFrom, double moneyAmount) {
        if(accountFrom == null) {
            return;
        }
        if (moneyAmount <= 0) {
            return;
        }
        Transaction transaction = new Transaction(this,accountFrom,moneyAmount,StandardAccountOperations.MONEY_TRANSFER_RECEIVE);
        addTransaction(transaction);
    }

    public void sendMoneyToAccount(Account accountTo, double moneyAmount) {
        if (accountTo == null) {
            return;
        }
        if (moneyAmount <= 0) {
            return;
        }
        Transaction transaction = new Transaction(accountTo, this, moneyAmount, StandardAccountOperations.MONEY_TRANSFER_SEND);
        addTransaction(transaction);
        accountTo.receiveMoney(this, moneyAmount);
    }

    public Transaction[] getTransactions() {
        return Arrays.stream(transactions)
                .filter(Objects::nonNull)
                .toArray(Transaction[]::new);
    }

    @Override
    public String toString() {
        return "Account ID: " + this.id;
    }
}
