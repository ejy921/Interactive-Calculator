package MP2;

import java.io.PrintWriter;
import java.math.BigInteger;
import javax.swing.plaf.basic.BasicBorders.SplitPaneBorder;
import java.lang.String;
import java.lang.Integer;

/*
 * @author: Jinny Eo
 * 
 * Reads from the command line argument a series of strings that contain either expressions to
 * evaluate or command to store a variable. Prints out the result of each computation. Error checks
 * for invalid registers and expressions (through use of BFCalculator).
 */

public class QuickCalculator {
  /** The numerator of the fraction. Must be non-negative. */
  BigInteger num;

  /** The denominator of the fraction. Must be non-negative. */
  BigInteger denom;

  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    BFCalculator calculator = new BFCalculator();

    // loops through each expression in args array
    for (int i = 0; i < args.length; i++) {
      String str = args[i];
      // check if there is a STORE command in expression
      if (str.length() >= 5 && str.substring(0, 5).equals("STORE")) {
        char register = str.charAt(6);
        calculator.store(register);
      } else {
        // split each expression into different terms
        String[] splitStr = str.split(" ");
        for (int j = 0; j < splitStr.length; j++) {
          char register = splitStr[j].charAt(0);
          // if there exists register in expression, retrieve stored value
          if (Character.isLetter(register)) {

            if (splitStr[j].length() == 1) {
              BigFraction storedValue = calculator.getStoreVal(register);
              splitStr[j] = storedValue.toString();
            }
            // if user tries to retrive invalid register
            else {
              System.err.println("Invalid register; should be a singular lowercase character");
              System.exit(2);
            } // if it's a char of length 1

          } // if element in arr is char
        } // for

        str = String.join(" ", splitStr);
        // evaluates string that has replaced register with stored value
        BigFraction evaluation = calculator.evaluate(str);
        pen.println(evaluation);
      } // unless there isn't a STORE
    } // for

  } // main
}
