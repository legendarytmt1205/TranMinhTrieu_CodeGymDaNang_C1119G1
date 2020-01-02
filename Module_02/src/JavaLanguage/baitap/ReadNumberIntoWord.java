package JavaLanguage.language.baitap;

import java.util.Scanner;

public class ReadNumberIntoWord {
    public int age;

    public static void main(String[] args) {
        System.out.println("Nhập vào một số nguyên dương bất kỳ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        String result = Integer.toString(number);
        String resultD, resultC, resultT;
        String d, c, t;
        String readD, readC, readT;
        String donVi;
        String chuc;
        String tram;
        NumberWords numberWords = new NumberWords();
        if (result.length() == 1) {
            readD = numberWords.don_vi(number);
            System.out.println(readD);
        } else if (result.length() == 2) {
            d = result.substring(result.length() - 1);
            //d = result.charAt(result.length() - 1);
            readD = numberWords.don_vi(Integer.parseInt(d));

            c = result.substring(result.length() - 2, 1);
            readC = numberWords.chuc(Integer.parseInt(c));

            System.out.println(readC + " " + readD);
        } else if (result.length() == 3) {
            d = result.substring(result.length() - 1);
            readD = numberWords.don_vi(Integer.parseInt(d));

            c = result.substring(result.length() - 2, 1);
            readC = numberWords.chuc(Integer.parseInt(c));

            t = result.substring(result.length() - 3, 1);
            readT = numberWords.tram(Integer.parseInt(t));

            System.out.println(readT + " " + readC + " " + readD);

        }
    }
}

class NumberWords {

    public String don_vi(int number) {
        switch (number) {
            case 0:
                return "Không";
            case 1:
                return "Một";
            case 2:
                return "Hai";
            case 3:
                return "Ba";
            case 4:
                return "Bốn";
            case 5:
                return "Năm";
            case 6:
                return "Sáu";
            case 7:
                return "Bảy";
            case 8:
                return "Tám";
            default:
                return "Chín";
        }
    }

    public String chuc(int number) {
        switch (number) {
            case 0:
                return "Lẻ";
            case 1:
                return "Mười";
            case 2:
                return "Hai Mươi";
            case 3:
                return "Ba Mươi";
            case 4:
                return "Bốn Mươi";
            case 5:
                return "Năm Mươi";
            case 6:
                return "Sáu Mươi";
            case 7:
                return "Bảy Mươi";
            case 8:
                return "Tám Mươi";
            default:
                return "Chín Mươi";
        }
    }

    public String tram(int number) {
        switch (number) {
            case 0:
                return "Không Trăm";
            case 1:
                return "Một Trăm";
            case 2:
                return "Hai Trăm";
            case 3:
                return "Ba Trăm";
            case 4:
                return "Bốn Trăm";
            case 5:
                return "Năm Trăm";
            case 6:
                return "Sáu Trăm";
            case 7:
                return "Bảy Trăm";
            case 8:
                return "Tám Trăm";
            default:
                return "Chín Trăm";
        }
    }
}

