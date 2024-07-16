import java.util.Scanner;

public class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
        System.out.println("Welcome to ATM");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void selectOption(int option) {
        Scanner sc = new Scanner(System.in);
        switch(option) {
            case 1:
                System.out.print("Enter the Amount to Withdraw: ");
                double withdrawAmount = sc.nextDouble();
                withdraw(withdrawAmount);
                break;
                
            case 2:
                System.out.print("Enter the Amount to Deposit: ");
                double depositAmount = sc.nextDouble();
                deposit(depositAmount);
                break;
                
            case 3:
                checkBalance();
                break;
                
            case 4:
                System.out.println("Thank You for Using the ATM. Goodbye!");
                System.exit(0);
                break;
                
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    public void withdraw(double amount) {
        if(amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive amount.");
            return;
        }
        if(account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
            System.out.println("Please Collect Your Cash.");
        } else {
            System.out.println("Insufficient Balance.");
        }
        checkBalance();        
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive amount.");
            return;
        }
        account.setBalance(account.getBalance() + amount);
        System.out.println("Amount deposited successfully.");
        checkBalance();
    }

    public void checkBalance() {
        System.out.println("Your current balance is: " + account.getBalance());
        System.out.println("");
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);
        ATM atm = new ATM(account);
        Scanner sc = new Scanner(System.in);
        
        while(true) {
            atm.displayMenu();
            System.out.print("Select an Option: ");
            if(sc.hasNextInt()) {
                int option = sc.nextInt();
                atm.selectOption(option);
            } else {
                System.out.println("Invalid input. Please enter a number.");
                sc.next(); // Clear invalid input
            }
        }
    }
}