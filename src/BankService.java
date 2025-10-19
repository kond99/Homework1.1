import java.math.BigDecimal;
import java.util.List;

public class BankService {

    BigDecimal totalBalance;

   void createAccount (String accountNumber, BigDecimal balance, User owner, List<Transaction> transactions ){      // создает новый счет для пользователя
       BankAccount newAccount = new BankAccount (accountNumber, balance, owner, transactions);
       owner.getAccounts().add(newAccount);
   }

   void transfer(BankAccount source, BankAccount target, BigDecimal amount) {        // переводит средства между счетами (с проверкой на достаточность средств)
       if (amount.compareTo(BigDecimal.ZERO) <= 0) {
           throw new IllegalArgumentException("Сумма перевода должна быть положительной!");  // проверка суммы перевода
       }
       if (source.getBalance().compareTo(amount) <= 0) {
           throw new IllegalArgumentException("Недостаточно средств на счёте отправителя!"); // проверка достаточности суммы на счёте отправителя
       }
   }

    void getTransactionHistory(BankAccount account){                                 // возвращает историю транзакций для указанного счета
    }

    void getTotalBalance(User user){                                                 // возвращает общий баланс всех счетов пользователя
    }
}

