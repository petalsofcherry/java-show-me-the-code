/**
 * Created by luojingyu on 17-5-24.
 */
import java.util.HashSet;
import java.util.Random;

public class Problem1 {
    public static void main(String[] args) {
        Random random = new Random();
        Object[] values = new Object[200];

        HashSet<Integer> hashSet = new HashSet<Integer>();

        while (hashSet.size() < values.length) {
            hashSet.add(random.nextInt(600));
        }

        values = hashSet.toArray();

        for(int i=0; i<values.length; i++) {
            System.out.print(values[i]);
            System.out.print(" ");

            if((i+1) % 10 == 0) {
                System.out.println("\n");
            }
        }
    }
}