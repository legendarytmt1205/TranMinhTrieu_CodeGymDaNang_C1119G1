package arrayMethod.thucHanh;

import java.util.Scanner;

public class ChuyenDoiNhietDo {
    private static  double fahrenheit;

    private static  double celsius;

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {


        int choice;

        do {
            System.out.println("Menu.");
            System.out.println("1. Fahrenheit to Celsius");
            System.out.println("2. Celsius to Fahrenheit");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter Fahrenheit");
                    fahrenheit = input.nextDouble();
                    double f = celsiusToFahrenheit(fahrenheit);
                    System.out.println(f);
                    break;
                case 2:
                    System.out.println("Enter celsius");
                    celsius = input.nextDouble();
                    double c = celsiusToFahrenheit(celsius);
                    System.out.println(c);
                    break;
                case 0:
                    System.exit(0);
            }
        } while (choice != 0);
    }

    public static double celsiusToFahrenheit(double celsius) {
        double fahrenheit = (9.0 / 5) * celsius + 32;
        return fahrenheit;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        double celsius = (5.0 / 9) * (fahrenheit - 32);
        return celsius;
    }
}
