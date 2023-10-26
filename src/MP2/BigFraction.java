package MP2;
import java.math.BigInteger;
import java.lang.String;
import java.lang.Integer;

  /*
 * @author: Jinny Eo
 * 
 * Contains constructors for the BigFraction that is made from two BigIntegers
 * for numerator and denominator (which both are declared as fields in the class). 
 * Has methods for getting numerator and denominator; adding, subtracting, 
 * multiplying, dividing, simplifying BigFractions; converting BigFraction to String; 
 * returning the fractional part of a fraction. 
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

    resultDenom = this.denom.multiply(divideMe.num);
    resultNum = this.num.multiply(divideMe.denom);

    return new BigFraction(resultNum, resultDenom);
  }// divide(BigFraction)



    /*
   * Implements Euclide's repeated subtraction method to find the hcf of
   * two numbers (in this case, the numerator and the denominator are being passed 
   * down as the two numbers so that they can be divided by the hcf)
   */
  public BigInteger hcf(BigInteger bigger, BigInteger smaller) {
    // hcf found
    if (smaller.equals(bigger)) {
      return bigger;
    }
    // use recursion with the smaller and bigger - smaller value 
    else {
      return hcf(smaller, bigger.subtract(smaller).abs());
    }

  }// hcf(BigInteger, BigInteger)

/*
 * Function to prepare and call for containHcf();  initializes necessary values and 
 * assigns values to proper variables
 */
  public BigInteger containHcf() {
      BigInteger bigger;
      BigInteger smaller;
      BigInteger hcf;
      // if the numerator is greater than the denominator, assing numerator to the 'bigger' var
      if (this.num.compareTo(this.denom) ==  1) {
        bigger = this.num;
        smaller = this.denom;
      }
      else {
        smaller = this.num;
        bigger = this.denom;
      }
      // call hcf
      hcf = hcf(bigger, smaller);
      return hcf;
  }

/*
 * Simplifys this BigFraction by finding the hcf. Checks for special cases.
 */
  public BigFraction simplify() {
    BigInteger resultNum = null;
    BigInteger resultDenom = null;
    // if the numerator and denominator are equal, then fraction is 1/1
    if (this.num == this.denom) {
      resultNum = BigInteger.ONE;
      resultDenom = BigInteger.ONE;
    }
    // if the denominator is 0, invalid fraction
    else if (this.denom.equals(BigInteger.ZERO)) {
      System.err.println("Invalid fraction");
      System.exit(1);
    }
    else {
      // call containHcf(), which then calls hcf
      BigInteger hcf = containHcf();
      // divide num and denom by hcf to simplify
      resultNum = this.num.divide(hcf);
      resultDenom = this.denom.divide(hcf);
    }
    // return the simplified BigFraction
    return new BigFraction(resultNum, resultDenom);
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
    // find the remainder to place in numerator of fraction
    resultNum = this.num.mod(this.denom);
    resultDenom = this.denom;
    // return the fractional BigFraction
    return new BigFraction(resultNum, resultDenom);
  }// fractional()

 }
