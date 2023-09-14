package CSC207.Git.MP2;
import java.math.BigInteger;
import java.lang.String;
import java.lang.Integer;

 /*
  * To do left:
    - cite website for euclide's method (repeated subtraction approach)
    - treat when there are negative numbers
    - change BigFraction to BigFraction when pasting to this document
  */
 
 public class BigFraction {
  // +--------+-------------------------------------------------------
  // | Fields |
  // +--------+

  /** The numerator of the fraction. Can be positive, zero or negative. */
  BigInteger num;

  /** The denominator of the fraction. Must be non-negative. */
  BigInteger denom;

  // +--------------+-------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new fraction with numerator num and denominator denom.
   * 
   * Warning! Not yet stable.
   */
  public BigFraction(BigInteger num, BigInteger denom) {
    this.num = num;
    this.denom = denom;
  } // BigFraction(BigInteger, BigInteger)

  /**
   * Build a new fraction with numerator num and denominator denom.
   * 
   * Warning! Not yet stable.
   */
  public BigFraction(int num, int denom) {
    this.num = BigInteger.valueOf(num);
    this.denom = BigInteger.valueOf(denom);
  } // BigFraction(int, int)

  /**
   * Build a new fraction by parsing a string.
   *
   * Warning! Not yet implemented.
   *//* */
  public BigFraction(String str) {
    int i = str.indexOf("/");
    if (i >= 0) {
      String numStr = str.substring(0, i);
      int num = Integer.parseInt(numStr);
      String denomStr = str.substring(i+1, str.length());
      int denom = Integer.parseInt(denomStr);
  
      this.num = BigInteger.valueOf(num);
      this.denom = BigInteger.valueOf(denom);
    }
    else {
      int num = Integer.parseInt(str);
      this.num = BigInteger.valueOf(num);
      this.denom = BigInteger.ONE;
    }

  } // BigFraction */

  

  // +---------+------------------------------------------------------
  // | Methods |
  // +---------+


    /**
   * Get the denominator of this fraction.
   */
  public BigInteger denominator() {
    return this.denom;
  } // denominator()
  
  /**
   * Get the numerator of this fraction.
   */
  public BigInteger numerator() {
    return this.num;
  } // numerator()


  /**
   * Express this fraction as a double.
   */
  public double doubleValue() {
    return this.num.doubleValue() / this.denom.doubleValue();
  } // doubleValue()

  /**
   * Add the fraction `addMe` to this fraction.
   */
  public BigFraction add(BigFraction addMe) {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    // The denominator of the result is the
    // product of this object's denominator
    // and addMe's denominator
    resultDenominator = this.denom.multiply(addMe.denom);
    // The numerator is more complicated
    resultNumerator = (this.num.multiply(addMe.denom)).add(addMe.num.multiply(this.denom));

    // Return the computed value
    return new BigFraction(resultNumerator, resultDenominator);
  }// add(BigFraction)

  /*
   * Subtract subtractMe to this.fraction
   */
  public BigFraction subtract(BigFraction subtractMe) {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    // The denominator of the result is the
    // product of this object's denominator
    // and addMe's denominator
    resultDenominator = this.denom.multiply(subtractMe.denom);
    // The numerator is more complicated
    resultNumerator = (this.num.multiply(subtractMe.denom)).subtract(subtractMe.num.multiply(this.denom));

    // Return the computed value
    return new BigFraction(resultNumerator, resultDenominator);
  }// add(BigFraction)


  /**
   * Multiply the fraction `multiplyMe` to this fraction.
   */
  public BigFraction multiply(BigFraction multiplyMe){

    BigInteger resultNum;
    BigInteger resultDenom;

    resultDenom = this.denom.multiply(multiplyMe.denom);
    resultNum = this.num.multiply(multiplyMe.num);

    return new BigFraction(resultNum, resultDenom);
  }// multiply(BigFraction)

    /**
   * Multiply the fraction `multiplyMe` to this fraction.
   */
  public BigFraction divide(BigFraction divideMe){

    BigInteger resultNum;
    BigInteger resultDenom;

    resultDenom = this.denom.divide(divideMe.denom);
    resultNum = this.num.divide(divideMe.num);

    return new BigFraction(resultNum, resultDenom);
  }// divide(BigFraction)



    /*
   * Implements Euclide's repeated subtraction method to find the hcf of
   * two numbers (in this case, the numerator and the denominator are being passed 
   * down as the two numbers so that they can be divided by the hcf)
   */
  public BigInteger hcf(BigInteger bigger, BigInteger smaller) {

    if (smaller.equals(bigger)) {
      return bigger;
    }
    else {
      return hcf(smaller, bigger.subtract(smaller).abs());
    }

  }// hcf(BigInteger, BigInteger)


  public BigInteger containHcf() {
      BigInteger bigger;
      BigInteger smaller;
      BigInteger hcf;
      if (this.num.compareTo(this.denom) ==  1) {
        bigger = this.num;
        smaller = this.denom;
      }
      else {
        smaller = this.num;
        bigger = this.denom;
      }
        
      hcf = hcf(bigger, smaller);
      return hcf;
  }


  public BigFraction simplify() {

    BigFraction resultFraction = null;
    // cite the website for euclide's method

    if (this.num == this.denom) {
      resultFraction = new BigFraction(BigInteger.ONE, BigInteger.ONE);
    }
    // if the denominator is 0, invalid fraction
    else if (this.denom.equals(BigInteger.ZERO)) {
      System.err.println("Invalid fraction");
      System.exit(1);
    }
    else {
      BigInteger hcf = containHcf();
      BigFraction hcfFraction = new BigFraction(hcf, hcf);
      // divide num and denom by hcf
      resultFraction = divide(hcfFraction); 
    }

    return resultFraction;
  }// simplify(BigFraction)


  /**
   * Convert this fraction to a string for ease of printing.
   */
  public String toString() {
    // Special case: It's zero
    if (this.num.equals(BigInteger.ZERO)) {
      return "0";
    } // if it's zero

    // Lump together the string represen  tion of the numerator,
    // a slash, and the string representation of the denominator
    // return this.num.toString().concat("/").concat(this.denom.toString());
    if (this.denom.equals(BigInteger.ONE)) {
      return String.valueOf(this.num);
    }
    else {
    return this.num + "/" + this.denom;
    }
  } // toString()

  /*
   * Return the fractional part of a fraction, whether it be a proper or 
   * improper fraction
   */
  public BigFraction fractional(){
    BigInteger resultNum;
    BigInteger resultDenom;

    resultNum = this.num.mod(this.denom);
    resultDenom = this.denom;

    return new BigFraction(resultNum, resultDenom);
  }// fractional()

 }