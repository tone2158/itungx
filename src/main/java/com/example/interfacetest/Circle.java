package com.example.interfacetest;

public class Circle implements AreaInterface{
    double r;
    public Circle(double x){
        r = x;
    }
 
    //实现接口中的抽象方法，求圆面积
    public double area(){
        return pai*r*r;
    }
    public String toString(){
        return"圆：r="+r+"\tarea="+area();
    }
}