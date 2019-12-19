package com.example.interfacetest;

public class Rectangle implements AreaInterface{
    double x,y;
    public Rectangle(double a,double b){
        x=a;
        y=b;
    }
    public double area()//实现接口中的抽象方法，求长方形面积
    {
        return x*y;
    }
    public String toString()
    {
        return "长方形：x="+x+";y="+y+"\t";
    }
}
