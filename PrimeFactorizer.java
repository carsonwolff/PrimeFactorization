import java.util.Scanner;
import java.util.ArrayList;
/**
 * @author Carson Wolff
 * @version 1.0
 */
public class PrimeFactorizer {
    private long num;
    private ArrayList<Long> factors;
    public PrimeFactorizer(long n){
        this.num = n;
        this.factors = new ArrayList<>(1);
        factors.add(1L);
    }
    public void factorize(long n, ArrayList<Long> primesTo){
        System.out.println("Finding prime factors of " + n);
        if(n == 1){
            return;
        }
        for (long prime: primesTo) {
            if(prime > Math.sqrt(n)){
                factors.add(n);
                break;
            }
            if(n % prime == 0){
                System.out.println(prime);
                factors.add(prime);
                n /= prime;
                factorize(n,primesTo);
                break;
            }
        }
    }
    public static long getNumFromUser(){
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter a number to find primes factors for: ");
        long n = in.nextLong();
        if (n < 2) {
            System.out.println("Please enter a number greater than 1");
            n = getNumFromUser();
        }
        in.close();
        return n;
    }
    public void printPrimes(){
        System.out.println("Printing prime factors of " + num);
        factors.add(num);
        for(long prime: factors){
            System.out.printf("%d ", prime);
        }
    }
    public static void main(String[] args) {
        long n = getNumFromUser();
        long m = (long) Math.sqrt(n);
        PrimeFactorizer factor = new PrimeFactorizer(n);
        PrimeGenerator generate = new PrimeGenerator(m);
        generate.generate();
        ArrayList<Long> primesToSqrtN = generate.getPrimes();
        factor.factorize(n,primesToSqrtN);
        factor.printPrimes();
    }
}
