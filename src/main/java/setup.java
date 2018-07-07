package main.java;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class setup {
    public static void main(String[] args) {
        try {
            Robot robot=new Robot();
            //根据指定的区域抓取屏幕的指定区域，1300是长度，800是宽度。
            BufferedImage bi=robot.createScreenCapture(new Rectangle(500,115,677,872));
            //把抓取到的内容写到一个jpg文件中
            ImageIO.write(bi, "jpg", new File("F:\\img\\test.jpg"));

        } catch (AWTException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
