package me.fntnemo.Engine;

import me.fntnemo.Player;
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
    public static boolean UP = false;
    public static boolean DOWN = false;
    public static boolean SHIFT = false;

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
        if(keyP == KeyEvent.VK_SHIFT){SHIFT = true; Player.isRunning = true;}
        if(keyP == KeyEvent.VK_UP){UP = true;}
        if(keyP == KeyEvent.VK_DOWN){DOWN = true;}
        if(keyP == KeyEvent.VK_A){A = true; Player.isMove = true;}
        if(keyP == KeyEvent.VK_D){D = true; Player.isMove = true;}
        if(keyP == KeyEvent.VK_W){W = true; Player.isMove = true;}
        if(keyP == KeyEvent.VK_S){S = true; Player.isMove = true;}
        if(keyP == KeyEvent.VK_Q){Q = true;}
        if(keyP == KeyEvent.VK_E){E = true;}

        if(keyR == KeyEvent.VK_SHIFT){SHIFT = false; Player.isRunning = false;}
        if(keyR == KeyEvent.VK_UP){UP = false;}
        if(keyR == KeyEvent.VK_DOWN){DOWN = false;}
        if(keyR == KeyEvent.VK_A){A = false; Player.isMove = false;}
        if(keyR == KeyEvent.VK_D){D = false; Player.isMove = false;}
        if(keyR == KeyEvent.VK_W){W = false; Player.isMove = false;}
        if(keyR == KeyEvent.VK_S){S = false; Player.isMove = false;}
        if(keyR == KeyEvent.VK_Q){Q = false;}
        if(keyR == KeyEvent.VK_E){E = false;}

        keyP = 0;
        keyR = 0;
    }
}
