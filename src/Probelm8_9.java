/**
 * Created by luojingyu on 17-6-2.
 */
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;


public class Probelm8_9 {
    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("http://www.jianshu.com/p/bf21fb55bd8c").get();
            Elements body = doc.getElementsByTag("body");
            for (Element i: body) {
                System.out.println(i.text());
            }
            Elements links = doc.getElementsByTag("a");
            for (Element link: links) {
                System.out.println(link.attr("href"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
