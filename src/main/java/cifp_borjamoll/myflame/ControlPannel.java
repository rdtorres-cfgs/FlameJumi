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
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
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
    Events e = new Events();
    JSlider slider_spark, slider_cool, slider_velocity;
    JLabel etiquetaTitulo, controlPrograma, valorSPARK, valorCOOL, valorVELOCITY,
            fuegoNormal, fuegoGris, fuegoSepia;
    JButton startButton, pauseButton, normalButton, grisButton, sepiaButton;

    public ControlPannel(MyFlame myflame) {
        this.myflame = myflame;
        this.setBackground(Color.decode("#D7D7A8"));
        this.setLayout(null);
        inicializarComponentes();
        this.setPreferredSize(new Dimension(450, 450));
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

        fuegoNormal = new JLabel("Fuego Normal");
        fuegoNormal.setBounds(50, 400, 150, 50);
        fuegoNormal.setFont(new Font("Serif", Font.PLAIN, 20));
        this.add(fuegoNormal);

        fuegoGris = new JLabel("Fuego Gris");
        fuegoGris.setBounds(260, 400, 100, 50);
        fuegoGris.setFont(new Font("Serif", Font.PLAIN, 20));
        this.add(fuegoGris);

        fuegoSepia = new JLabel("Fuego Sepia");
        fuegoSepia.setBounds(440, 400, 100, 50);
        fuegoSepia.setFont(new Font("Serif", Font.PLAIN, 20));
        this.add(fuegoSepia);
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
        slider_spark.setToolTipText("Valor_Puntos_Frios");
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
        slider_spark.setToolTipText("Valor_Velocidad");
        //Lineas Grandes
        slider_velocity.setMajorTickSpacing(50);
        //Lineas Pequeñas
        slider_velocity.setMinorTickSpacing(10);
        //Pintamos las barritas
        slider_velocity.setPaintTicks(true);
        //Pintamos Numeros
        slider_velocity.setPaintLabels(true);
        slider_velocity.setInverted(true);
        slider_velocity.setBounds(165, 325, 250, 45);
        slider_velocity.addChangeListener(e);
        this.add(slider_velocity);
    }

    private void addButton() {
        startButton = new JButton("Start");
        startButton.setBounds(165, 115, 75, 25);
        startButton.setEnabled(true);
        startButton.addActionListener(e);
        startButton.setActionCommand("Start");
        this.add(startButton);

        pauseButton = new JButton("Pause");
        pauseButton.setBounds(245, 115, 75, 25);
        pauseButton.setEnabled(true);
        pauseButton.addActionListener(e);
        pauseButton.setActionCommand("Pause");
        this.add(pauseButton);

        normalButton = new JButton();
        normalButton.setBounds(10, 450, 200, 200);
        normalButton.setBackground(Color.decode("#D7D7A8"));
        normalButton.setBorder(null);
        ImageIcon fn = new ImageIcon("src/main/java/Imagenes/fuego_normal.png");
        normalButton.setIcon(new ImageIcon(fn.getImage().getScaledInstance(
                normalButton.getWidth(), normalButton.getHeight(),
                Image.SCALE_SMOOTH)));
        normalButton.addActionListener(e);
        normalButton.setActionCommand("Normal");
        this.add(normalButton);

        grisButton = new JButton();
        grisButton.setBounds(200, 450, 200, 200);
        grisButton.setBackground(Color.decode("#D7D7A8"));
        grisButton.setBorder(null);
        ImageIcon fg = new ImageIcon("src/main/java/Imagenes/fuego_gris.png");
        grisButton.setIcon(new ImageIcon(fg.getImage().getScaledInstance(
                grisButton.getWidth(), grisButton.getHeight(),
                Image.SCALE_SMOOTH)));
        grisButton.addActionListener(e);
        grisButton.setActionCommand("Gris");
        this.add(grisButton);

        sepiaButton = new JButton();
        sepiaButton.setBounds(390, 450, 200, 200);
        sepiaButton.setBackground(Color.decode("#D7D7A8"));
        sepiaButton.setBorder(null);
        ImageIcon fs = new ImageIcon("src/main/java/Imagenes/fuego_sepia.png");
        sepiaButton.setIcon(new ImageIcon(fs.getImage().getScaledInstance(
                sepiaButton.getWidth(), sepiaButton.getHeight(),
                Image.SCALE_SMOOTH)));
        sepiaButton.addActionListener(e);
        sepiaButton.setActionCommand("Sepia");
        this.add(sepiaButton);
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
            if (e.getSource()==normalButton) {
                myflame.viewer.setvGris(false);
                myflame.viewer.setvSepia(false);
                myflame.viewer.setvNormal(true);

            }
            if (e.getSource()==grisButton) {
                myflame.viewer.setvNormal(false);
                myflame.viewer.setvSepia(false);
                myflame.viewer.setvGris(true);
            } 
            if(e.getSource()==sepiaButton) {
                myflame.viewer.setvNormal(false);
                myflame.viewer.setvGris(false);
                myflame.viewer.setvSepia(true);
            }
        }
    }
}