package org.example;

import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;
public class Calculator {
    float result;
    public float getResult() {
        return result;
    }

    public void setResult(float result) {
        this.result = result;
    }

    public float add(float x, float y){
        return x + y;
    }
    public float subtract(float x, float y){
        return x - y;
    }
    public float multiply(float x, float y){
        return x * y;
    }
    public float divide(float x, float y){
        return x/y;
    }
    public double squareroot(float x){
        return Math.sqrt(x);
    }




    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();


        String stringArray []  = string.split(" ");
        ArrayList <Float> floatList = new ArrayList<>();

        for (int i = 0; i < stringArray.length; i++) {
          String currentValue = stringArray[i];
            if(currentValue.equals("*")){
                float firstNumber =Float.parseFloat(stringArray[i-1]);
                float secondNumber =Float.parseFloat(stringArray[i+1]);
                System.out.println(calculator.multiply(firstNumber, secondNumber));

            }

        }








    }



}
