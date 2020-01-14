package arrayMethod.thucHanh;

import java.util.Scanner;

public class ReverseArray {
    private static int size;

    public static void main(String[] args) {

        double[] array;

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter a size:");
            size = scanner.nextInt();
            if (size > 5)
                System.out.println("Size should not exceed 20");
        } while (size > 5);

        //khai báo và nộp dữ liệu vào mảng
        array = new double[size];
        int i = 0;
        while (i < array.length) {
            System.out.print("Enter element" +"_"+(i + 1) + " : ");
            array[i] = scanner.nextInt();
            i++;
        }

        //ReverseArray reverseArray = new ReverseArray();
        //reverseArray.reverse(array);
        reverse(array);
    }
    public static void reverse(double array[]) {
        for (int j = 0; j < array.length / 2; j++) {
            double temp = array[j];
            array[j] = array[size - 1 - j];
            array[size - 1 - j] = temp;
        }
        for (int j = 0; j < array.length; j++) {
            System.out.printf("%-5.0f" ,array[j]);
        }
    }
}
