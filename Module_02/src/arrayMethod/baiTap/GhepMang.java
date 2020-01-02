package arrayMethod.baiTap;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class GhepMang {


    public static void main(String[] args) {
        int[] a = {111, 3, 22, 4, 5};
        int[] b = {11, 333, 22, 43, 51, 66, 77};
        int[] c = new int[a.length + b.length];
        for (int i = 0; i < a.length + b.length; i++) {
            if (i < a.length) {
                c[i] = a[i];
            } else {
                c[i] = b[i - a.length];
            }
        }
        System.out.println(Arrays.toString(c));
    }
}
