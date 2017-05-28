import java.util.HashSet;
import java.util.Random;

import redis.clients.jedis.Jedis;

/**
 * Created by luojingyu on 17-5-28.
 */
public class Problem3 {

    public static Object[] getRandom() {
        Random random = new Random();
        Object[] values = new Object[200];

        HashSet<Integer> hashSet = new HashSet<Integer>();

        while (hashSet.size() < values.length) {
            hashSet.add(random.nextInt(600));
        }

        values = hashSet.toArray();
        return values;
    }

    public static void main (String[] args) {
        Jedis jedis = new Jedis("localhost");
        Object[] myRandomNum = getRandom();
        for (int i=0; i<myRandomNum.length; i++) {
            jedis.lpush("mylist", String.valueOf(myRandomNum[i]));
        }
        jedis.close();
    }

}
