package Inheritance.BaiTap.CircleAndCylinder;

public class MainTest {
    public static void circleTest() {
        Circle circle = new Circle();
        System.out.println(circle);
        circle = new Circle("red", 2.5);
        System.out.println(circle);
    }

    public static void cylinderTest() {
        Cylinder cylinder = new Cylinder();
        System.out.println(cylinder);
        cylinder = new Cylinder(2.5);
        System.out.println(cylinder);
        cylinder = new Cylinder("blue",3.0,3.0);
        System.out.println(cylinder);
    }

    public static void main(String[] args) {
        //circleTest();
        //cylinderTest();
        Cylinder cylinder = new Cylinder();
        System.out.println(cylinder);
    }
}
