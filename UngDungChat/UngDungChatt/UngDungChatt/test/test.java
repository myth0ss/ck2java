
import com.hieuthao.blurHash.BlurHash;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;



/**
 *
 * @author MinhHieu
 */
public class test {
    public static void main(String[] args) {
        
        try {
             BufferedImage image = ImageIO.read(new File("C:\\Users\\CYBORG 15\\Documents\\Vợ iu\\z4952241130611_22b448059ba461e066841df32e414fb3.jpg"));
             String blurhashStr = BlurHash.encode(image); 
             System.out.println(blurhashStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
