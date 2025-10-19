import java.math.BigDecimal;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Создаём пользователя.
        User user = new User ("user1", "John Doe", new ArrayList<BankAccount>() );

        // Создаём сервис.
        BankService bankService = new BankService();

        // Создаём счета.
        bankService.createAccount(user,"ACC123");
        bankService.createAccount(user,"ACC456");

        List<BankAccount> accounts = user.getAccounts();   // Получаем счета пользователя
        BankAccount acc1 = accounts.get(0);
        BankAccount acc2 = accounts.get(1);

        acc1.deposit(new BigDecimal("1000"));          // Пополняем счёт №1

        bankService.transfer(acc1, acc2, new BigDecimal("100"));    // Переводим средства между счетами

        System.out.println("Баланс счёта ACC123: " + acc1.getBalance());  // Выводим балансы
        System.out.println("Баланс счёта ACC456: " + acc2.getBalance());

        System.out.println("История транзакций для счёта АСС123: ");         // Выводим историю транзакций
        bankService.getTransactionHistory(acc1).forEach(System.out::println);
    }
}
