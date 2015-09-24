package com.handsomezhou.multiplelistitem.model;

public class Rectangle extends Shape {
    private double mWidth;
    private double mHeight;

    
    public Rectangle() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Rectangle(double width, double height) {
        super();
        mWidth = width;
        mHeight = height;
    }

    @Override
    public double getArea() {
        
        return (mWidth*mHeight);
    }

    @Override
    public double getPerimeter() {
        
        return (2*(mWidth+mHeight));
    }

    public double getWidth() {
        return mWidth;
    }

    public void setWidth(double width) {
        mWidth = width;
    }

    public double getHeight() {
        return mHeight;
    }

    public void setHeight(double height) {
        mHeight = height;
    }
   
}
