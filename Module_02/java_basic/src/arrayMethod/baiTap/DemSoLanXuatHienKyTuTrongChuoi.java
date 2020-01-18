package arrayMethod.baiTap;

import java.util.Arrays;

public class DemSoLanXuatHienKyTuTrongChuoi {
    public static void main(String[] args) {
        String str = "fasfsafsfsfasfwrerwrw";
        char cr = 'f';
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
//            if ((Character.toString(cr)).equals((Character.toString(str.charAt(i)))))  {
//                count++;
//            }
//            if (cr==str.charAt(i)) {
////                count++;
////            }
            if (Character.toString(cr).compareTo(Character.toString(str.charAt(i)))==0) {
                count++;
            }

        }
        System.out.println("Số lượng phần tử: "+cr+" là "+count );
    }
}
