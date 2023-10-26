package MP2;

/*
 * @author: Jinny Eo
 * 
 * Contains the evaluate(String exp) function, which takes in an expression as a String and
 * evaluates it as a BigFraction. Includes error checking for invalid expressions. Contains the
 * store(char register) function, which saves the last evaluated value into a variable and array
 * that is declared as a field in the class. The getStoreVal(char ch) helps to retrieve the saved
 * BigFractions in the fields from either classes in the package.
 */

public class BFCalculator {
  // +--------+-------------------------------------------------------
  // | Fields |
  // +--------+

  BigFraction storeVal;
  BigFraction[] storedArr = new BigFraction[26];


  // +---------+------------------------------------------------------
  // | Methods |
  // +---------+\

  /*
   * Evaluates a string that contains an expression. Handles errors, such as when user types in an
   * invalid expresion
   */
  public BigFraction evaluate(String exp) {

    String[] expArr = exp.split(" ");
    BigFraction[] array = new BigFraction[expArr.length];

    String operator = null;

    // change every number in array into a BigFraction
    for (int a = 0; a < expArr.length; a += 2) {
      // checks for whether user typed valid expression to evaluate
      if (Character.isDigit(expArr[a].charAt(0))
          && Character.isDigit(expArr[a].charAt(expArr[a].length() - 1))) {
        // if every term can be a BigFraction, turn into BigFraction
        array[a] = new BigFraction(expArr[a]);
      } else {
        System.err.println("Invalid expression");
        System.exit(2);
      } // if
    } // for
    // initialize leftVal & rightVal used to calculate
    BigFraction leftVal = array[0];
    BigFraction rightVal = null;
    // loops through every term of expression, including operators
    for (int i = 1; i < array.length; i += 2) {
      operator = expArr[i];
      rightVal = array[i + 1];
      // every time there is a calculation, saves to leftVal so that it becomes the new leftVal to
      // calculate
      // with the next rightVal
      if (operator.equals("+") || operator.equals("-") || operator.equals("*")
          || operator.equals("/")) {
        // adds
        if (operator.equals("+")) {
          leftVal = leftVal.add(rightVal);
        }
        // subtracts
        else if (operator.equals("-")) {
          leftVal = leftVal.subtract(rightVal);
        }
        // multiplies
        else if (operator.equals("*")) {
          leftVal = leftVal.multiply(rightVal);
        }
        // divides
        else if (operator.equals("/")) {
          leftVal = leftVal.divide(rightVal);
        } else {
          // else it is an invalid expression
          System.err.println("Invalid expression");
          System.exit(2);
        } // if
      } // if

    } // for
    // saves this value to a class field after simplifying
    this.storeVal = leftVal.simplify();
    // returns simplified BigFraction
    return leftVal.simplify();
  }

  /*
   * Stores the last calculated value to storedArr in a way so that the index aligns with the
   * character's position in the alphabet
   */
  public void store(char register) {
    // find the appropriate index to store the value in
    int indexVal = (int) register - 'a';
    storedArr[indexVal] = this.storeVal;

  }

  /*
   * Get the storeVal from storedArr
   */
  public BigFraction getStoreVal(char ch) {
    // rely on the algorithm used to determine which index for which value
    int indexVal = (int) ch - 'a';
    // if there is no value in the index that is searched, return error print
    if (this.storedArr[indexVal] == null) {
      System.err.println("Value not stored");
    } // if
    // otherwise return the stored value
    return this.storedArr[indexVal];
  }



}

