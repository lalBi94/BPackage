/* [BLayout]
 *  Desc: To create a layout fast :)
 *  GitHub: https://github.com/lalBi94
 *  Created by: Bilal Boudjemline
 *  28/09/2022 at 20:35
 * */

import java.awt.GridBagConstraints;
import java.awt.Insets;

public class BLayout extends GridBagConstraints {
    public int PositionOnX = 0;
    public int PositionOnY = 0;
    public int takeCaseOnX = 0;
    public int takeCaseOnY = 0;
    public double sizeOnX = 0.0f;
    public double sizeOnY = 0.0f;
    public int padding_top = 1;
    public int padding_left = 1;
    public int padding_bottom = 1;
    public int padding_right = 1;
    public Insets padding = new Insets(this.padding_top, this.padding_left, this.padding_bottom, this.padding_right);
    public int positionOnScreen = GridBagConstraints.NORTH;
    public int filler = GridBagConstraints.BASELINE;

    public BLayout() {
        initLayout();
    }

    public BLayout(int positionX, int positionY, int manyCaseX, int manyCaseY, double sizeX,
            double sizeY, Insets pad, int positionOnScreen, int filling) {
        this.PositionOnX = positionX;
        this.PositionOnY = positionY;
        this.takeCaseOnX = manyCaseX;
        this.takeCaseOnY = manyCaseY;
        this.sizeOnX = sizeX;
        this.sizeOnY = sizeY;
        this.padding_top = pad.top;
        this.padding_left = pad.left;
        this.padding_bottom = pad.bottom;
        this.padding_right = pad.right;
        this.padding = pad;
        this.positionOnScreen = positionOnScreen;
        this.filler = filling;
        initLayout();
    }

    private void initLayout() {
        this.gridx = this.PositionOnX;
        this.gridy = this.PositionOnY;
        this.gridheight = this.takeCaseOnX;
        this.gridwidth = this.takeCaseOnY;
        this.weightx = this.sizeOnX;
        this.weighty = this.sizeOnY;
        this.insets = this.padding;
        this.anchor = this.positionOnScreen;
        this.fill = this.filler;
    }

    public void setPositionX(int by) {
        this.PositionOnX = by;
        initLayout();
    }

    public void setPositionY(int by) {
        this.PositionOnY = by;
        initLayout();
    }

    public void setTakeCaseOnX(int by) {
        this.takeCaseOnX = by;
        initLayout();
    }

    public void setTakeCaseOnY(int by) {
        this.takeCaseOnY = by;
        initLayout();
    }

    public void setSizeX(double by) {
        this.sizeOnX = by;
        initLayout();
    }

    public void setSizeY(double by) {
        this.sizeOnY = by;
        initLayout();
    }

    public void setPadding(Insets by) {
        this.padding = by;
        initLayout();
    }

    public void setAnchor(int by) {
        this.positionOnScreen = by;
        initLayout();
    }

    public void setFill(int by) {
        this.filler = by;
        initLayout();
    }
}
