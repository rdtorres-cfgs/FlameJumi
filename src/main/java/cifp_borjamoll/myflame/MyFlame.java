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
        this.add(pannel);
        this.setSize(1400, 810);
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
/*
    public MyFlame (){
        super("Hoguera");
        controlpannel = new ControlPannel();
        
        this.setLayout(new GridLayout());
        JPanel pannel = new JPanel();
        pannel.setLayout(new GridLayout());
        viewer = new Viewer();
        pannel.add(controlpannel);
        pannel.add(viewer);
        this.add (pannel);
        this.setSize(2000,2000);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        thread = new Thread(viewer);
        thread.start();
    }
    
    private void createControlPannelLayout(){
        controlpannel = new ControlPannel();
        
        controlpannel.setMaximumSize(new Dimension(600,200));
        controlpannel.setMinimumSize(new Dimension(600,200));
        
        GridBagConstraints GridBagConstraints = new GridBagConstraints();
        GridBagConstraints.fill = GridBagConstraints.BOTH;
        GridBagConstraints.gridx = 0;
        GridBagConstraints.gridy = 0;
        GridBagConstraints.weightx = 0.0f;
        GridBagConstraints.weighty = 1f;
        this.add(controlpannel, GridBagConstraints);
    }
    
    private void createViewerlLayout(){
        this.setLayout(new GridBagLayout());
        viewer = new Viewer();
        GridBagConstraints GridBagConstraints = new GridBagConstraints();
        GridBagConstraints.gridx = 1;
        GridBagConstraints.weightx = 0.8f;
        GridBagConstraints.weighty = 1f;
        this.add(viewer, GridBagConstraints);
        
        this.setSize(2000,2000);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }*/
