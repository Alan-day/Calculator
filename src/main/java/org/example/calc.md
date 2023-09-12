# Post Course – Java Project - task overview and documentation

### Overview

Using your knowledge of Java, and the importance of testing your code, we would like you to build (and test!) a calculator in Java.

  _____________________
|  _________________  |
| |                 | |
| |  7  8  9  +     | |
| |  4  5  6  -     | |
| |  1  2  3  *     | |
| |  0  .  =  /     | |
| |_________________| |
|  _________________  |
| |                 | |
| |                 | |
| |_________________| |
|_____________________|



### Goals

- Tested Application: All features should be tested, and these tests should be written
  before the code.
- A DRY application: Whilst you have built a calculator before in JS, this is your chance to build one “properly and efficiently”. Pay particular attention to code that is being repeated and could be made into a method to ensure this application is as tight as possible.

### Specifications

The calculator should use a Scanner to take input from the user, and perform the following operations…

- Addition, subtraction, multiplication & division
- Chained operations (e.g. 5 + 17 \* 3)
- Numbers squared and square rooted
- Ability to handle negative numbers
- Ability to handle decimal numbers

### Documentation

- Calculator class constists of all methods required to perform calculations listed in the specification. Decimal numbers are expressed in floats and due to using Math library squareroot and root are have double data type. It's quite 
- irrelevant for the process of calculation as it constantly alternates between numerical and non-numerical data so a double can become a float and vice versa. All input has to have spaces between operators so 2+2 will throw 
- an error as there are no spaces in between operands.
- 
- ---> 2 + 2 correct
- ---> 2+2 incorrect 

-Application of regular expression for automated spacing didn't work as intended, so I got rid of it. 

-Calculator operates by taking input values and chaining calculations until user presses 'n' where the final result is shown again (result is shown after every calculation). 

-BIDMAS is applied by executing functions according to the order of performing equations so roots, square roots and then division/multiplication and subtraction/addition at the end. 
-eg. 12 + 3 - 4 ^ / 5 * 5
     12 + 3 - 2 root, division, multiplication
     12, +, 3, -, 2.0 addition, subtraction
     13 result 



