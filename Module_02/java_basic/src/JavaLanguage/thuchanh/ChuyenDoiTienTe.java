package JavaLanguage.thuchanh;


import java.util.Scanner;

public class ChuyenDoiTienTe {
    public static void main(String[] args) {
        double vn = 23000;
        double usd;
        double quyDoi;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tiền USD muốn quy đổi!");
        usd = scanner.nextDouble();
        quyDoi = usd*vn;
        System.out.printf("Số tiền sau khi quy đổi = %1.0f", quyDoi);
        System.out.print("$");
    }
}
