package Engine.Mains;

import Engine.FakeDIContainer.AllServices;
import Services.Graphics.GraphicGatherer;
import Services.Graphics.IGraphicGatherer;
import Services.Input.IInputDetector;
import Services.Input.InputDetector;
import Services.TickUpdater.ITickUpdater;
import Services.TickUpdater.TickUpdater;

public class ServiceRegisterer {
    public void RegisterIndependentServices(AllServices diContainer) {
        RegisterGraphicGatherer(diContainer);
    }

    public void RegisterWindowDependentServices(AllServices diContainer, MainWindow gameWindow) {
        RegisterTickUpdater(diContainer, gameWindow);
        RegisterInputDetector(diContainer, gameWindow);
    }

    private void RegisterTickUpdater(AllServices diContainer, MainWindow window) {
        ITickUpdater tickUpdater = new TickUpdater();
        diContainer.registerSingle(ITickUpdater.class, tickUpdater);
        tickUpdater.RegisterTickable(window);

        tickUpdater.Start();
    }

    private void RegisterInputDetector(AllServices diContainer, MainWindow gameWindow) {
        IInputDetector inputDetector = new InputDetector();
        diContainer.registerSingle(IInputDetector.class, inputDetector);

        gameWindow.addKeyListener(inputDetector);
        gameWindow.addMouseListener(inputDetector);
    }

    private void RegisterGraphicGatherer(AllServices diContainer) {
        diContainer.registerSingle(IGraphicGatherer.class, new GraphicGatherer());
    }
}