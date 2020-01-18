package JavaLanguage.baitap;

import java.util.Scanner;

public class NamNhuan {
    public static void main(String[] args) {
        System.out.println("nhập vào năm bất kỳ");
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    System.out.println(year + ": là năm nhuận");
                } else {
                    System.out.println(year + ": Không phải là năm nhuận");
                }
            }
            else {
                System.out.println(year + ": là năm nhuận");
            }
        }
        else {
            System.out.println(year + ": Không phải là năm nhuận");
        }
    }
}
