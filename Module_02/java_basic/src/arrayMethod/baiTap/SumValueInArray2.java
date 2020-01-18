package arrayMethod.baiTap;

public class SumValueInArray2 {
    public static void main(String[] args) {
        int sum = 0;
        int[][] arr2 = {{1, 3, 4}
                , {3, 5, 6}
                , {5, 3, 12}};
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                if (i == j) {
                    sum += arr2[i][j];
                }
            }
        }

        System.out.println("Tổng các giá trị có chỉ số bằng nhau là: " +sum);
    }
}
