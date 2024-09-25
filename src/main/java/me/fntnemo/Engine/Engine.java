package me.fntnemo.Engine;

import me.fntnemo.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Engine extends JPanel implements ActionListener {
    public Engine(){
        init();
        setBackground(Color.BLACK);
        Timer timer = new Timer(1, this);
        timer.start();
    }

    private static void init(){
        Player.playerSpawn();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Render.render(g);
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Player.movement();
        InputEngine.checkPressedKeys();
    }
}
