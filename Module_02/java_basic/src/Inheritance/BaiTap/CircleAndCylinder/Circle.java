package Inheritance.BaiTap.CircleAndCylinder;

public class Circle {
    private String color;
    private double radius;

    public Circle() {
        System.out.println("hello");
    }

    public Circle(String color, double radius) {
        this.color = color;
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getAcreage() {
        return Math.PI*this.radius*this.radius;
    }

    @Override
    public String toString() {
        return "A Circle with color of\n "
                + getColor()
                + "and radius \n"
                + getRadius();
    }
}
