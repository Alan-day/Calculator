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


    public static void calculate() {


        Calculator calculator = new Calculator();

        Scanner scanner = new Scanner(System.in);


        String userCommand = " ";

        while(true) {

            ArrayList<String> arrayOfStrings = new ArrayList<>(); // main calculation space
            Float lastResult = calculator.getResult(); // for the second loop add result to the array to chain it with the oncoming calculations
            if(lastResult != 0.0){
                arrayOfStrings.add(String.valueOf(lastResult));
            }

            String userInput = scanner.nextLine();

            String stringArray[] = userInput.split(" ");





            for (int i = 0; i < stringArray.length; i++) {
                arrayOfStrings.add(stringArray[i]);

            }

            // How the calculator works by executing for loops one by one
            // 12 + 12 - 2 * 5 multiplication
            // 12 + 12 - 10 addition
            // 24 + 10 subtraction
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
                            result = calculator.multiply(firstNumber, secondNumber);
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
                            result = calculator.subtract(firstNumber, secondNumber);
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
            calculator.setResult(Float.parseFloat(arrayOfStrings.get(0)));

            System.out.println("Result: " + calculator.result);
            System.out.println("Do you wish to continue with your calculations?");
            System.out.println("(Y)es");
            System.out.println("(N)o");

            userCommand =scanner.nextLine();

            if (userCommand.equalsIgnoreCase("Yes") || userCommand.equalsIgnoreCase("y")) {
                System.out.println("Enter your calculation");
                System.out.println("Current result: " + calculator.getResult());

            } else if (userCommand.equalsIgnoreCase("No") || userCommand.equalsIgnoreCase("n")) {
                calculator.setResult(lastResult);
                System.out.println("Final result: " + calculator.getResult());
                break;
            } else {
                System.out.println("Invalid input");
            }
        }
    }
}