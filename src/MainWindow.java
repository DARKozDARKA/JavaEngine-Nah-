import Graphics.Elements.GraphicObject;
import Graphics.Elements.GraphicPass;
import Graphics.Elements.GraphicRect;
import Panels.GraphicPanel;
import Services.Input.InputDetector;
import Services.TickUpdater.ITickable;

import javax.swing.*;
import java.awt.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class MainWindow extends JFrame implements ITickable {

    private InputDetector _inputDetector;
    private GraphicPanel _mainPanel;
    int step;
    int innerStep;
    Boolean state = true;

    public MainWindow(int width, int height) {
        _mainPanel = CreateWindow(width, height);
    }

    private GraphicPanel CreateWindow(int width, int height) {
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GraphicPanel panel = new GraphicPanel();


        setContentPane(panel);
        setVisible(true);
        return panel;
    }

    @Override
    public void Tick(float deltaTime) {
        _mainPanel.updateUI();
    }
}