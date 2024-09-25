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

        //g.fillRect(Player.testX, Player.testY, 100, 100);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Player.movement();
        InputEngine.checkPressedKeys();

        if(Player.isMove){
            RayCasting.displacementX+=0.002f;
        } else {
            RayCasting.displacementX -= 0.0005f;
        }
        if (RayCasting.displacementX >= 0.22f || RayCasting.displacementX < 0) {
            RayCasting.displacementX = 0;
        }
        if(Player.isRunning){RayCasting.displacementY = (int) (20 * Math.sin((double) (180 * RayCasting.displacementX) / Math.PI));}
        else {RayCasting.displacementY = (int) (7 * Math.sin((double) (180 * RayCasting.displacementX) / Math.PI));}

        Window.rescaleWindow();
    }
}
