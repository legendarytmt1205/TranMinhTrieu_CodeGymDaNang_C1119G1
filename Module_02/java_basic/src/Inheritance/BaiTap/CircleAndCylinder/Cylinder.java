package Inheritance.BaiTap.CircleAndCylinder;

public class Cylinder extends Circle {
    private double height;

    public Cylinder() {
        super();
    }

    public Cylinder(double height) {
        this.height = height;
    }

    public Cylinder(String color, double radius, double height) {
        super(color, radius);
        this.height = height;
    }

    public Cylinder(String color) {
        super.getColor();
    }

    public Cylinder(String color,double height) {
        super.getColor();
        this.getHeight();
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public  double getVolume() {
        return (this.height*super.getAcreage());
    }

    @Override
    public String toString() {
        return "A Cylinder with color of\n "
                + getColor()
                + " and radius \n"
                + getRadius()
                + "and volume \n" + getVolume();
    }
}
