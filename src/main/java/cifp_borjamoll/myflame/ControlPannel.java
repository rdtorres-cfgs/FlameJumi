/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifp_borjamoll.myflame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Roberto
 */
public class ControlPannel extends JPanel {

    Viewer viewer;
    MyFlame myflame;
    Flame flame;
    JSlider slider_spark, slider_cool, slider_velocity;
    Events e = new Events();
    JLabel etiquetaTitulo, controlPrograma, valorSPARK, valorCOOL, valorVELOCITY;
    JButton boton1, boton2;

    public ControlPannel(MyFlame myflame) {
        this.myflame = myflame;
        this.setBackground(Color.decode("#D7D7A8"));
        this.setLayout(null);
        inicializarComponentes();
        this.setPreferredSize(new Dimension(450,450));
    }

    private void inicializarComponentes() {
        addLabel();
        addSlider();
        addButton();
    }

    private void addLabel() {
        //SetBounds(X (izquierda-derecha),Y(arriba-abajo),ancho(izquierda-derecha),alto(arriba-abajo))
        etiquetaTitulo = new JLabel("ContolPannel");
        etiquetaTitulo.setBounds(125, 0, 350, 100);
        etiquetaTitulo.setFont(new Font("Serif", Font.PLAIN, 64));
        this.add(etiquetaTitulo);

        controlPrograma = new JLabel("Control Programa:");
        controlPrograma.setBounds(10, 100, 200, 50);
        controlPrograma.setFont(new Font("Serif", Font.PLAIN, 20));
        this.add(controlPrograma);

        valorSPARK = new JLabel("Valor Sparks:");
        valorSPARK.setBounds(10, 165, 125, 50);
        valorSPARK.setFont(new Font("Serif", Font.PLAIN, 20));
        this.add(valorSPARK);

        valorCOOL = new JLabel("Valor Cool:");
        valorCOOL.setBounds(10, 250, 125, 50);
        valorCOOL.setFont(new Font("Serif", Font.PLAIN, 20));
        this.add(valorCOOL);

        valorVELOCITY = new JLabel("Valor Velocidad:");
        valorVELOCITY.setBounds(10, 335, 150, 50);
        valorVELOCITY.setFont(new Font("Serif", Font.PLAIN, 20));
        this.add(valorVELOCITY);
    }

    private void addSlider() {
        slider_spark = new JSlider(JSlider.HORIZONTAL, 0, 200, myflame.getSPARK());
        slider_spark.setToolTipText("Valor_fuego");
        //Lineas Grandes
        slider_spark.setMajorTickSpacing(25);
        //Lineas Pequeñas
        slider_spark.setMinorTickSpacing(5);
        //Pintamos las barritas
        slider_spark.setPaintTicks(true);
        //Pintamos Numeros
        slider_spark.setPaintLabels(true);
//        slider_spark.setOpaque(true);
        slider_spark.setBounds(165, 175, 250, 45);
        slider_spark.addChangeListener(e);
        slider_spark.setEnabled(true);
        this.add(slider_spark);

        slider_cool = new JSlider(JSlider.HORIZONTAL, 0, 200, myflame.getCOOL());
        //Lineas Grandes
        slider_cool.setMajorTickSpacing(25);
        //Lineas Pequeñas
        slider_cool.setMinorTickSpacing(5);
        //Pintamos las barritas
        slider_cool.setPaintTicks(true);
        //Pintamos Numeros
        slider_cool.setPaintLabels(true);
        slider_cool.setBounds(165, 250, 250, 45);
        slider_cool.addChangeListener(e);
        this.add(slider_cool);

        slider_velocity = new JSlider(JSlider.HORIZONTAL, 0, 300, myflame.getVELOCITY());
        //Lineas Grandes
        slider_velocity.setMajorTickSpacing(50);
        //Lineas Pequeñas
        slider_velocity.setMinorTickSpacing(10);
        //Pintamos las barritas
        slider_velocity.setPaintTicks(true);
        //Pintamos Numeros
        slider_velocity.setPaintLabels(true);
        slider_velocity.setBounds(165, 325, 250, 45);
        slider_velocity.addChangeListener(e);
        this.add(slider_velocity);
    }

    private void addButton() {
        boton1 = new JButton("Start");
        boton1.setBounds(165, 115, 75, 25);
        boton1.setEnabled(true);
        boton1.addActionListener(e);
        boton1.setActionCommand("Start");
        this.add(boton1);

        boton2 = new JButton("Pause");
        boton2.setBounds(245, 115, 75, 25);
        boton2.setEnabled(true);
        boton2.addActionListener(e);
        boton2.setActionCommand("Pause");
        this.add(boton2);

    }

    private class Events implements ChangeListener, ActionListener {

        @Override
        public void stateChanged(ChangeEvent e) {
            myflame.setSPARK(slider_spark.getValue());
            myflame.setCOOL(slider_cool.getValue());
            myflame.setVELOCITY(slider_velocity.getValue());
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "Pause":
                    myflame.pauseThread();
                    break;
                case "Start":
                    myflame.startThread();
                    break;
            }

        }

    }
}
