/* [BLabel]
 *  Desc: To create Operationnal JLabel fast :)
 *  GitHub: https://github.com/lalBi94
 *  Created by: Bilal Boudjemline
 *  28/09/2022 at 20:35
 * */

import javax.swing.JLabel;

public class BLabel extends JLabel {
    public String title = " ";

    public BLabel(String titleOfLabel) {
        super(titleOfLabel);
        this.title = titleOfLabel;
    }

    @Override
    public String toString() {
        return "JLabel value is: " + this.title;
    }
}
