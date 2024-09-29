package Panels;

import Graphics.Elements.GraphicObject;
import Graphics.Elements.GraphicPass;

import javax.swing.*;
import java.awt.*;

public class GraphicPanel extends JPanel {

    private GraphicPass pass = new GraphicPass();

    public void loadPass(GraphicPass pass){

        this.pass = pass;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (GraphicObject object : pass.Objects) {
            object.Draw(g);
        }
    }
}
