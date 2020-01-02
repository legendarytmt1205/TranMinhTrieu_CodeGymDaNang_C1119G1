package JavaLanguage.thuchanh;

import java.util.Scanner;

public class ChiSoCanNang {
    public static void main(String[] args) {
        double chieuCao, canNang, bmi;
        System.out.println("Nhập vào chiều cao metter!");
        Scanner scanner = new Scanner(System.in);
        chieuCao = scanner.nextDouble();
        System.out.println("Nhập vào cân nặng kilogam!");
        canNang = scanner.nextDouble();

        bmi = canNang / Math.pow(chieuCao, 2);

        System.out.printf("%-20s%s", "bmi", "Interpretation\n");

        if (bmi < 18)
            System.out.printf("%-20.2f%s", bmi, "Underweight");
        else if (bmi < 25.0)
            System.out.printf("%-20.2f%s", bmi, "Normal");
        else if (bmi < 30.0)
            System.out.printf("%-20.2f%s", bmi, "Overweight");
        else
            System.out.printf("%-20.2f%s", bmi, "Obese");
    }
}
