package AdvancedObjectOrientedDesign.BaiTap.InterfaceResizeable;

public abstract class Shape implements Resizeable{
    private boolean filled = true;

    public  Shape() {

    }

    public Shape(boolean filled) {
        this.filled = filled;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }
}
