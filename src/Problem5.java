/**
 * Created by luojingyu on 17-6-1.
 */
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Problem5 {
    public final static void scale(String srcImageFile, String result) {
        try {
            BufferedImage src = ImageIO.read(new File(srcImageFile));
            Image image = src.getScaledInstance(640, 1136, Image.SCALE_DEFAULT);
            BufferedImage tag = new BufferedImage(640, 1136, BufferedImage.TYPE_INT_BGR);
            Graphics g = tag.getGraphics();
            g.drawImage(image, 0, 0, null);
            g.dispose();
            ImageIO.write(tag, "PNG", new File(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String path = "/home/luojingyu/图片/Problem5";
        File file = new File(path);
        File[] files = file.listFiles();
        for (int i=0; i<files.length; i++) {
            scale(String.valueOf(files[i]), path+File.separator+i);
        }
    }
}
