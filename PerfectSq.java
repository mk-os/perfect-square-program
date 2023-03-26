import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class PerfectSq {
    public static void main(String[] args) {
        int n = 1;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter integer m: ");

        int m = sc.nextInt();
        ArrayList<Integer> mfactors = getFactors(m);
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < mfactors.size(); i++) {
            int element = mfactors.get(i);
            map.put(element, map.getOrDefault(element, 0) + 1);
        }

        for (int key : map.keySet()) {
            int count = map.get(key);
            if ((count % 2) != 0) {
                n = n * key;
            }
        }

        System.out.println("The smallest number n for m * n to be a perfect square is: " + n);
        System.out.println("m * n is: " + (m * n));
    }
    public static ArrayList<Integer> getFactors(int num) {
        ArrayList<Integer> factors = new ArrayList<Integer>();
        while (num > 1) {
            for (int i = 2; num != 1; i++) {
                if ((num % i) == 0) {
                    factors.add(Math.abs(i));
                    num = num / i;
                    break;
                }
            }
        }
        return factors;
    }
}