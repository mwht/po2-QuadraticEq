public class QuadraticEquation {
  private static void printUsage() {
    System.out.println(
    "usage: java QuadraticEquation <a> <b> <c>");
    System.out.println(
    "\ta - a part of equation");
    System.out.println(
    "\tb - b part of equation");
    System.out.println(
    "\tc - c part of equation");
  }

  public static void main(String[] args) {
    if(args.length < 3) {
      System.out.println("error: too few arguments - all a, b and c are required");
      printUsage();
    } else if(args.length > 3) {
      System.out.println("error: too much arguments - only a, b and c are mandatory");
      printUsage();
    }
  }
}
