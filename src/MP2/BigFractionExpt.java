package MP2;

import java.io.PrintWriter;

/*
 * @author: Jinny Eo
 * 
 * Series of function calls involving BFCalculator and BigFractions.
 */

public class BigFractionExpt {
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);

    // BigFraction simplify
    BigFraction f1 = new BigFraction(7, 12);
    // print
    pen.println(f1 + " simplified: " + f1.simplify());

    // BigFraction evaluate expression
    BFCalculator calculator = new BFCalculator();
    BigFraction evaluation = calculator.evaluate("1/2 + 1/2 * 4");
    // print
    pen.println(evaluation.simplify());

  }

}

