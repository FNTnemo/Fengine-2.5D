package me.fntnemo.Engine;

import javax.swing.*;

public class Window extends JFrame {
    public static int width = 1280;
    public static int height = 720;
    public Window(int width, int height, String title, String version){

        //screen settings
        setTitle(title + " " + version);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(width, height + 25);
        setResizable(true);
        setVisible(true);
        setLocation(75, 75);

        //add-ons
        add(new Engine());
        addKeyListener(new InputEngine());
    }
}
