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

    public float add(float x, float y) {
        return x + y;
    }

    public float subtract(float x, float y) {
        return x - y;
    }

    public float multiply(float x, float y) {
        return x * y;
    }

    public float divide(float x, float y) {
        return x / y;
    }

    public double squareroot(double x) {
        return Math.sqrt(x);
    } // caret ^ symbol

    public double toPower(float x, float y) {
        double square = Math.pow((double) x, (double) y);
        return square;
    } // ** symbol


    public static void main(String[] args) {


        Calculator calculator = new Calculator();

        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();


        String stringArray[] = string.split(" ");


        ArrayList<String> arrayOfStrings = new ArrayList<>();

        for (int i = 0; i < stringArray.length; i++) {
            arrayOfStrings.add(stringArray[i]);

        }


        // 12 + 12 - 2 * 5
        // 12 + 12 - 10
        // 24 + 10
        // 34


        System.out.println(arrayOfStrings);
        for (int i = 0; i < arrayOfStrings.size(); i++) {
            String currentValue = arrayOfStrings.get(i);

            if (currentValue.equals("^")) {

                    double firstNumber = Double.parseDouble(arrayOfStrings.get(i - 1));

                    double result = calculator.squareroot(firstNumber);

                    // Update the result in the ArrayList and remove the used operands and operator
                    arrayOfStrings.set(i - 1, String.valueOf(result));
                    arrayOfStrings.remove(i);

                    i--; // Adjust the index after removing elements

            }
        }


        for (int i = 0; i < arrayOfStrings.size(); i++) {
            String currentValue = arrayOfStrings.get(i);

            if (currentValue.equals("**")) {
                if (i - 1 >= 0 && i + 1 < arrayOfStrings.size()) {
                    float firstNumber = Float.parseFloat(arrayOfStrings.get(i - 1));
                    float secondNumber = Float.parseFloat(arrayOfStrings.get(i + 1));
                    double result = calculator.toPower(firstNumber, secondNumber);

                    // Update the result in the ArrayList and remove the used operands and operator
                    arrayOfStrings.set(i - 1, String.valueOf(result));
                    arrayOfStrings.remove(i);
                    arrayOfStrings.remove(i);
                    i--;
                }
            }
        }
            for (int i = 0; i < arrayOfStrings.size(); i++) {
                String currentValue = arrayOfStrings.get(i);

                if (currentValue.equals("*") || currentValue.equals("/")) { // according to order of performing calculations multiplication and division as well as subtraction and addition can be performed interchangeably

                    if (i - 1 >= 0 && i + 1 < arrayOfStrings.size()) {
                        float result = 0;
                        float firstNumber = Float.parseFloat(arrayOfStrings.get(i - 1));
                        float secondNumber = Float.parseFloat(arrayOfStrings.get(i + 1));

                        if (currentValue.equals("*")) {
                            result = calculator.multiply(firstNumber,secondNumber);
                        } else if (currentValue.equals("/")) {
                            result = calculator.divide(firstNumber, secondNumber);
                        }

                        arrayOfStrings.set(i - 1, String.valueOf(result));
                        arrayOfStrings.remove(i);
                        arrayOfStrings.remove(i);
                        i--;
                    }
                }
            }


        System.out.println(arrayOfStrings);


        for (int i = 0; i < arrayOfStrings.size(); i++) {
            String currentValue = arrayOfStrings.get(i);

            if (currentValue.equals("+") || currentValue.equals("-")) {

                if (i - 1 >= 0 && i + 1 < arrayOfStrings.size()) {
                    float result = 0;
                    float firstNumber = Float.parseFloat(arrayOfStrings.get(i - 1));
                    float secondNumber = Float.parseFloat(arrayOfStrings.get(i + 1));

                    if (currentValue.equals("-")) {
                        result = calculator.subtract(firstNumber,secondNumber);
                    } else if (currentValue.equals("+")) {
                        result = calculator.add(firstNumber, secondNumber);
                    }

                    arrayOfStrings.set(i - 1, String.valueOf(result));
                    arrayOfStrings.remove(i);
                    arrayOfStrings.remove(i);
                    i--;
                }
            }
        }
        System.out.println(arrayOfStrings);


    }
}