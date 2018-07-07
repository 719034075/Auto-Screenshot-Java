package main.java.gui;

import javax.swing.*;
import java.awt.*;

public class ScreenshotGui {
    private MyFrame frame;

    private MyLabel tipsLabel;
    private MyLabel xLabel;
    private MyLabel yLabel;
    private MyLabel widthLabel;
    private MyLabel heightLabel;
    private MyLabel timeLabel;
    private MyLabel saveLabel;

    private MyTextField xTextField;
    private MyTextField yTextField;
    private MyTextField widthTextField;
    private MyTextField heightTextField;
    private MyTextField timeTextField;
    private MyTextField saveTextField;

    private MyButton fileButton;
    private MyButton startButton;

    private MyFileChooser fileChooser;

    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public void initScreenshotGui(){
        frame = new MyFrame(400, 300, (int)(screenSize.width*0.3),(int)(screenSize.height*0.2));
    }
}
