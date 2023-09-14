package CSC207.Git.MP2;

import java.io.PrintWriter; 
import java.util.Scanner;

public class InteractiveCalculator {
  
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    Scanner object = new Scanner(System.in);
    String input = object.nextLine();

    while (!input.equals("QUIT")) {
      BFCalculator calculator = new BFCalculator();
      BigFraction evaluation = calculator.evaluate(input);
      pen.println(evaluation);
      input = object.nextLine();
    }

  }
}
