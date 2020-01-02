package JavaLanguage.thuchanh;

import java.util.Scanner;

public class UocChungLonNhat {
    public static void main(String[] args) {
        System.out.println("Nhập vào hai số nguyên bất kỳ!");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int uoc;

        while (a * b != 0) {
            if (a > b) {
                a %= b;
            } else {
                b %= a;
            }
        }
        uoc = a + b;
        System.out.println("Ước chung lớn nhất là: " + uoc);
    }
}
