/*
  Rewrite the fib method in Listing 18.2 using iterations.
*/

public class E18_02 {
  public static void main(String[] args) {
    System.out.println(fib(15));
  }

  public static long fib(long index) {
    long f0 = 0;
    long f1 = 1;
    long currentFib = 1;
    for (long i = 0; i < index; i++) {
      currentFib = f0 + f1;
      f0 = f1;
      f1 = currentFib;
    }
    return currentFib;
  }
}
