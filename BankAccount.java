import java.util.ArrayList;
import java.util.Random;

class BankAccount {
    // HashTable is used for O(1) time account balance retrieval
        // Example: account number 97361 has balance $530.49
        // Implementation: hashTable[97361] contains 530.49
    private double[] hashTable = new double[100_000];

    // Instance variables
    private String name;
    private int ssNumber;
    private int birDate;
    private long randomNum; // Used to generate unique accnt number
    private int accountNum; // Accnt number indexes hashTable for accnt balance

    public BankAccount() {
        this.name = "Default -- fill in later";
    }

    private String getName() {
        return name;
    }

    private int getAccntNum() {
        return accountNum;
    }

    private double getBalance() {
        return hashTable[accountNum];
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSsNumber(int ssNumber) {
        this.ssNumber = ssNumber;
    }

    public void setBirDate(int birDate) {
        this.birDate = birDate;
        createRandomNum();
    }
    
    private void createRandomNum() {
        Random ran = new Random();
        int x = ran.nextInt(1_000_000);
        int y = ssNumber + birDate + x;
        randomNum = y;
        createAccntNum();
    }

    private void createAccntNum() {
        accountNum = (int) (randomNum % 100_000);
    }

    public void setDeposit(double deposit) {
        hashTable[accountNum] = deposit;
    }

    public static void toString(ArrayList<BankAccount> accountList) {
        System.out.println();

        for (int i = 0; i < accountList.size(); ++i) {
            BankAccount bankAccnt = accountList.get(i);
            System.out.println("User name is " + bankAccnt.getName());
            System.out.println("Account number is " + bankAccnt.getAccntNum());
            System.out.println("Balance is " + bankAccnt.getBalance());
            System.out.println();
        }
    }
}
