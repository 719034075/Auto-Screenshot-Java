package main.java.gui;

import main.java.core.ScreenshotRobot;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ScreenshotGui {
    private MyFrame frame;

    private MyLabel tipsLabel;
    private MyLabel xLabel;
    private MyLabel yLabel;
    private MyLabel widthLabel;
    private MyLabel heightLabel;
    private MyLabel timeLabel;
    private MyLabel picTypeLabel;
    private MyLabel saveLabel;

    private MyTextField xTextField;
    private MyTextField yTextField;
    private MyTextField widthTextField;
    private MyTextField heightTextField;
    private MyTextField timeTextField;
    private MyTextField picTypeTextField;
    private MyTextField saveTextField;

    private MyButton fileButton;
    private MyButton startButton;

    private MyFileChooser fileChooser;

    private ScreenshotRobot screenshotRobot;

    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public void initScreenshotGui() {
        frame = new MyFrame(420, 250, (int) (screenSize.width * 0.3), (int) (screenSize.height * 0.2));
        tipsLabel = new MyLabel();
        xLabel = new MyLabel();
        yLabel = new MyLabel();
        widthLabel = new MyLabel();
        heightLabel = new MyLabel();
        timeLabel = new MyLabel();
        picTypeLabel = new MyLabel();
        saveLabel = new MyLabel();

        xTextField = new MyTextField();
        yTextField = new MyTextField();
        widthTextField = new MyTextField();
        heightTextField = new MyTextField();
        timeTextField = new MyTextField();
        picTypeTextField = new MyTextField();
        saveTextField = new MyTextField();

        fileButton = new MyButton();
        startButton = new MyButton();

        fileChooser = new MyFileChooser();

        frame.setFrameTitle("Auto-Screenshot");
        frame.setLayout(null);

        tipsLabel.setText("点击Start之后，手动点击需要截图的pdf，保证page down正常运行.");
        xLabel.setText("X：");
        yLabel.setText("Y：");
        widthLabel.setText("Width：");
        heightLabel.setText("Height：");
        timeLabel.setText("Time：");
        picTypeLabel.setText("picType：");
        saveLabel.setText("Save：");

        fileButton.setText("...");
        startButton.setText("Start");

        screenshotRobot =new ScreenshotRobot();
        fileChooser.setCurrentDirectory(new File("E://"));
    }

    public void setBounds() {
        tipsLabel.setBounds(10, 10, 390, 20);
        xLabel.setBounds(10, 40, 50, 20);
        yLabel.setBounds(215, 40, 50, 20);
        widthLabel.setBounds(10, 70, 50, 20);
        heightLabel.setBounds(215, 70, 50, 20);
        timeLabel.setBounds(10, 100, 50, 20);
        picTypeLabel.setBounds(215, 100, 50, 20);
        saveLabel.setBounds(10, 130, 50, 20);

        xTextField.setBounds(60, 40, 135, 20);
        yTextField.setBounds(265, 40, 135, 20);
        widthTextField.setBounds(60, 70, 135, 20);
        heightTextField.setBounds(265, 70, 135, 20);
        timeTextField.setBounds(60, 100, 135, 20);
        picTypeTextField.setBounds(265, 100, 135, 20);
        saveTextField.setBounds(60, 130, 290, 20);

        fileButton.setBounds(350, 130, 50, 20);
        startButton.setBounds(10, 160, 390, 20);
    }

    public void eventScreenshotGui() {
        fileButton.addActionListener(e -> jfcClickEvent());
        startButton.addActionListener(e->startClickEvent());
    }

    public void addScreenshotGui() {
        frame.add(tipsLabel);
        frame.add(xLabel);
        frame.add(yLabel);
        frame.add(widthLabel);
        frame.add(heightLabel);
        frame.add(timeLabel);
        frame.add(picTypeLabel);
        frame.add(saveLabel);
        frame.add(xTextField);
        frame.add(yTextField);
        frame.add(widthTextField);
        frame.add(heightTextField);
        frame.add(picTypeTextField);
        frame.add(saveTextField);
        frame.add(timeTextField);
        frame.add(fileButton);
        frame.add(startButton);
        frame.showFrame();
    }

    public void jfcClickEvent() {
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int state = fileChooser.showOpenDialog(null);
        if (state == 1) {
            return;
        } else {
            File file = fileChooser.getSelectedFile();
            saveTextField.setText(file.getAbsolutePath());
        }
    }

    public void startClickEvent(){
        screenshotRobot.setX(Integer.parseInt(xTextField.getText()));
        screenshotRobot.setY(Integer.parseInt(yTextField.getText()));
        screenshotRobot.setWidth(Integer.parseInt(widthTextField.getText()));
        screenshotRobot.setHeight(Integer.parseInt(heightTextField.getText()));
        screenshotRobot.setPicType(picTypeTextField.getText());
        screenshotRobot.setSave(saveTextField.getText());
        screenshotRobot.setTime(Integer.parseInt(timeTextField.getText()));
        frame.hideFrame();
        screenshotRobot.startScreenShot();
        frame.showFrame();
        tipsLabel.setText("截图完成");

    }

    public void run() {
        initScreenshotGui();
        setBounds();
        eventScreenshotGui();
        addScreenshotGui();
    }
}
