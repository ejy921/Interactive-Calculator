package CSC207.Git.MP2;

public class BFCalculator {
    // +---------+------------------------------------------------------
  // | Methods |
  // +---------+\
  
  public BigFraction evaluate(String exp) {

    String[] expArr = exp.split(" ");
    BigFraction[] array = new BigFraction[expArr.length];

    String operator = null;

    // change every number in array into a BigFraction
    for (int a = 0; a < array.length; a+= 2) {
      array[a] = new BigFraction(expArr[a]);
    }

    BigFraction leftVal = array[0];
    BigFraction rightVal = null;

    for (int i = 1; i < array.length; i+= 2) {
      operator = expArr[i];
      rightVal = array[i + 1];

      if (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/")) {

        if (operator.equals("+")) {
          leftVal = leftVal.add(rightVal);
        }
        else if (operator.equals("-")) {
          leftVal = leftVal.subtract(rightVal);
        }
        else if (operator.equals("*")) {
          leftVal = leftVal.multiply(rightVal);
        }
        else if (operator.equals("/")) {
          leftVal = leftVal.divide(rightVal);
        }
        else {
          System.err.println("Invalid expression");
          System.exit(2);
        }
      }
     
    } 

    return leftVal;
  }

  /* 
  public void store(char register) {
    char variable = register;

  }
  */
 
}
