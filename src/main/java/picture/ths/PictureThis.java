package picture.ths;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.imageio.ImageIO;

public class PictureThis {
  public static PictureThis getInstance() {
    return new PictureThis();
  }

  public BufferedImage resize(BufferedImage src, int width, int height) {
    BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    Graphics2D graphics2D = resizedImage.createGraphics();
    graphics2D.drawImage(src, 0, 0, width, height, null);
    graphics2D.dispose();
    return resizedImage;
  }

  public BufferedImage resize(URL src, int width, int height) throws IOException {
    BufferedImage srcImage = ImageIO.read(src);
    return resize(srcImage, width, height);
  }

  public BufferedImage resize(File src, int width, int height) throws IOException {
    BufferedImage srcImage = ImageIO.read(src);
    return resize(srcImage, width, height);
  }

  public BufferedImage resize(InputStream src, int width, int height) throws IOException {
    BufferedImage srcImage = ImageIO.read(src);
    return resize(srcImage, width, height);
  }

  public BufferedImage overlay(BufferedImage background, BufferedImage src, int x, int y) {
    BufferedImage output =
        new BufferedImage(
            background.getWidth(), background.getHeight(), BufferedImage.TYPE_INT_RGB);
    Graphics2D graphics2D = output.createGraphics();
    graphics2D.drawImage(background, 0, 0, background.getWidth(), background.getHeight(), null);
    graphics2D.drawImage(src, x, y, src.getWidth(), src.getHeight(), null);
    graphics2D.dispose();
    return output;
  }
}
