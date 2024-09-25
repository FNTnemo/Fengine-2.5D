package me.fntnemo;

import me.fntnemo.Engine.Window;

import javax.swing.*;

public class Main {
    public static JFrame window;
    public static void main(String[] args) {
        System.out.println("Open");
        window = new Window(Window.width, Window.height, "Fengine-", "a0.3");
    }
}