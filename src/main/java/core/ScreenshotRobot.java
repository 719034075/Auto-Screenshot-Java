package main.java.core;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

public class ScreenshotRobot {

    private int x;
    private int y;
    private int width;
    private int height;
    private String picType;
    private String save;
    private int time;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getPicType() {
        return picType;
    }

    public void setPicType(String picType) {
        this.picType = picType;
    }

    public String getSave() {
        return save;
    }

    public void setSave(String save) {
        this.save = save;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void startScreenShot() {
        try {
            Robot robot = new Robot();
            BufferedImage bi;
            String picName;
            robot.setAutoDelay(1000);

            for (int i = 0; i < time; i++) {
                DecimalFormat df = new DecimalFormat("000");
                String id = df.format(i);
                picName = save + "\\" + id + "." + picType;
                bi = robot.createScreenCapture(new Rectangle(x, y, width, height));
                System.out.println(picName);
                ImageIO.write(bi, picType, new File(picName));
                robot.keyPress(KeyEvent.VK_PAGE_DOWN);
            }
        } catch (AWTException | IOException e) {
            e.printStackTrace();
        }
    }

}
