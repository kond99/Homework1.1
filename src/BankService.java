import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BankService {

    BigDecimal totalBalance;

   // ArrayList<BankAccount> bankAccounts= new ArrayList<>();
    //   bankAccounts.add(acc1);
     //   bankAccounts.add(acc2);
    //    bankAccounts.add(acc3);


   void createAccount (User user, String accountNumber) {              // создает новый счет для пользователя
       BankAccount newAccount = new BankAccount(accountNumber, BigDecimal.ZERO, user, new ArrayList<Transaction>());
       user.addAccount(newAccount);
   }

   void transfer(BankAccount source, BankAccount target, BigDecimal amount) {        // переводит средства между счетами (с проверкой на достаточность средств)
       if (amount.compareTo(BigDecimal.ZERO) <= 0) {
           throw new IllegalArgumentException("Сумма перевода должна быть положительной!");  // проверка суммы перевода
       }
       if (source.getBalance().compareTo(amount) <= 0) {
           throw new IllegalArgumentException("Недостаточно средств на счёте отправителя!"); // проверка достаточности суммы на счёте отправителя
       }
   }

    public List<Transaction> getTransactionHistory(BankAccount account){
      return account.transactions;                                                        // возвращает историю транзакций для указанного счета
    }

    public BigDecimal getTotalBalance(User user) {
        BigDecimal sum = BigDecimal.ZERO;
        for (BankAccount account : user.getAccounts()) {
            sum = sum.add(account.getBalance());
        }
        return sum;
    }
}

