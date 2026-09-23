package samplearrays;

public class BankAccount {

    String name;
    double currentBalance;
    int k;
    //TO-DO: Initialize an Array with 1000 in size that stores Double called 'transactions' to keep track of the user's transactions
    double [] transactions = new double [1000];
    public BankAccount(String name, int startingBalance){
        this.name = name;
        this.currentBalance = startingBalance;
        k=0;
    }

    public void deposit(double amount){
        if (amount < 0){
            System.out.println("Unsuccessful deposit");
            return;
        }
        transactions[k] = amount;
        currentBalance+=amount;
        System.out.println(name + " deposited " + amount + ". New balance: "+ currentBalance);
        k++;
    }

    public void withdraw(double amount){
        if (amount > currentBalance || amount <0) {
            System.out.println("Unsuccessful withdraw");
            return;
        }
        transactions[k] = -1*amount;
        currentBalance -= amount;
        System.out.println(name + " withdrawn " + amount + ". New balance: "+ currentBalance);
        k++;

    }

    public void displayTransactions(){
        System.out.println("Transactions :");
        for (int i=0;i<k;i++) System.out.println(transactions[i]);
    }

    public void displayBalance(){
        System.out.println("Current balance : "+ currentBalance);

    }

    public static void main(String[] args) {

        BankAccount john = new BankAccount("John Doe", 100);

        // ----- DO NOT CHANGE -----

        //Testing..
        john.displayBalance();
        john.deposit(0.25);
        john.withdraw(100.50);
        john.withdraw(40.90);
        john.deposit(-90.55);
        john.deposit(3000);
        john.displayTransactions();
        john.displayBalance();

        // ----- DO NOT CHANGE -----

    }

}
