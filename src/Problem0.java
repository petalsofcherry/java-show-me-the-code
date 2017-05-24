/**
 * Created by luojingyu on 17-5-24.
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Problem0 {
    public static void main (String[] args) {
        String text = "12";
        String srcImageFile = "/home/luojingyu/图片/截图.png";
        String destImageFile = "/home/luojingyu/图片/另一张截图.png";

        pressText(text, srcImageFile, destImageFile);
    }

    public final static void pressText(String pressText,
                                       String srcImageFile, String destImageFile) {
        try {
            File img = new File(srcImageFile);
            Image src = ImageIO.read(img);
            int width = src.getWidth(null);
            int height = src.getHeight(null);
            BufferedImage image = new BufferedImage(width, height,
                    BufferedImage.TYPE_INT_RGB);
            Graphics2D g = image.createGraphics();
            g.drawImage(src, 0, 0, width, height, null);
            g.setColor(new Color(255, 0, 0));
            g.setFont(new Font("arial", Font.PLAIN, 40));
            // 在指定坐标绘制水印文字
            g.drawString(pressText, 4*width / 5, 1*height / 5);
            g.dispose();
            ImageIO.write((BufferedImage) image, "PNG", new File(destImageFile));// 输出到文件流
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final static int getLength(String text) {
        int length = 0;
        for (int i = 0; i < text.length(); i++) {
            if (new String(text.charAt(i) + "").getBytes().length > 1) {
                length += 2;
            } else {
                length += 1;
            }
        }
        return length / 2;
    }
}
