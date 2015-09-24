package com.handsomezhou.multiplelistitem.model;

public class Circle extends Shape {
    private double mRadius;
    
    
    public Circle() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    public Circle(double radius) {
        super();
        mRadius = radius;
    }

    @Override
    public double getArea() {
       
        return (Math.PI*mRadius*mRadius);
    }

    @Override
    public double getPerimeter() {
       
        return (2*Math.PI*mRadius);
    }

    public double getRadius() {
        return mRadius;
    }

    public void setRadius(double radius) {
        mRadius = radius;
    }
}
