package JavaLanguage.baitap;

public class SoNguyenTo_100 {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            boolean flag = true;
            if (i < 2) {
                flag = false;
            } else {
                for (var j = 2; j <= i - 1; j++) {
                    if (i % j == 0) {
                        flag = false;
                    }
                }
            }
            if (flag == true) {
                System.out.println(i + " là số nguyên tố\n");
            }
        }
    }
}
