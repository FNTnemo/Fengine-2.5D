package me.fntnemo.Engine;

import me.fntnemo.Player;

import javax.swing.plaf.PanelUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputEngine extends KeyAdapter {
    //pressed keys
    public static boolean W = false;
    public static boolean A = false;
    public static boolean S = false;
    public static boolean D = false;
    public static boolean Q = false;
    public static boolean E = false;

    public static int keyP;
    public static int keyR;
    @Override
    public void keyPressed(KeyEvent e){
        super.keyPressed(e);
        keyP = e.getKeyCode();
    }
    @Override
    public void keyReleased(KeyEvent e){
        super.keyReleased(e);
        keyR = e.getKeyCode();
    }
    public static void checkPressedKeys(){
        if(keyP == KeyEvent.VK_A){A = true;}
        if(keyP == KeyEvent.VK_D){D = true;}
        if(keyP == KeyEvent.VK_W){W = true;}
        if(keyP == KeyEvent.VK_S){S = true;}
        if(keyP == KeyEvent.VK_Q){Q = true;}
        if(keyP == KeyEvent.VK_E){E = true;}

        if(keyR == KeyEvent.VK_A){A = false;}
        if(keyR == KeyEvent.VK_D){D = false;}
        if(keyR == KeyEvent.VK_W){W = false;}
        if(keyR == KeyEvent.VK_S){S = false;}
        if(keyR == KeyEvent.VK_Q){Q = false;}
        if(keyR == KeyEvent.VK_E){E = false;}

        keyP = 0;
        keyR = 0;
    }
}
