import java.io.*;

/**
 * Created by luojingyu on 17-5-29.
 */

public class Probelm4 {
    public static void main(String[] args) throws IOException {
        String path = "/home/luojingyu/test";
        InputStream is = null;
        try {
            is = new FileInputStream(path);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "US-ASCII"), 512);
            Integer count = 0;
            String pre = "不是单词";
            for (int tempchar = reader.read(); tempchar != -1; tempchar = reader.read()) {
               if (pre=="不是单词" && ((tempchar>=65 && tempchar<=90) || (tempchar>=97 && tempchar <= 122))) {
                   count++;
                   pre = "是单词";
               }

               if (!((tempchar>=65 && tempchar<=90) || (tempchar>=97 && tempchar <= 122))) {
                   pre = "不是单词";
               }
            }
            System.out.println(count);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
