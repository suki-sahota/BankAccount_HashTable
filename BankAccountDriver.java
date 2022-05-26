import java.util.ArrayList;
import java.util.Scanner;

class BankAccountDriver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<BankAccount> accountList = 
            new ArrayList<BankAccount>();

        System.out.println("Hello! How are you doing today? " +
            "We are Meaghan Stanley. " + 
            "Let's set up a personal bank account for you."
        );

        enrollClient(sc, accountList);
        BankAccount.toString(accountList);

        System.out.println("Thank you for banking with Meaghan Stanley. " +
            "We appreciate your business."
        );
    }

    private static void enrollClient(Scanner sc,
        ArrayList<BankAccount> accountList)
    {
        addUser(sc, accountList);
        boolean addAnotherUser = addAnother(sc);

        // Taste of recursion
        if (addAnotherUser == true) { enrollClient(sc, accountList); }
        else { return; }
    }

    private static void addUser(Scanner sc,
        ArrayList<BankAccount> accountList)
    {
        // Create new BankAccount instance and add to accountList
        BankAccount bankAccount = new BankAccount();
        accountList.add(bankAccount);

        boolean validInput = false;

        // Get name
        System.out.println("What is your name?");
        if (sc.hasNext()) {
            String name = sc.nextLine();
            accountList.get(accountList.size() - 1).setName(name);
        }

        // Get social security number
        System.out.println("Please provide your full social security number." +
            "Format 123-45-6789 as 123456789."
        );
        while (!validInput) {
            if (sc.hasNextInt()) {
                int ssNumber = sc.nextInt();
                accountList.get(accountList.size() - 1).setSsNumber(ssNumber);
                sc.nextLine();
                validInput ^= true;
            } else {
                sc.nextLine();
                System.out.println("Please enter a valid social security num");
            }
        }
        validInput = false;

        // Get birthdate
        System.out.println("Please provide your birthdate." +
            "Formate Mar. 1, 1991 as 03011991"
        );
        while (!validInput) {
            if (sc.hasNextInt()) {
                int birDate = sc.nextInt();
                accountList.get(accountList.size() - 1).setBirDate(birDate);
                sc.nextLine();
                validInput ^= true;
            } else {
                sc.nextLine();
                System.out.println("Please enter a valid birth date");
            }
        }
        validInput = false;

        // Deposit money
        System.out.println("How much money would you like to deposit today?" +
            "Please enter an amount as a decimal."
        );
        while (!validInput) {
            if (sc.hasNextDouble()) {
                double deposit = sc.nextDouble();
                accountList.get(accountList.size() - 1).setDeposit(deposit);
                sc.nextLine();
                validInput ^= true;
            } else {
                sc.nextLine();
                System.out.println("Please enter a valid deposit amount");
            }
        }
    }

    private static boolean addAnother(Scanner sc) {
        // return value -- true when adding another
        boolean addAnotherUser = true; 

        System.out.println("Would you like to set up another bank account " +
            "for someone else? y/n"
        );

        boolean validInput = false;
        while (!validInput) {
            String input = sc.next();
            sc.nextLine();
            if (input.equals("y") || input.equals("Y") || input.equals("yes")
                || input.equals("Yes") || input.equals("YES"))
            {
                addAnotherUser = true;
                validInput ^= true;
            } else if (input.equals("n") || input.equals("N") || 
                input.equals("no") || input.equals("No") || input.equals("NO"))
            {
                addAnotherUser = false;
                validInput ^= true;
            } else {
                System.out.println("Please type an appropriate repsonse.");
            }
        }
        
        return addAnotherUser;
    }
}
