import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Carson Wolff
 * @version 1.0
 * Thank you for checking out my code!
 */
public class PrimeGenerator {
    private long num;
    private ArrayList<Long> primes;
    public PrimeGenerator(long n){
        this.num = n;
        this.primes = new ArrayList<>();
        primes.add(2L);
        primes.add(3L);
    }
    public void generate(){
        System.out.println("Finding primes up to " + num);
        System.out.println(2);
        System.out.println(3);
        for (long i = 5; i <= num; i+=2) {
            boolean isPrime = true;
            for (Long prime : primes) {
                if (i % prime == 0) {
                    isPrime = false;
                    break;
                }
                if (prime >Math.sqrt(i)) {
                    break;
                }
            }
            if (isPrime){
                System.out.println(i);
                primes.add(i);
            }
        }
    }
    public static int getNumFromUser(){
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter a number to find primes to: ");
        int n = in.nextInt();
        if (n < 4) {
            System.out.println("Please enter a number greater than 3");
            n = getNumFromUser();
        }
        in.close();
        return n;
    }
    public ArrayList<Long> getPrimes() {
        return primes;
    }
    public static void main(String[] args){
        int n = getNumFromUser();
        PrimeGenerator generator = new PrimeGenerator(n);
        generator.generate();
    }
}
