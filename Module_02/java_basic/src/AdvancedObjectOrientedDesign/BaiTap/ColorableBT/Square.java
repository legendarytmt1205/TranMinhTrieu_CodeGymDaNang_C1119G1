package AdvancedObjectOrientedDesign.BaiTap.ColorableBT;

public class Square implements Colorable{

    private double side = 1.0;

    public Square() {

    }
    public Square(double side) {
        this.side = side;
    }

    double getArea() {
        return this.side * this.side;
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides");
    }
}
