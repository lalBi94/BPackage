/* [BFrame]
*  Desc: To create Operationnal JFrame fast :)
*  GitHub: https://github.com/lalBi94
*  Created by: Bilal Boudjemline
*  28/09/2022 at 20:35
* */

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.ImageIcon;
import java.awt.GridBagLayout;

public class BFrame extends JFrame {
    public String title;
    public int location_x = 1;
    public int location_y = 1;
    public int width = 500;
    public int height = 500;
    public boolean isOpen = false;
    public int onClose = 3;

    public BFrame(String titlee, int oC) {
        this.title = titlee;
        this.onClose = oC;
        initBFrame();
    }

    public BFrame(String titlee, int size_x, int size_y, int oC) {
        this.title = titlee;
        this.width = size_x;
        this.height = size_y;
        this.onClose = oC;
        initBFrame();
    }

    public BFrame(String titlee, int loca_x, int loca_y, int size_x, int size_y, int oC) {
        this.title = titlee;
        this.location_x = loca_x;
        this.location_y = loca_y;
        this.width = size_x;
        this.height = size_y;
        this.onClose = oC;
        initBFrame();
    }

    protected void initBFrame() {
        ImageIcon icon = new ImageIcon("src/assets/img/logo.png");
        this.setTitle(this.title);
        this.setLocation(this.location_x, this.location_y);
        this.setSize(this.width, this.height);
        this.setLayout(new GridBagLayout());
        this.setIconImage(icon.getImage());
        this.setDefaultCloseOperation(this.onClose);
    }

    public void openBFrame() {
        this.isOpen = true;
        this.setVisible(true);
    }

    public void closeBFrame() {
        this.isOpen = false;
        this.setVisible(false);
    }

    public void refreshBFrame() {
        SwingUtilities.updateComponentTreeUI(this);
    }

    public boolean isVisible() {
        return this.isOpen;
    }

    @Override
    public String toString() {
        return this.title + ": is opened";
    }
}
