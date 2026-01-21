/*
  Define an iterator class named PrimeIterator for iterating prime numbers. The
  constructor takes an argument that specifies the limit of the maximum prime
  number. For example, new PrimeIterator(23302) creates an iterator that
  iterates prime numbers less than or equal to 23302. Write a test program that
  uses this iterator to display all prime numbers less than or equal to 100000.
*/

public class E24_14 {
  public static void main(String[] args) {
    PrimeIterator primeIterator = new PrimeIterator(100000);
    final int PRIMES_PER_LINE = 10;
    int count = 0;
    while (primeIterator.hasNext()) {
      if (count % PRIMES_PER_LINE == 0) { System.out.println(); }
      System.out.printf("%5d ", primeIterator.next());
      count++;
    }
    System.out.println();
  }
}
