public class QuadraticEquation {
  private static void printUsage(boolean printHeader) {
    if(printHeader) System.out.println("QuadraticEquation - calculate roots of quadratic equation (a*x^2+b*x+c)");
    System.out.println(
    "usage: java QuadraticEquation <a> <b> <c>");
    System.out.println(
    "\ta (double) - a part of equation");
    System.out.println(
    "\tb (double) - b part of equation");
    System.out.println(
    "\tc (double) - c part of equation");
  }

  public static void main(String[] args) {
    Equation eq;
    double a,b,c;
    if(args.length == 0) {
      printUsage(true);
      return;
    }
    if(args.length < 3) {
      System.out.println("error: too few arguments - all a, b and c are required");
      printUsage(false);
      return;
    } else if(args.length > 3) {
      System.out.println("error: too much arguments - only a, b and c are mandatory");
      printUsage(false);
      return;
    }

    try {
      a = Double.parseDouble(args[0]);
      b = Double.parseDouble(args[1]);
      c = Double.parseDouble(args[2]);
    } catch(NumberFormatException nfe) {
      System.out.println("error: NumberFormatException caught while processing user input (most likely non-number was given as an argument) - "+nfe.getMessage());
      return;
    }
    System.out.println("Calculating...");
    eq.calculate(a,b,c);
    System.out.print("Equation was ");
    if(eq.get)
  }
}
