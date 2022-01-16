/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifp_borjamoll.myflame;

/**
 *
 * @author Roberto
 */
import java.awt.Color;
import java.util.ArrayList;
import java.util.Comparator;

public class FlamePalette {

    private int nColor = 256;
    private Color[] colorPalette = new Color[nColor];
    private ArrayList<TargetColor> listaTargetColors = new ArrayList<TargetColor>();

    public FlamePalette() {

    }

    public int getnColor() {
        return nColor;
    }

    public void setnColor(int nColor) {
        this.nColor = nColor;
    }

    public Color[] getColorPalette() {
        return colorPalette;
    }

    public void setColorPalette(Color[] colorPalette) {
        this.colorPalette = colorPalette;
    }

    public void setTargetColor(ArrayList<TargetColor> listaTargetColors) {
        this.listaTargetColors = listaTargetColors;
    }

    public void addColor(TargetColor tColor) {
        listaTargetColors.add(tColor);
    }

    public int getColor(int temperature) {
        if (temperature >= 0 && temperature <= 256) {
            int aux;
            aux = (colorPalette[temperature].getAlpha() << 24
                    | colorPalette[temperature].getRed() << 16
                    | colorPalette[temperature].getGreen() << 8
                    | colorPalette[temperature].getBlue());
            return aux;
        } else {
            return 0;
        }
    }

    public void createPalette() {
        for (int i = 0; i < listaTargetColors.size(); i++) {
            if (i == listaTargetColors.size() - 1) {
                colorPalette[listaTargetColors.get(i).getTemperatura()] = listaTargetColors.get(i).getColor();
            } else {
                interpolateColors(listaTargetColors.get(i), listaTargetColors.get(i + 1));
            }
        }
    }

    private void interpolateColors(TargetColor colorInicial, TargetColor colorFinal) {

        float colorInicialR = colorInicial.getColor().getRed();
        float colorInicialG = colorInicial.getColor().getGreen();
        float colorInicialB = colorInicial.getColor().getBlue();
        float colorInicialA = colorInicial.getColor().getAlpha();

        float colorFinalR = colorFinal.getColor().getRed();
        float colorFinalG = colorFinal.getColor().getGreen();
        float colorFinalB = colorFinal.getColor().getBlue();
        float colorFinalA = colorFinal.getColor().getAlpha();

        int steps = colorFinal.getTemperatura() - colorInicial.getTemperatura();

        float incrementR = colorFinalR - colorInicialR;
        float incrementG = colorFinalG - colorInicialG;
        float incrementB = colorFinalB - colorInicialB;
        float incrementA = colorFinalA - colorInicialA;

        colorPalette[colorInicial.getTemperatura()] = colorInicial.getColor();

        float incrementStepR = incrementR / steps;
        float incrementStepG = incrementG / steps;
        float incrementStepB = incrementB / steps;
        float incrementStepA = incrementA / steps;

        for (int i = 1; i < steps; i++) {
            int r = Math.round(colorInicialR + incrementStepR * i);
            int g = Math.round(colorInicialG + incrementStepG * i);
            int b = Math.round(colorInicialB + incrementStepB * i);
            int a = Math.round(colorInicialA + incrementStepA * i);

            Color colorAux = new Color(r,g,b,a);
            colorPalette[colorInicial.getTemperatura() + i] = colorAux;
        }
        colorPalette[colorFinal.getTemperatura()] = colorFinal.getColor();
    }
}
