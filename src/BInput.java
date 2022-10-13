/* [BInput]
 *  Desc: To create Operationnal JTextfield fast :)
 *  GitHub: https://github.com/lalBi94
 *  Created by: Bilal Boudjemline
 *  28/09/2022 at 20:35
 * */

import javax.swing.JTextField;
import java.awt.*;

public class BInput extends JTextField {
    public int width = 100;
    public int height = 50;
    public String inner;
    public Color color = Color.BLACK;

    public BInput(String in) {
        this.inner = in;
        this.setText(in);
    }

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
