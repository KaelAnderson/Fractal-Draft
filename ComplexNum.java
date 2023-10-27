package com.example.newfractaldraft;

public class ComplexNum {
    double realComponent;
    double imaginaryComponent;

    //constructor for my complex number object?
    public ComplexNum(double realComponent0, double imaginaryComponent0)
    {
        realComponent = realComponent0;
        imaginaryComponent = imaginaryComponent0;
    }

    //ill probably need getters and setters for both components
    public double getRealComponent()
    {
        return realComponent;
    }

    public double getImaginaryComponent()
    {
        return imaginaryComponent;
    }

    public void setRealComponent(double realComponent1)
    {
        realComponent = realComponent1;
    }

    public void setImaginaryComponent(double imaginaryComponent1)
    {
        imaginaryComponent = imaginaryComponent1;
    }

    //i need a method to sqaure my complex numbers as well as add them for checking if they are in certain sets
    //(a+bi)^2 = (a^2+bi^2,2abi)
    public ComplexNum square()
    {
        return new ComplexNum(realComponent*realComponent - imaginaryComponent*imaginaryComponent,
                2*realComponent*imaginaryComponent);
    }


    public ComplexNum add(ComplexNum c1)
    {
        return new ComplexNum(realComponent+ c1.realComponent, imaginaryComponent
                + c1.imaginaryComponent);
    }

    //to check the square magnitude of a com num
    public double zMagnitude()
    {
        return Math.sqrt(realComponent*realComponent + imaginaryComponent*imaginaryComponent);
    }

}
