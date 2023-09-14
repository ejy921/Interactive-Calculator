package CSC207.Git.MP2;
import java.io.PrintWriter; 


public class BigFractionExpt {
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);

    // BigFraction simplify
    BigFraction f1 = new BigFraction(7, 12);
    pen.println(f1 + " simplified: " + f1.simplify());

    // BigFraction evaluate expression
    BFCalculator calculator = new BFCalculator();
    BigFraction evaluation = calculator.evaluate("1/2 + 1/2 * 4");
    pen.println(evaluation.simplify());

  }

}
