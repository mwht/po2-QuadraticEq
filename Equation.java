/**
 * Equation
 * @summary Equation is class that calculates roots of quadratic equation (a*x^2+b*x+c) by given a, b, c
 * @author Sebastian Madejski
 */
public class Equation {
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

  public Equation() {
    a = 0;
    b = 0;
    c = 0;
    delta = 0;
    root1 = 0;
    root2 = 0;
    state = EquationState.NOT_CALCULATED;
  }

  public boolean calculate(double newA, double newB, double newC) {
    setA(newA);
    setB(newB);
    setC(newC);
    return calculate();
  }

  public boolean calculate() {
    // calculate delta
    delta = (b*b) - 4*a*c;
    if(delta > 0.0) {
      root1 = (-b-delta)/(2*a);
      root2 = (-b-delta)/(2*a);
      state = EquationState.TWO_ROOTS;
      return true;
    } else if(delta == 0.0) {
      root1 = -b/(2*a);
      state = EquationState.ONE_ROOT;
      return true;
    } else {
      state = EquationState.UNABLE_TO_CALC;
      return false;
    }
  }

  public EquationState getState() {
    return state;
  }

  public void getFirstRoot() {
    return root1;
  }

  public void getSecondRoot() {
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
}
