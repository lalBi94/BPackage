/* [BCheckBox]
 *  Desc: To create a CheckBox fast :)
 *  GitHub: https://github.com/lalBi94
 *  Created by: Bilal Boudjemline
 *  28/09/2022 at 20:35
 * */

import javax.swing.JCheckBox;

public class BCheckBox extends JCheckBox {
    public String choice;

    public BCheckBox(String theChoice) {
        super(theChoice);
        this.choice = theChoice;
    }

    @Override
    public String toString() {
        return "Choice: " + this.choice;
    }
}
