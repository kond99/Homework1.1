import java.math.BigDecimal;
import java.util.List;

public class BankAccount {

    String accountNumber;             // уникальный номер счёта
    private BigDecimal balance;               // текущий баланс счёта
    User owner;                       // владелец счёта
    List<Transaction> transactions;    // история транзакций

    public BankAccount(String accountNumber, BigDecimal balance, User owner, List<Transaction> transactions) {
        this.accountNumber = accountNumber;
        this.balance = balance != null? balance : BigDecimal.ZERO; //  если balance null, ставим 0
        this.owner = owner;
        this.transactions = transactions;
    }

    public BankAccount(String number, double v, String user1, String накопления) {
    }

    public BankAccount() {

    }

    public void deposit (BigDecimal amount) {                         // пополнение счёта
        if (amount != null) {
            this.balance = this.balance.add(amount);                  // безопасное сложение
        }
    }
    public boolean withdraw (BigDecimal amount) {                      // снятие средств со счёта (с проверкой на достаточность средств)
        if (amount.signum() > 0 && balance.compareTo(amount) >= 0) {
            balance = balance.subtract(amount);
            return true;
    }
        return false; // недостаточно средств или неверная сумма
    }
    public BigDecimal getBalance () {                                     // возвращает текущий баланс
        return balance;
    }
    public void addTransaction (Transaction transaction) {                 // добавляет транзакцию в историю

        transactions.add(transaction);
    }
}