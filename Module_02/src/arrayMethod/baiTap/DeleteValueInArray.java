package arrayMethod.baiTap;

import java.util.Arrays;

public class DeleteValueInArray {
    public static void main(String[] args) {
        int[] arr = {2, 4, 3, 4, 7, 4};
        //xóa phần tử số 67
        int val = 4;
//        int index = 0;
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] == val) {
//                index = i;
//                arr[i]=0;
//            }
//        }
//        for (int i = index; i < arr.length; i++) {
//            if (arr[i] == val) {
//
//            }
//        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) {
                arr[i] = 0;
            }
        }

//        for (int i = 0,j=0; i < arr.length; i++) {
//            if ((i +1) == arr.length) {
//                break;
//            }
//            if (arr[i] == 0) {
//                arr[j] = arr[i + 1];
//
//            }
//        }

        for (int item : arr) {
            if (item != 0) {
                System.out.println(item);
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
