import java.util.Scanner;

public class BankAccount {

    private int accountNumber;
    private String accountHolderName;
    private double balance;
    private double withdrawal;
    private double deposit;

    private static Scanner scanner = new Scanner(System.in);

    public BankAccount() {
        this.accountNumber = getAccountNumber();
        this.accountHolderName = accountHolderName;
        this.balance = 0.0;
    }

    public void withdraw(double withdrawalAmount) {
        this.balance -= withdrawalAmount;
    }

    public void deposit(double depositAmount) {
        this.balance += depositAmount;
    }

    public int getAccountNumber() {
        System.out.println("Please enter your pin number: ");
        accountNumber = scanner.nextInt();
        return accountNumber;
    }

    public double getBalance() {
        System.out.println("Current Balance: " + balance);
        return balance;
    }

    public void performTransaction(int option) {
        switch (option) {
            case 1:
                System.out.println("How much would you like to withdraw?");
                double withdrawalAmount = scanner.nextDouble();
                withdraw(withdrawalAmount);
                break;
            case 2:
                System.out.println("How much would you like to deposit?");
                double depositAmount = scanner.nextDouble();
                deposit(depositAmount);
                break;
            case 3:
                getBalance();
                break;
            case 4:
                System.out.println("Thank you, please remove your card");
                break;
            default:
                System.out.println("Invalid option. Please enter a valid choice.");
        }
    }
    public void choice() {
        int option;

        do {

            System.out.println("Choose enter a number to select an option");
            System.out.println("1. Make a withdrawal");
            System.out.println("2. Make a deposit");
            System.out.println("3. display balance");
            System.out.println("4. finish");

            option = scanner.nextInt();
            performTransaction(option);

        } while (option != 4);
    }
}