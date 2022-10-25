import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.ImageIcon;
import java.awt.GridBagLayout;
import java.awt.event.WindowEvent;

/**
 * <p>Pour creer une fenetre rapidement avec les methodes simplifier</p>
 * @author <a href="https://github.com/lalBi94">Bilal Boudjemline</a>
 * */

public class BFrame extends JFrame {
    private final String title;
    private int location_x = 1;
    private int location_y = 1;
    private int width = 500;
    private int height = 500;
    private int killProcess = 3;
    private boolean isOpen = false;

    /**
     * Avec le titre et mode de fermeture.
     *
     * @param title Le titre de la fenetre
     * @param oC    Mode de fermeture de la fenetre
     */
    public BFrame(String title, int oC) {
        this.title = title;
        this.killProcess = oC;
        initBFrame();
    }

    /**
     * Avec le titre, la taille (en L et l) et mode de fermeture.
     *
     * @param titlee Le titre de la fenetre
     * @param size_x La longueur de la fenetre
     * @param size_y La largeur y de la fenetre
     * @param oC     Mode de fermeture de la fenetre
     */
    public BFrame(String titlee, int size_x, int size_y, int oC) {
        this.title = titlee;
        this.width = size_x;
        this.height = size_y;
        this.killProcess = oC;
        initBFrame();
    }

    /**
     * Avec le titre, la locasation (en x et y), la taille (en L et l) et mode de fermeture.
     *
     * @param title  Le titre de la fenetre
     * @param loca_x La localisation en x de la fenetre
     * @param loca_y La localisation en y de la fenetre
     * @param size_x La longueur de la fenetre
     * @param size_y La largeur de la fenetre
     * @param oC     Mode de fermeture de la fenetre
     */
    public BFrame(String title, int loca_x, int loca_y, int size_x, int size_y, int oC) {
        this.title = title;
        this.location_x = loca_x;
        this.location_y = loca_y;
        this.width = size_x;
        this.height = size_y;
        this.killProcess = oC;
        initBFrame();
    }

    /**
     * Initialiser la fenetre
     */
    protected void initBFrame() {
        ImageIcon icon = new ImageIcon("assets/logo.png");
        this.setTitle(this.title);
        this.setLocation(this.location_x, this.location_y);
        this.setSize(this.width, this.height);
        this.setLayout(new GridBagLayout());
        this.setIconImage(icon.getImage());
        this.setDefaultCloseOperation(this.killProcess);
    }

    /**
     * Ouvrir la fenetre
     */
    public void openBFrame() {
        this.isOpen = true;
        this.setVisible(true);
    }

    /**
     * Fermer la fenetre
     */
    public void closeBFrame() {
        this.isOpen = false;
        this.setVisible(false);
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

    /**
     * Rafraichir la fenetre
     */
    public void refreshBFrame() {
        SwingUtilities.updateComponentTreeUI(this);
    }

    /**
     * Statut de visibilite de la fenetre
     */
    public boolean isVisible() {
        return this.isOpen;
    }

    @Override
    public String toString() {
        return this.title + ": is opened";
    }
}
