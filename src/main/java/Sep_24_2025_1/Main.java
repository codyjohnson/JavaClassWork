package Sep_24_2025_1;

public class Main {

    public static void main(String[] args) {

//        int[][] matrix = {{2,2},{4,4},{2,2}};
//        int[][] matrix2 = new int[matrix[0].length][matrix.length];
//
//        for (int i = 0; i < matrix[0].length; i++) {
//            for (int j = 0; j < matrix.length; j++) {
//                matrix2[i][j] = matrix[j][i];
//            }
//        }

    CurrentAccount currentAccount = new CurrentAccount(10000);
    SavingsAccount savingsAccount = new SavingsAccount(25000);

    currentAccount.deposit(200);
    currentAccount.withdraw(100);

    savingsAccount.deposit(200);
    savingsAccount.withdraw(100);

    System.out.printf("Current account balance: %.2f%n", currentAccount.getBalance());
    System.out.printf("Savings account balance: %.2f%n", savingsAccount.getBalance());






    }
}