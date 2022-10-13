/* [BImage]
 *  Desc: To create Operationnal JLabel Image fast :)
 *  GitHub: https://github.com/lalBi94
 *  Created by: Bilal Boudjemline
 *  28/09/2022 at 20:35
 * */

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class BImage extends JLabel {
    public JLabel image;

    public BImage(String path) throws IOException {
        this.image = new JLabel(new ImageIcon(ImageIO.read(new File(path))));
    }

    public JLabel getImage() {
        return this.image;
    }
}
