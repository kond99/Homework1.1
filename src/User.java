import java.util.List;

public class User {
    String id;                    // уникальный идентификатор пользователя
    String name;                  // имя пользователя
    List<BankAccount> accounts;   // список счетов пользователя, это список объектов класса BankAccount

    public User(String id, String name, List<BankAccount> accounts) {
        this.id = id;
        this.name = name;
        this.accounts = accounts;
    }

    public void addAccount(BankAccount account) {  // добавление нового счёта пользователю
        accounts.add(account);
    }

    public List<BankAccount> getAccounts() {
        return accounts;                              // возвращает список счетов пользователя
    }


}

