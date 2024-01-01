import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;

public class TabImages{
    public static Map<Character, BufferedImage> images;

    public TabImages(){
        images=new HashMap<Character, BufferedImage>();
        try{
            images.put('#', ImageIO.read(getClass().getResourceAsStream("/images/wall.png")));
            images.put(' ', ImageIO.read(getClass().getResourceAsStream("/images/terre.png")));
            images.put('B', ImageIO.read(getClass().getResourceAsStream("/images/boite.png")));
            images.put('A', ImageIO.read(getClass().getResourceAsStream("/images/patrick.png")));
            images.put('@', ImageIO.read(getClass().getResourceAsStream("/images/cible.png")));

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}