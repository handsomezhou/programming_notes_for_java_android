package com.handsomezhou.multiplelistitem.model;



public class Triangle extends Shape {
    //http://www.cut-the-knot.org/pythagoras/herons.shtml
    //L = a + b + c(The three sides:a,b,c) 
    //S = ¡Ì[p(p - a)(p - b)(p - c)]£¬p = (1/2)(a + b + c)
    private double mFirstSide;
    private double mSecondSide;
    private double mThirdSide;
    private double p;
    
     
    public Triangle(double firstSide, double secondSide, double thirdSide) {
        super();
        mFirstSide = firstSide;
        mSecondSide = secondSide;
        mThirdSide = thirdSide;
        boolean triangle=isTriangle(firstSide, secondSide, thirdSide);
        assert(true==triangle);
        p = (mFirstSide + mSecondSide + mThirdSide)/2;
    }

    @Override
    public double getArea() {
        
        return (Math.sqrt(p*(p-mFirstSide)*(p-mSecondSide)*(p-mThirdSide)));
    }

    @Override
    public double getPerimeter() {
        
        return (mFirstSide+mSecondSide+mThirdSide);
    }

    public double getFirstSide() {
        return mFirstSide;
    }

    public void setFirstSide(double firstSide) {
        mFirstSide = firstSide;
    }

    public double getSecondSide() {
        return mSecondSide;
    }

    public void setSecondSide(double secondSide) {
        mSecondSide = secondSide;
    }

    public double getThirdSide() {
        return mThirdSide;
    }

    public void setThirdSide(double thirdSide) {
        mThirdSide = thirdSide;
    }
    
  
    public boolean isTriangle(double firstSide, double secondSide, double thirdSide){
        boolean triangle=false;
        
        do{
            if(firstSide<0||secondSide<0||thirdSide<0){
                break;
            }
            
            if(((firstSide+secondSide)>thirdSide)&&((secondSide+thirdSide)>firstSide)&&((firstSide+thirdSide)>secondSide)){
                triangle=true;
                break;
            }
        }while(false);
        
        return triangle;
    }

}
