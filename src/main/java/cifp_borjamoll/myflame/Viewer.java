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
    private boolean vNormal = true;
    private boolean vGris = false;
    private boolean vSepia = false;

    //Constructor Viewer
    public Viewer(Flame flame) {
        try {
            imagen = ImageIO.read(new File("src/main/java/Imagenes/biochimenea2.png"));
        } catch (IOException e) {
            System.out.println("Error to load Background Image");
        }
        this.flame = flame;
        Thread fuegoThread = new Thread(flame);
        fuegoThread.start();
    }

    //Setter & Getter
    public boolean isvNormal() {
        return vNormal;
    }

    public void setvNormal(boolean vNormal) {
        this.vNormal = vNormal;
    }

    public boolean isvGris() {
        return vGris;
    }

    public void setvGris(boolean vGris) {
        this.vGris = vGris;
    }

    public boolean isvSepia() {
        return vSepia;
    }

    public void setvSepia(boolean vSepia) {
        this.vSepia = vSepia;
    }

    //Metodos
    
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

    public void paleteNormal() {
        FlamePalette palette = new FlamePalette();
        //Paleta Colores Normal
        palette.addColor(new TargetColor(new Color(0, 0, 0, 255), 0));
        palette.addColor(new TargetColor(new Color(50, 50, 50, 255), 50));
        palette.addColor(new TargetColor(new Color(80, 80, 80, 255), 80));
        palette.addColor(new TargetColor(new Color(255, 0, 0, 255), 110));
        palette.addColor(new TargetColor(new Color(255, 255, 0, 255), 130));
        palette.addColor(new TargetColor(new Color(255, 255, 255, 255), 255));
        palette.createPalette();

        this.flame.setFlamePalette(palette);
    }

    public void paleteGris() {
        FlamePalette palette = new FlamePalette();
        //Paleta Colores Gris
        palette.addColor(new TargetColor(new Color(0, 0, 0, 255), 0));//Fondo
        palette.addColor(new TargetColor(new Color(28, 28, 28, 255), 50));//Humo
        palette.addColor(new TargetColor(new Color(30, 30, 30, 255), 80));//Casi Humo
        palette.addColor(new TargetColor(new Color(156, 156, 156, 255), 110));//Arriba
        palette.addColor(new TargetColor(new Color(215, 215, 215, 255), 130));//Medio
        palette.addColor(new TargetColor(new Color(255, 255, 255, 255), 255));//abajo
        palette.createPalette();

        this.flame.setFlamePalette(palette);
    }

    public void paleteSepia() {
        FlamePalette palette = new FlamePalette();
        //Paleta Colores Sepia
        palette.addColor(new TargetColor(new Color(0, 0, 0, 255), 0));//Fondo
        palette.addColor(new TargetColor(new Color(56, 44, 30, 255), 50));//Humo
        palette.addColor(new TargetColor(new Color(91, 48, 15, 255), 80));//Casi Humo
        palette.addColor(new TargetColor(new Color(107, 68, 18, 255), 110));//Arriba
        palette.addColor(new TargetColor(new Color(180, 125, 55, 255), 130));//Medio
        palette.addColor(new TargetColor(new Color(233, 205, 151, 255), 255));//Abajo
        palette.createPalette();

        this.flame.setFlamePalette(palette);

    }

    @Override
    public void run() {
        this.paleteNormal();
        createBufferStrategy(2);
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (vGris) {
                this.paleteGris();
            } else if (vSepia) {
               this.paleteSepia();
            } else {
                this.paleteNormal();
            }
            this.paint();
        }
    }

}
