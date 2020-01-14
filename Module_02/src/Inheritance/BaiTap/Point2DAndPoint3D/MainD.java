package Inheritance.BaiTap.Point2DAndPoint3D;

import Inheritance.BaiTap.CircleAndCylinder.Circle;

public class MainD {
    public static void main(String[] args) {
       // point2DTest();
        point3DTest();
    }

    public static void point2DTest() {
        Point2D point2D = new Point2D(3.0f,2.5f);
        System.out.println(point2D.toString());
    }

    public static void point3DTest() {
        Point2D point3D = new Point3D();
        ((Point3D)point3D).setXYZ(1.0f,3.0f,4.5f);
        System.out.println(point3D.toString());
    }
}
