# Mini-Project-2

SamR says that this can be late.

@author:Jinny Eo
Group Members: Jinny Eo

One Sentence Description: This repository contains classes that works with the type BigFraction that is constructed in the BigFraction class, while implementing that class for various calculations in BFCalculator, InteractiveCalculator, and QuickCalculator.

BigFraction.java: Contains constructors for the BigFraction that is made from two BigIntegers for numerator and denominator (which both are declared as fields in the class). Has methods for getting numerator and denominator; adding, subtracting, multiplying, dividing, simplifying BigFractions; converting BigFraction to String; returning the fractional part of a fraction. 

BFCalculator.java: Contains the evaluate(String exp) function, which takes in an expression as a String and evaluates it as a BigFraction. Includes error checking for invalid expressions. Contains the store(char register) function, which saves the last evaluated value into a variable and array that is declared as a field in the class. The getStoreVal(char ch) helps to retrieve the saved BigFractions in the fields from either classes in the package.

InteractiveCalculator.java: Continuously receives user input of expressions and prints out answer each time. User has choice to store a variable to a character. Quits when the user inputs "QUIT". Checks for invalid commands, such as when the user attempts to save or retrieve an invalid variable, as well as invalid expressions (through use of BFCalculator).

QuickCalculator.java: Reads from the command line argument a series of strings that contain either expressions to evaluate or command to store a variable. Prints out the result of each computation. Error checks for invalid registers and expressions (through use of BFCalculator).

Citations:
@GFGWRITEBOT (2022). Euclidean algorithms (Basic and Extended). GeeksforGeeks. Available at
  [https://www.geeksforgeeks.org/string-class-repeat-method-in-java-with-examples/](https://www.geeksforgeeks.org/euclidean-algorithms-basic-and-extended/)

  
