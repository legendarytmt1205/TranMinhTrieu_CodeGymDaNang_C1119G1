package ClassAndObject.ThucHanh;
import java.util.Arrays;
import java.util.Random;

public class RandomValue {
    public static void main(String[] args) {
        int[] arr = new int[1000];
        for (int i = 0 ; i<1000;i++) {
            Random rd = new Random();
            int number = rd.nextInt(1000);
            arr[i] = number;
            //System.out.println(number);
        }
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j] < arr[index]){
                    index = j;//searching for lowest index
                }
            }
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
    }
}
