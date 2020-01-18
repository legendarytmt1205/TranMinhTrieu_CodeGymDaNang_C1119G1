package AdvancedObjectOrientedDesign.BaiTap.InterfaceResizeable;

public class Main {
    public static void main(String[] args) {
        int x = (int) Math.floor(Math.random() * 10);
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(x);
        shapes[1] = new Rectangle(x, x);
        shapes[2] = new Square(x);

        //trước khi thay đổi
        for (Shape item : shapes) {
            System.out.println(item.toString());
        }
        //sau khi thay đổi
        for (Shape item : shapes) {
            item.resize(Math.random() * 100);
            System.out.println(item.toString());
        //(Math.random() * 100);
        }
    }
}
