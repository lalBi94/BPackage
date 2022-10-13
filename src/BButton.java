/* [BButon]
 *  Desc: To create a CheckBox fast :)
 *  GitHub: https://github.com/lalBi94
 *  Created by: Bilal Boudjemline
 *  28/09/2022 at 20:35
 * */

import javax.swing.JButton;

public class BButton extends JButton {
    public String title;

    public BButton(String name) {
        super(name);
        this.title = name;
    }

    @Override
    public String toString() {
        return "Button name: " + this.title;
    }
}
