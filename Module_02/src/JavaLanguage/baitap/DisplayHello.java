package JavaLanguage.baitap;

import java.util.Scanner;

public class DisplayHello {
    public static void main(String[] args) {

        String a = "1233445";
        String b = a.substring(a.length()-1,a.length());
        System.out.println(b);
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Hello: " + name);
    }
}
