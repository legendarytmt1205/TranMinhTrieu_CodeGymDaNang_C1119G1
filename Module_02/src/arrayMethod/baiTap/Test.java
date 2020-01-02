package arrayMethod.baiTap;

import java.util.Scanner;

public class Test {


    public static void main(String[] args) {
        int n= 11;
        int k = 2;
        int i,j;

        int A[] = {1,2,2,5,3,4,2,2,2,2,2};

        for (j = i = 0; i < n; i++) {
            if (A[i] != k) {
                A[j] = A[i];
                j++;
            }
        }
        n = j;
        System.out.println("Mảng còn lại sau khi xóa phần tử " + k + " là: ");
        for (i = 0; i < n; i++) {
            System.out.print(A[i] + "\t");
        }
    }
}
