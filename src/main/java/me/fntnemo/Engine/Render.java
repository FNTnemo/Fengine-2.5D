package me.fntnemo.Engine;

import me.fntnemo.Player;

import java.awt.*;

public class Render {
    public static void render(Graphics g){
        //sky and floor
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, Window.width, Window.height/2);
        g.setColor(Color.pink);
        g.fillRect(0, Window.height/2, Window.width, Window.height/2);

        //main render
        int x = 0;
        for (double i = Player.playerA - Player.fov/2; i < Player.playerA + Player.fov/2; i+=RayCasting.deltaAngle) {
            double depthWall = getDepthTo(i, '#');

            //color
            float depthColor = (float) (1/(1 + depthWall*depthWall * 0.0001f/5) + 0.3f);
            if (depthColor < 0){depthColor = 0;}
            if (depthColor > 1){depthColor = 1;}
            g.setColor(new Color(depthColor, depthColor, depthColor));

            g.fillRect(x, (int) (Window.height/2 - (RayCasting.wallHeight*RayCasting.cameraHeight)/depthWall/2), Window.width/RayCasting.numRays,
                    (int) ((RayCasting.wallHeight*RayCasting.cameraHeight)/depthWall));

            x += Window.width / RayCasting.numRays;
        }

        miniMap(g);
        fps(g);
        debug(g);
    }

    private static double getDepthTo(double angle, char Char) {
        double depthX = Player.playerPos[0];
        double depthY = Player.playerPos[1];
        char wall = 0;
        while (wall != Char){
            depthX += Math.cos(angle);
            depthY += Math.sin(angle);
            if(depthX/100 >= Map.mapSizeX || depthY/100 >= Map.mapSizeY){
                depthX = Player.playerPos[0];
                depthY = Player.playerPos[1];
                break;
            }
            if(depthX/100 < 0 || depthY/100 < 0){
                depthX = Player.playerPos[0];
                depthY = Player.playerPos[1];
                break;
            }
            wall = Map.getMapChar((int) depthX/100, (int) depthY/100, Map.map);
        }

        //g.setColor(Color.GREEN);
        //g.drawLine(Player.playerPos[0] / 10 + Player.playerSize / 10, Player.playerPos[1] / 10 + Player.playerSize / 10, (int) (depthX / 10), (int) (depthY / 10));

        depthX -= Player.playerPos[0];
        depthY -= Player.playerPos[1];

        double depth = (Math.sqrt(Math.pow(depthX, 2) + Math.pow(depthY, 2)) * Math.cos(Player.playerA - angle));
        return depth;
    }

    public static void miniMap(Graphics g){
        ////map
        g.setColor(Color.black);
        g.fillRect(0, 0, Map.mapSizeX*10, Map.mapSizeY*10);

        g.setColor(Color.WHITE);
        for (int x = 0; x < Map.mapSizeX; x++) {
            for (int y = 0; y < Map.mapSizeY; y++) {
                if (Map.getMapChar(x, y, Map.map) == '#'){
                    g.setColor(Color.WHITE);
                    g.fillRect(x*10, y*10, 10, 10);
                } if(Map.getMapChar(x, y, Map.map) == 'w'){
                    g.setColor(Color.LIGHT_GRAY);
                    g.fillRect(x*10, y*10, 10, 10);
                }
            }
        }
        //main player angel
        g.setColor(Color.GREEN);
        g.drawLine(Player.playerPos[0] / 10 + Player.playerSize / 10, Player.playerPos[1] / 10 + Player.playerSize / 10,
                (int) RayCasting.getRayPosX(RayCasting.maxDepth, Player.playerA) / 10,
                (int) RayCasting.getRayPosY(RayCasting.maxDepth, Player.playerA) / 10);
        //player
        g.setColor(Color.MAGENTA);
        g.fillOval(Player.playerPos[0] / 10, Player.playerPos[1]/ 10, Player.playerSize / 5, Player.playerSize / 5);
    }

    public static long time = System.currentTimeMillis();
    public static float fps;
    public static int currentFps;

    private static final int lineSpacing = 20;

    public static void fps(Graphics g){
        currentFps++;
        if(System.currentTimeMillis() - time >= 1000) {
            fps = currentFps;
            currentFps = 0;
            time = System.currentTimeMillis();
        }
        g.setColor(Color.GREEN);
        g.drawString("FPS: " + fps, 10, Map.mapSizeY*10 + lineSpacing);
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void debug(Graphics g){
        //coords
        g.drawString("X :" + Player.playerPos[0] + "; Y: " + Player.playerPos[1], 10, Map.mapSizeY*10 + lineSpacing * 2);
        //angle
        g.drawString("Player angle: " + Player.playerA, 10, Map.mapSizeY*10 + lineSpacing * 3);
    }
}
