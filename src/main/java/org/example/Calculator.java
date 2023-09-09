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
    } // caret ^ symbol

    public double toPower(float x, float y){
       double square = Math.pow((double) x, (double) y);
       return square;
    } // ** symbol


    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();


        String stringArray []  = string.split(" ");


        ArrayList <String> arrayOfStrings = new ArrayList<>();

        for (int i = 0; i < stringArray.length; i++) {
            arrayOfStrings.add(stringArray[i]);

        }





        // 12 + 12 - 2 * 5
        // 12 + 12 - 10
        // 24 + 10
        // 34

        for (int i = 0; i < arrayOfStrings.size(); i++) {
            String currentValue = arrayOfStrings.get(i);

                if (currentValue.equals("*")) {
                    float firstNumber = Float.parseFloat(stringArray[i - 1]);
                    float secondNumber = Float.parseFloat(stringArray[i + 1]);
                    float result = calculator.multiply(firstNumber, secondNumber);
                    String stringedFloat = Float.toString(result);
//                    arrayOfStrings.add(, stringedFloat);
                    arrayOfStrings.remove(stringArray[i - 1]);
                    arrayOfStrings.remove(stringArray[i + 1]);

                }
        }

        for (int i = 0; i < stringArray.length; i++) {
            String currentValue = stringArray[i];
            if (currentValue.equals("+")) {
                float firstNumber = Float.parseFloat(stringArray[i - 1]);
                float secondNumber = Float.parseFloat(stringArray[i + 1]);
                System.out.println(calculator.add(firstNumber, secondNumber));
                return;
            }

        }








    }



}
