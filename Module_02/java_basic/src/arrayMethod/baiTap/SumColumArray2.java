package arrayMethod.baiTap;

public class SumColumArray2 {
    public static void main(String[] args) {
        int sum = 0;
        int col = 3;
        int[][] arr2 = {{1, 3, 4}
                      , {3, 5, 6}
                      , {5, 3, 12}};
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                if (j==(col-1)) {
                   sum+=arr2[i][j];
                }
            }
        }

        System.out.println("Tổng các giá trị của cột "+ col +" là: "+sum);
    }
}
