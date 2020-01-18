package arrayMethod.baiTap;

import java.util.Arrays;
import java.util.Scanner;

public class FindMin_Keyboard {
    public static void main(String[] args) {
        int size = 5;
        int [] arr = new int[size];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Nhập vào phần tử thứ: "+ (i+1));
            arr[i] = sc.nextInt();
        }
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (min>arr[i]) {
                min = arr[i];
            }
        }
        sc.nextLine();
        System.out.println("Giá trị bé nhất của mảng là: "+min);
        //System.out.println(Arrays.toString(arr));
    }
}
