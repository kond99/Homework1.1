import java.math.BigDecimal;
import java.time.LocalDateTime;

class Transaction {
    String id;                                       // уникальный идентификатор транзакции
    BigDecimal amount;                               // сумма транзакции
    TransactionType type;                            // тип транзакции - Enum (DEPOSIT, WITHDRAWAL, TRANSFER)
    LocalDateTime date;                              // дата выполнения транзакции
    BankAccount sourceAccount;                       // источник транзакции (если применимо)
    BankAccount targetAccount;                       // получатель транзакции (если применимо)

    public Transaction(String id, BigDecimal amount, TransactionType type, LocalDateTime date, BankAccount sourceAccount, BankAccount targetAccount) {
        this.id = id;
        this.amount = amount;
        this.type = type;
        this.date = date;
        this.sourceAccount = sourceAccount;
        this.targetAccount = targetAccount;
    }
    public static Transaction createTransaction (String id, BigDecimal amount, TransactionType type, LocalDateTime date, BankAccount sourceAccount, BankAccount targetAccount){
        return new Transaction (id, amount, type, date, sourceAccount, targetAccount);
    }
                                                      // написать метод: конструктор для создания транзакции (сделал по уроку №20 Алишева)
}
