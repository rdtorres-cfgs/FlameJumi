/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifp_borjamoll.myflame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Roberto
 */
public class Viewer extends Canvas implements Runnable {

    private BufferedImage imagen;
    Flame flame;
    TargetColor TargetColor;

    //Constructor Viewer
    public Viewer(Flame flame) {
        //Al tener fondo en Myflame no importa añadir en el viewer
        try {
            imagen = ImageIO.read(new File("C:\\Users\\Roberto\\Documents\\"
                    + "NetBeansProjects\\MyFlame\\src\\main\\java\\cifp_borjamoll\\"
                    + "myflame\\biochimenea2.png"));
        } catch (IOException e) {
            System.out.println("Error to load Background Image");
        }
        this.flame = flame;
        Thread fuegoThread = new Thread(flame);
        fuegoThread.start();
    }

    //Método Paint
    public void paint() {
        BufferStrategy buffered = this.getBufferStrategy();
        Graphics graphics = buffered.getDrawGraphics();
        if (buffered == null) {
            return;
        }
        if (graphics == null) {
            return;
        }
        System.out.println("FirePlace");
        graphics.drawImage(imagen, 0, 0, null);
        System.out.println("Background Image");
        graphics.drawImage(flame, 150, 300, 400, 300, null);
        buffered.show();
        graphics.dispose();
    }

    @Override
    public void run() {

        FlamePalette palette = new FlamePalette();
        palette.addColor(new TargetColor(new Color(0, 0, 0, 255), 0));
        palette.addColor(new TargetColor(new Color(50, 50, 50, 255), 50));
        palette.addColor(new TargetColor(new Color(80, 80, 80, 255), 80));
        palette.addColor(new TargetColor(new Color(255, 0, 0, 255), 110));
        palette.addColor(new TargetColor(new Color(255, 255, 0, 255), 130));
        palette.addColor(new TargetColor(new Color(255, 255, 255, 255), 255));

        palette.createPalette();

        this.flame.setFlamePalette(palette);
        createBufferStrategy(2);
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.paint();
        }
    }

}
