package utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class ImageDissection {


    public static void grayScale(File input)
    {
        BufferedImage image = null;

        {
            try {
                image = ImageIO.read(input);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        int imgHeight = image.getHeight();
        int imgWidth = image.getWidth();
        int imgArea = imgHeight * imgWidth;

        for (int i=0;i<imgWidth;i++)
        {
            for (int j=0;j<imgHeight;j++)
            {
                int clr = image.getRGB(i, j);
                Color color = new Color (clr, true);
                int newRed = color.getRed();
                int newGreen = color.getGreen();
                int newBlue = color.getBlue();
                int grayScaled = (newBlue + newGreen + newRed)/3;
                Color grayScaledColor = new Color(grayScaled,grayScaled,grayScaled);
                image.setRGB(i,j,grayScaledColor.getRGB());


            }
        }
        File outputfile = new File(input.getPath());
        try {
            ImageIO.write(image, "png", outputfile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void randomPixels(File input)
    {
        BufferedImage image = null;

        {
            try {
                image = ImageIO.read(input);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        int imgHeight = image.getHeight();
        int imgWidth = image.getWidth();
        Random r = new Random();
        for (int i=0;i<imgWidth;i++) {
            for (int j = 0; j < imgHeight; j++) {
                Color randomColor = new Color (r.nextInt(256), r.nextInt(256), r.nextInt(256));
                image.setRGB(i,j,randomColor.getRGB());
            }
        }
        File outputfile = new File(input.getPath());
        try {
            ImageIO.write(image, "png", outputfile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
