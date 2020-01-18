package arrayMethod.thucHanh;

public class FindMinValueInArray {
    public static void main(String[] args) {
        int []arr = {4, 12, 7, 8, -91, 6, 9};
        int index = findMinValue(arr);
        System.out.println("Giá trị nhỏ nhất là: " + arr[index]);
    }

    public static int findMinValue(int []array){

        int min = array[0];
        int index = 0;

        for (int i = 1; i < array.length; i++){
            if(array[i] < min) {
                min = array[i];
                index = i;
            }
        }

        return index;
    }
}
