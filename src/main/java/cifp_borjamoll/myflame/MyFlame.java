package cifp_borjamoll.myflame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author Roberto
 */
public class MyFlame extends JFrame {

    Thread thread;
    Viewer viewer;
    ControlPannel controlpannel;
    Flame flame;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyFlame myflame = new MyFlame();
    }

    public MyFlame() {
        super("Hoguera");
        flame = new Flame(300, 300, 1);
        controlpannel = new ControlPannel(this);
        this.setLayout(new GridLayout());
        JPanel pannel = new JPanel();
        pannel.setLayout(new GridLayout());
        viewer = new Viewer(flame);
        pannel.add(controlpannel);
        pannel.add(viewer);
        viewer.setBackground(Color.decode("#D7D7A8"));
        this.add(pannel);
        this.setSize(1500, 810);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        thread = new Thread(viewer);
        thread.start();
    }

    public void pauseThread() {
        flame.setActiveThread(false);
    }

    public void startThread() {
        flame.setActiveThread(true);
    }

    public void setSPARK(int SPARK) {
        flame.setSPARK(SPARK);
    }

    public int getSPARK() {
        return flame.getSPARK();
    }

    public void setCOOL(int COOL) {
        flame.setCOOL(COOL);
    }

    public int getCOOL() {
        return flame.getCOOL();
    }

    public void setVELOCITY(int VELOCITY) {
        flame.setVELOCITY(VELOCITY);
    }

    public int getVELOCITY() {
        return flame.getVELOCITY();
    }
}
