package AdvancedObjectOrientedDesign.BaiTap.ColorableBT;

public class Rectangle {
    private double width = 1.0;
    private double length = 1.0;

    public Rectangle() {

    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public double getArea() {
        return width * this.length;
    }
}
