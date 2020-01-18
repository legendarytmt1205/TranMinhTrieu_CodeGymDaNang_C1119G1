package ClassAndObject.BaiTap;

public class Test {
//    static public class B {
//    }
//
//    public class C {
//    }
//
//    A.B o = new A.B();
//    A.C k = new A.C();
//    A.C l = new A().new C();

}

 class MyClass {
    static public int X = 2;

    //static {int X = 1;}

    static public void method() {
        X = 5;
    }

    public static void main(String[] args) {
        MyClass o = new MyClass();
        MyClass.method();
        MyClass.X = 10;
        System.out.printf("x=%d, y=%d", o.X, MyClass.X);
    }
}
// class MyClass {
//    static public int X = 2;
//
//    public static void main(String[] args) {
//        MyClass o1 = new MyClass();
//        MyClass o2 = new MyClass();
//        o2.X = 5;
//        System.out.printf("x=%d, y=%d, z=%d", o1.X, o2.X, MyClass.X);
//    }
//}
//class MyClass {
//    void method(int x, int y) {
//        x = 5;
//        y = 5;
//    }
//
//    public static void main(String[] args) {
//        MyClass o = new MyClass();
//        int x = 1, y = 1;
//        o.method(x, y);
//        System.out.printf("x=%d, y=%d", x, y);
//    }
//}
