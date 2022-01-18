package cifp_borjamoll.myflame;

import java.awt.image.BufferedImage;

/**
 *
 * @author Roberto
 */
public class Flame extends BufferedImage implements Runnable {

    private FlamePalette flamePalette;
    BufferedImage imagen = null;
    private int[][] matrixFuego;
    private int SPARK = 75;
    private int COOL = 55;
    private int VELOCITY = 120;
    private boolean activeThread = true;
    private int imageType;

    public boolean isActiveThread() {
        return activeThread;
    }

    public void setActiveThread(boolean activeThread) {
        this.activeThread = activeThread;
    }

    public int getSPARK() {
        return SPARK;
    }

    public void setSPARK(int SPARK) {
        this.SPARK = SPARK;
    }

    public int getCOOL() {
        return COOL;
    }

    public void setCOOL(int COOL) {
        this.COOL = COOL;
    }

    public int getVELOCITY() {
        return VELOCITY;
    }

    public void setVELOCITY(int VELOCITY) {
        this.VELOCITY = VELOCITY;
    }

    public FlamePalette getFlamePalette() {
        return flamePalette;
    }

    public void setFlamePalette(FlamePalette flamePalette) {
        this.flamePalette = flamePalette;
    }

    public Flame(int width, int height, int imageType) {
        super(width, height, imageType);
        this.imageType = imageType;
        matrixFuego = new int[300][300];
    }

    //Creamos las Sparks
    public void createSpark() {
        System.out.println("Sparks");
        for (int i = 0; i < matrixFuego.length; i++) {
            int aux = (int) (Math.random() * 200);
            if (aux <= SPARK) {
                matrixFuego[i][matrixFuego[0].length - 1] = 255;
            }
        }
    }

    //EvolveTemperature
    public void EvolveTemperature() {
        int increment = (int) 0.9d;
        System.out.println("Temperature Evolve");
        for (int j = matrixFuego[0].length - 2; j >= 0; j--) {
            for (int i = 1; i < matrixFuego.length - 1; i++) {
                matrixFuego[i][j] = (matrixFuego[i][j + 1]
                        + matrixFuego[i + 1][j + 1]
                        + matrixFuego[i][j]
                        + matrixFuego[i - 1][j + 1]) / 4;
            }
        }
    }

    //Creamos los puntos fríos
    public void createCool() {
        System.out.println("Cool Points");
        for (int i = 0; i < matrixFuego.length; i++) {
            int aux = (int) (Math.random() * 150);
            if (aux <= COOL) {
                matrixFuego[i][matrixFuego[0].length - 1] = 0;
            }
        }
    }

    //CreateFlameImage
    public void createFlameImage() {
        System.out.println("Fire");
        for (int i = 0; i < matrixFuego.length; i++) {
            for (int j = 0; j < matrixFuego[i].length; j++) {
                int p = this.getFlamePalette().getColor(matrixFuego[i][j]);
                this.setRGB(i, j, p);
            }
        }
    }

    @Override
    public void run() {
        System.out.println("Bucle flame");
        while (true) {
            try {
                Thread.sleep(VELOCITY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {
            }
            if (activeThread) {
                this.createSpark();
                this.createCool();
                this.EvolveTemperature();
                this.createFlameImage();
            }
        }
    }
}
