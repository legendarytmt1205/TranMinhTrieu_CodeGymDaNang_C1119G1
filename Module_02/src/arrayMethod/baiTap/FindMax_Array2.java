package arrayMethod.baiTap;

public class FindMax_Array2 {
    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 3},
                {4, 5, 6},
                {9, 12, 45}
        };

        int max = a[0][0];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (max < a[i][j]) {
                    max = a[i][j];
                }
            }
        }
        System.out.println("Giá trị lớn nhất của mảng là: " + max);
    }
}
