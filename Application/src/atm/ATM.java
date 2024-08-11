package atm;

import bank_account.BankAccount;
import bank_account.BankAccountDatabase;

import java.util.Scanner;

public class ATM {

    private int userInput;

    private long accountCounter=0l;
    private BankAccountDatabase bankAccountDatabase;

    public ATM() {
        bankAccountDatabase = BankAccountDatabase.getBankDatabase();
    }

    public void displayOptions(){
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        while (!exit){
            System.out.println("----------WELCOME TO BANK--------------");
            System.out.println("");
            System.out.println("1. Display Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Open new Account");
            userInput = sc.nextInt();

            switch (userInput){
                case 1: displayBalance();
                    break;
                case 2: depositMoney();
                    break;
                case 3: withdrawMoney();
                    break;
                case 4: openNewAcount();
                    break;
                default: wrongInput();
            }
            System.out.println("");
            sc.nextLine();
            System.out.println("want to continue? y/n");
            String isContinue = sc.nextLine();
            if(isContinue.equals("n"))exit=true;
        }
        }

    private void openNewAcount() {
        this.accountCounter++;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your Name");
        String name = sc.nextLine();
        BankAccount bankAccount = new BankAccount(name, this.accountCounter);
        bankAccountDatabase.addAccount(bankAccount);
        System.out.println("Congratulations!!!! your new  Account Number is "+bankAccount.getAccountNumber());

    }

    private String wrongInput() {
        return "choose correct option";
    }

    private void withdrawMoney() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your Account");
        long accNo = sc.nextLong();
        System.out.println("Enter amount to Withdraw");
        Float amount = sc.nextFloat();
        BankAccount bankAccount = bankAccountDatabase.getAccountDetails(accNo);
        if(bankAccount.getBalance()>amount){
            bankAccount.setBalance(bankAccount.getBalance()-amount);
            bankAccountDatabase.addAccount(bankAccount);
            System.out.println("");
            System.out.println(amount+" has been debited from your account");
            System.out.println("your current account balance is "+bankAccount.getBalance());
        }
        else System.out.println("Insufficient Amount");


    }

    private void depositMoney() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your Account");
        long accNo = sc.nextLong();
        System.out.println("Enter amount to deposit");
        Float amount = sc.nextFloat();
        BankAccount bankAccount = bankAccountDatabase.getAccountDetails(accNo);
        bankAccount.setBalance(bankAccount.getBalance()+amount);
        System.out.println("");
        System.out.println(amount+" added successfully to your account");
    }

    private void displayBalance() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Account Number");
        long accNo = sc.nextLong();
        BankAccount bankAccount = bankAccountDatabase.getAccountDetails(accNo);
        System.out.println(bankAccount.getBalance());

    }

}



