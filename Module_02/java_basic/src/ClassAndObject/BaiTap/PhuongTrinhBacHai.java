package ClassAndObject.BaiTap;

public class PhuongTrinhBacHai {

    public static void main(String[] args) {
        QuadraticEquation quadraticEquation = new QuadraticEquation(1, -2, 1);
        double delta = quadraticEquation.getDiscriminant();
        if (delta > 0) {
            double x1 = quadraticEquation.getRoot1();
            double x2 = quadraticEquation.getRoot2();
            System.out.println("Phương trình có hai nghiệm: \n" + x1 + "\n" + x2);
        }
        else if (delta == 0) {
            double x = (-quadraticEquation.getB() / (2 * quadraticEquation.getA()));
            System.out.println("phương trình có nghiệm duy nhất: " + x);
        }
        else {
            System.out.println("Phương trình vô nghiệm!!!");
        }
    }
}

class QuadraticEquation {
    private double a, b, c;


    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public QuadraticEquation() {

    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getDiscriminant() {
        return (this.b * this.b - 4 * this.a * this.c);
    }

    public double getRoot1() {
        return (-this.b + Math.sqrt((this.b * this.b - 4 * this.a * this.c))) / (2 * this.a);
    }

    public double getRoot2() {
        return (-this.b - Math.sqrt((this.b * this.b - 4 * this.a * this.c))) / (2 * this.a);
    }
}
