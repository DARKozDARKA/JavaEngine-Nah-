package Engine.Mains;

import Engine.Graphics.Elements.GraphicPass;
import Engine.Panels.GraphicPanel;
import Services.Graphics.IGraphicGatherer;
import Services.Input.InputDetector;
import Services.TickUpdater.ITickable;

import javax.swing.*;

public class MainWindow extends JFrame implements ITickable {

    private final IGraphicGatherer _graphicGatherer;
    private InputDetector _inputDetector;
    private GraphicPanel _mainPanel;

    public MainWindow(int width, int height, IGraphicGatherer graphicGatherer) {
        _graphicGatherer = graphicGatherer;
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
        GraphicPass pass = new GraphicPass(_graphicGatherer.GetGraphicObjects());
        _mainPanel.LoadPass(pass);
        _mainPanel.updateUI();
    }
}