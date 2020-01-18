package JavaLanguage.baitap;

public class SoNguyenToDauTien_20 {
    public static void main(String[] args) {
        for (int i = 3, count = 1; count <= 10; i += 2) {
            boolean flag = true;
            for (var j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flag = false;
                }
            }
            if (flag == true) {
                System.out.println(i + " là số nguyên tố\n");
                count++;
            }
        }
    }
}
