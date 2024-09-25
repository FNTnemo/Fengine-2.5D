package me.fntnemo.Engine;

import me.fntnemo.Player;

public class RayCasting {
    public static int maxDepth = 800;
    public static int numRays = Window.width/10;
    public static float deltaAngle = (float) (Player.fov / numRays);
    public static int wallHeight = 10000;
    public static int miniWallHeight = wallHeight / 2;
    public static int cameraHeight = 10;

    public static double getRayPosX(int depth, double angle){
        return Player.playerPos[0] + depth * Math.cos(angle);
    } public static double getRayPosY(int depth, double angle){
        return Player.playerPos[1] + depth * Math.sin(angle);
    }

}
