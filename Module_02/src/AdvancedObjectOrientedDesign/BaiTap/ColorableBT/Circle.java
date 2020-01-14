package AdvancedObjectOrientedDesign.BaiTap.ColorableBT;

public class Circle {
    private double radius = 1.0;

    public Circle() {

    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return this.radius*this.radius*Math.PI;
    }
}
