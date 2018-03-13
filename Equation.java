/**
 * Equation is class that calculates roots of quadratic equation (a*x^2+b*x+c) by given a, b, c
 * @author Sebastian Madejski
 */
public class Equation {
  /**
   * State of the ART (art = equation after attempt of calculation)
   */
  public enum EquationState {
    NOT_CALCULATED, UNABLE_TO_CALC, ONE_ROOT, TWO_ROOTS
  }

  private double a;     // "a" part of equation
  private double b;     // "b" part of equation
  private double c;     // "c" part of equation
  private double delta; // delta calculated from equation
  private double root1; // first root from equation
  private double root2; // second root from equation
  private EquationState state; // state after calculating the equation
  private String detailedError; // detailed error

  /**
   * constructor for class Equation
   */
  public Equation() {
    a = 0;
    b = 0;
    c = 0;
    delta = 0;
    root1 = 0;
    root2 = 0;
    state = EquationState.NOT_CALCULATED;
  }

  /**
   * Calculate the equation by given parameters (a, b ,c)
   * @param newA "a" parameter of equation
   * @param newB "b" parameter of equation
   * @param newC "c" parameter of equation
   * @return state whether equation was calculated (true = success, false = failure)
   */
  public boolean calculate(double newA, double newB, double newC) {
    setA(newA);
    setB(newB);
    setC(newC);
    return calculate();
  }

  /**
   * Calculate the equation by given set at runtime.
   * @return state whether equation was calculated (true = success, false = failure)
   */
  public boolean calculate() {
    if(a == 0.0) {
      state = EquationState.NOT_CALCULATED;
      detailedError = "a = 0, formula not appliable";
      return false;
    }
    delta = (b*b) - 4.0*a*c;
    if(delta > 0.0) {
      root1 = ((-b)-Math.sqrt(delta))/(2.0*a);
      root2 = ((-b)+Math.sqrt(delta))/(2.0*a);
      state = EquationState.TWO_ROOTS;
      return true;
    } else if(delta == 0.0) {
      root1 = -b/(2.0*a);
      state = EquationState.ONE_ROOT;
      return true;
    } else {
      state = EquationState.UNABLE_TO_CALC;
      return false;
    }
  }

  /**
   * Return last error occured during calculation.
   * @return string with detailed error
   */
  public String getDetailedError() {
    return detailedError;
  }

  public EquationState getState() {
    return state;
  }

  public double getFirstRoot() {
    return root1;
  }

  public double getSecondRoot() {
    return root2;
  }

  public void setA(double newA) {
    a = newA;
  }

  public void setB(double newB) {
    b = newB;
  }

  public void setC(double newC) {
    c = newC;
  }

  public double getA() {
    return a;
  }

  public double getB() {
    return b;
  }

  public double getC() {
    return c;
  }

  public String toString() {
	String output = Double.toString(getA());
	output += "*x^2";
	if(getB() != 0.0) {
		if(getB() > 0.0) output += " + ";
		output += Double.toString(getB()) + "*x";
	}
	if(getC() != 0.0) {
		if(getC() > 0.0) output += " + ";
		output += getC();
	}
	return output;
  }
}
