package arrayMethod.baiTap;

import java.lang.reflect.Array;
import java.util.Scanner;

public class AddValue_Array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println("Nhập vào số cần chèn vào mảng!");
        int a = scanner.nextInt();
        System.out.println("Nhập vào vị trí muốn chèn vào mảng!");
        int index = scanner.nextInt();
        if (index <= 1 || index >= arr.length - 1) {
            System.out.println("Không thể chèn được!");
        } else {
            int[] result = new int[arr.length + 1];
            boolean flag = false;
            for (int i = 0; i < arr.length; i++) {
                if (i == index) {
                    result[i] = a;
                    flag = true;
                }
                if (flag) {
                    result[i+1] = arr[i];
                    continue;
                }
                result[i] = arr[i];
            }
            for (int item : result) {
                System.out.println(item);
            }
        }
    }
}
