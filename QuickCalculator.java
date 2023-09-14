package CSC207.Git.MP2;

import java.io.PrintWriter; 

public class QuickCalculator {
  
  public static void main (String[] args) {

    PrintWriter pen = new PrintWriter(System.out, true);
    // String[] inputArr = exp.split(" ");

    for (int i = 0; i < args.length; i++) {
      pen.println(args[i]);

    }
  }
}
