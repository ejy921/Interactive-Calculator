package MP2;

import java.io.PrintWriter;
import java.util.Scanner;

/*
 * @author: Jinny Eo
 * 
 * Continuously receives user input of expressions and prints out answer each time. User has choice
 * to store a variable to a character. Quits when the user inputs "QUIT". Checks for invalid
 * commands, such as when the user attempts to save or retrieve an invalid variable, as well as
 * invalid expressions (through use of BFCalculator).
 */

public class InteractiveCalculator {

  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);

    // print introductory message
    pen.println("Type in expressions to evaluate:\n");


    // user Scanner library to read user input
    Scanner object = new Scanner(System.in);
    String input = object.nextLine();
    // initialize calculator from BFCalculator class
    BFCalculator calculator = new BFCalculator();

    // quits when user inputs "QUIT"
    while (!input.equals("QUIT")) {
      // checks whether user wants to store a variable
      if (input.length() >= 5 && input.substring(0, 5).equals("STORE")) {
        char register = input.charAt(6);
        // if user tries to save an invalid register
        if (input.length() > 7) {
          System.err.println("Invalid register; should be a singular lowercase character");
          System.exit(2);
        } else {
          calculator.store(register);
        } // if
      } // if user tries to Store register

      else {
        // split array to different terms of the expression
        String[] splitArr = input.split(" ");
        for (int i = 0; i < splitArr.length; i++) {
          char register = splitArr[i].charAt(0);
          // if user involves a stored register in their expression, retrieves stored value
          if (Character.isLetter(register)) {
            if (splitArr[i].length() == 1) {
              BigFraction storedValue = calculator.getStoreVal(register);
              // if the register doesn't have a stored value, system exit
              if (storedValue == null) {
                System.exit(2);
              }
              splitArr[i] = storedValue.toString();
            } else {
              // User tries to compute with an invalid register
              System.err.println("Invalid register; should be a singular lowercase character");
              System.exit(2);
            } // if
          } // if
        } // for

        input = String.join(" ", splitArr);
        // evaluate the string which replaces the register with the stored value
        BigFraction evaluation = calculator.evaluate(input);
        pen.println(evaluation);
      } // if
      // inputs every time within the while loop
      input = object.nextLine();
    }

  }
}
