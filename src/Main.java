import java.math.BigDecimal;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        User user = new User ("user1", "John Doe", new ArrayList<BankAccount>() );     // Создаём пользователя.

        BankService bankService = new BankService();      // Создаём сервис.

        bankService.createAccount("232139871234",
                new BigDecimal("198276.09"),
                new User("38600", "Zheka", new LinkedList<BankAccount>()),
                new LinkedList<Transaction>());
        // Создаём счета. (accountNumber, balance, owner, transactions)



        List<BankAccount> accounts = user.getAccounts();   // Получаем счета пользователя
        BankAccount acc1 = accounts.get(1);
        BankAccount acc2 = accounts.get(2);

        acc1.deposit(new BigDecimal("1000"));          // Пополняем счёт №1
        acc2.deposit(new BigDecimal("400"));           // Пополняем счёт №2

        System.out.println("Баланс счёта асс1: " + acc1.getBalance());
        System.out.println("Баланс счёта асс2: " + acc2.getBalance());

        bankService.transfer(acc1, acc2, new BigDecimal("100"));   // Переводим средства между счетами

        System.out.println("Новый баланс счёта асс1: " + acc1.getBalance());
        System.out.println("Новый баланс счёта асс2: " + acc2.getBalance());
    }
}
