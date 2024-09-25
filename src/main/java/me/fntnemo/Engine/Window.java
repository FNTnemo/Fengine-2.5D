package me.fntnemo.Engine;

import me.fntnemo.Main;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public static int width = 1280;
    public static int height = 720;
    public Window(int width, int height, String title, String version){
        //screen settings
        setTitle(title + version);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(width, height + 25);
        setResizable(false);
        setVisible(true);
        setLocation((int) (screenWidth/2 - width/2), (int) (screenHeight/2 - height/2));
        //add-ons
        add(new Engine());
        addKeyListener(new InputEngine());
    }

    public static final double screenWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    public static final double screenHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight();

    public static double getWindowWidth(){
        return Main.window.getSize().getWidth();
    } public static double getWindowHeight(){
        return Main.window.getSize().getHeight();
    }
    public static void rescaleWindow(){
        width = (int) getWindowWidth();
        height = (int) getWindowHeight();
    }

}
