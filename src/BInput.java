import javax.swing.JTextField;
import java.awt.*;

public class BInput extends JTextField {
    public int width = 100;
    public int height = 50;
    public Color color = Color.BLACK;

    public BInput() {}

    public BInput(int w, int h) {
        this.width = w;
        this.height = h;
        this.setPreferredSize(new Dimension(w, h));
    }

    public BInput(int w, int h, Color c) {
        this.width = w;
        this.height = h;
        this.color = c;
        this.setPreferredSize(new Dimension(w, h));
        this.setBackground(this.color);
    }

    public void setSize(int w, int h) {
        this.width = w;
        this.height = h;
        this.setPreferredSize(new Dimension(w, h));
    }

    @Override
    public String toString() {
        return this.width + "\n" + this.height;
    }
}
