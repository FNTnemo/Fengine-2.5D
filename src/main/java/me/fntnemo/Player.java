package me.fntnemo;

import me.fntnemo.Engine.InputEngine;
import me.fntnemo.Engine.Map;

public class Player {
    public static int[] playerPos = {100, 100};
    public static int z = 0;
    public static int playerSpeed = 4;
    public static float playerDeltaAngle = 0.05f;
    public static float playerA = 0;
    public static double fov = Math.PI/3;
    public static boolean isMove = false;
    public static boolean isRunning = false;

    public static int playerSize = 20;

    public static int testX;
    public static int testY;

    public static void playerSpawn() {
        for (int x = 0; x < Map.mapSizeX; x++) {
            for (int y = 0; y < Map.mapSizeY; y++) {
                if(Map.getMapChar(x, y, Map.map) == 'p'){
                    playerPos[0] = x*100;
                    playerPos[1] = y*100;
                    break;
                }
            }
        }
    }
    public static boolean mapBorder(){
        return ((Player.playerPos[0] < (Map.mapSizeX)*100 && Player.playerPos[0] > 0) && (Player.playerPos[1] < (Map.mapSizeY)*100 && Player.playerPos[1] > 0));
    }

    public static void movement(){
        if (InputEngine.A && mapBorder()){
            playerPos[0] += (int) (playerSpeed * Math.sin(Player.playerA));
            playerPos[1] -= (int) (playerSpeed * Math.cos(Player.playerA));
            if (!mapBorder()){
                playerPos[0] -= (int) (playerSpeed * Math.sin(Player.playerA));
                playerPos[1] += (int) (playerSpeed * Math.cos(Player.playerA));
            }
        } if(InputEngine.D && mapBorder()){
            playerPos[0] -= (int) (playerSpeed * Math.sin(Player.playerA));
            playerPos[1] += (int) (playerSpeed * Math.cos(Player.playerA));
            if (!mapBorder()){
                playerPos[0] += (int) (playerSpeed * Math.sin(Player.playerA));
                playerPos[1] -= (int) (playerSpeed * Math.cos(Player.playerA));
            }
        } if(InputEngine.W && mapBorder()){
            playerPos[0] += (int) (playerSpeed * Math.cos(Player.playerA));
            playerPos[1] += (int) (playerSpeed * Math.sin(Player.playerA));
            if (!mapBorder()){
                playerPos[0] -= (int) (playerSpeed * Math.cos(Player.playerA));
                playerPos[1] -= (int) (playerSpeed * Math.sin(Player.playerA));
            }
        } if(InputEngine.S && mapBorder()){
            playerPos[0] -= (int) (playerSpeed * Math.cos(Player.playerA));
            playerPos[1] -= (int) (playerSpeed * Math.sin(Player.playerA));
            if(!mapBorder()){
                playerPos[0] += (int) (playerSpeed * Math.cos(Player.playerA));
                playerPos[1] += (int) (playerSpeed * Math.sin(Player.playerA));
            }
        } if(InputEngine.Q){
            playerA -= playerDeltaAngle;
        } if(InputEngine.E){
            playerA += playerDeltaAngle;
        }
        if (InputEngine.SHIFT){
            playerSpeed = 8;
        } else {playerSpeed = 4;}
        if (InputEngine.UP){
            z += 1;
        } else if (InputEngine.DOWN) {
            z -= 1;
        }
    }
}
