package Engine.Panels;

import Engine.Graphics.Elements.GraphicObject;
import Engine.Graphics.Elements.GraphicPass;

import javax.swing.*;
import java.awt.*;

public class GraphicPanel extends JPanel {

    private GraphicPass _pass = new GraphicPass();

    public void LoadPass(GraphicPass pass){

        _pass = pass;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (GraphicObject object : _pass.Objects) {
            object.Draw(g);
        }
    }
}
