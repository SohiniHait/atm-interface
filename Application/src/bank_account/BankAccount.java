package bank_account;

public class BankAccount {

    private String name;
    private long accountNumber;
    private Float balance;

    public BankAccount() {
    }

    public BankAccount(String name, long accountNumber) {
        this.name = name;
        this.accountNumber = accountNumber;
        balance=0f;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "name='" + name + '\'' +
                ", accountNumber=" + accountNumber +
                ", balance=" + balance +
                '}';
    }
}
