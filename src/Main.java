import java.util.Scanner;

class Main {
    public static void main(String[] args) {
            Scanner scnr = new Scanner(System.in);

            int ranNumz;
            int ranNums;

            System.out.print("Enter the first number: ");
            ranNumz = scnr.nextInt();
            System.out.print ("Enter the second number: ");
            ranNums = scnr.nextInt();

            System.out.println("Addition: " + (ranNumz + ranNums));
            System.out.println("Subtraction: " + (ranNumz - ranNums));
            System.out.println("Multiplication: " + (ranNumz * ranNums));
            System.out.println("Division: " + (ranNumz / ranNums));
    }
}

