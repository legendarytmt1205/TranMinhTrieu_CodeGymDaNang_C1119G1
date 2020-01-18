package arrayMethod.thucHanh;

import java.util.Scanner;

public class FindMaxValueInArray {
    public static void main(String[] args) {
        int size;
        double[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter a size:");
            size = scanner.nextInt();
            if (size > 20)
                System.out.println("Size should not exceed 20");
        } while (size > 20);

        //khai báo và nộp dữ liệu vào mảng
        array = new double[size];
        int i = 0;
        while (i < array.length) {
            System.out.print("Enter element" +"_"+(i + 1) + " : ");
            array[i] = scanner.nextInt();
            i++;
        }

        findMaxValue(array);
    }
    public static void findMaxValue(double array[]) {
        double max = array[0];
        int index = 0;

        for (int j = 0; j < array.length;j++) {
            if (max < array[j]) {
                max = array[j];
                index = j+ 1;
            }
        }
        System.out.println("The largest value in array is " + max + " ,at position " + index);
    }
}
