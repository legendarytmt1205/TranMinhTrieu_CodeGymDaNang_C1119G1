package vn.codegym.thuchanh;

import java.util.Scanner;

public class PT_BacNhat {
    public static void main(String[] args) {
//        System.out.println("Chương trình giải phương trình bậc nhất dạng Ax + B = 0" +
//                "\n Vui lòng nhập vào 2 hằng số để ra kết quả ");
        Scanner scanner = new Scanner(System.in);
        System.out.print("a: ");
        double a = scanner.nextDouble();

        System.out.print("b: ");
        double b = scanner.nextDouble();


        if (a != 0) {
            double solution = -b / a;
            System.out.printf("The solution is: %f!", solution);
        } else {
            if (b == 0) {
                System.out.print("The solution is all x!");
            } else {
                System.out.print("No solution!");
            }
        }
    }
}
