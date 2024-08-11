package bank_account;

import java.util.HashMap;
import java.util.Map;

public class BankAccountDatabase {

    Map<Long, BankAccount> map;

    static BankAccountDatabase thisDatabase;

    private BankAccountDatabase(){
      map =  new HashMap<>();
    }

    public void addAccount(BankAccount bankAccount){
        map.put(bankAccount.getAccountNumber(),bankAccount);
    }

    public BankAccount getAccountDetails(long accNo){
        if(map.containsKey(accNo))return map.get(accNo);
        else return new BankAccount();
    }

    public void deleteAccount(long accNo){
        map.remove(accNo);
    }

    public static BankAccountDatabase getBankDatabase(){
        if(thisDatabase==null){
            thisDatabase = new BankAccountDatabase();
        }
        return thisDatabase;
    }


}
