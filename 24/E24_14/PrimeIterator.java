import java.util.Iterator;
import java.util.ArrayList;

public class PrimeIterator implements Iterator<Long> {
  private long limit;
  private long candidate;
  private ArrayList<Long> primes;

  public PrimeIterator(long limit) {
    this.limit = limit;
    candidate = 2L;
    primes = new ArrayList<>();
  }

  @Override
  public boolean hasNext() {
    while (!isPrime(candidate)) {
      candidate++;
    }
    return candidate <= limit;
  }

  @Override
  public Long next() {
    primes.add(candidate);
    return new Long(candidate++);
  }

  private boolean isPrime(long n) {
    if (n == 2) { return true; }
    if (n % 2 == 0) { return false; }
    for (int i = 0; primes.get(i) <= Math.sqrt(n); i++) {
      if (n % primes.get(i) == 0) { return false; }
    }
    return true;
  }
}
