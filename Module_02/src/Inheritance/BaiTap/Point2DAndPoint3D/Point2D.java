package Inheritance.BaiTap.Point2DAndPoint3D;

import javax.swing.*;
import java.util.Arrays;

public class Point2D {
    private float x = 0.0f;
    private float y = 0.0f;

    public Point2D() {
    }

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float[] getXY() {
        float[] arr = new float[2];
        arr[0] = this.x;
        arr[1] = this.y;
        return arr;
    }

    @Override
    public String toString() {
        String str = "(";
        for (float item : this.getXY()) {
            str += item + ",";
        }
        str = str.substring(0, str.length() - 1);
        str += ")";
        return str;
    }
}

