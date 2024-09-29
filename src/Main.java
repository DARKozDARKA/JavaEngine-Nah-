import FakeDIContainer.AllServices;
import GameStates.GameStateMachine;
import GameStates.States.BootstrapState;
import Services.Graphics.GraphicGatherer;
import Services.Graphics.IGraphicGatherer;
import Services.Input.IInputDetector;
import Services.Input.InputDetector;
import Services.TickUpdater.ITickUpdater;
import Services.TickUpdater.TickUpdater;

public class Main {
    public static void main(String[] args) {
        int windowWidth = 800;
        int windowHeight = 800;

        MainWindow gameWindow = new MainWindow(windowWidth, windowHeight);

        AllServices diContainer = AllServices.GetInstance();

        GameStateMachine gameStateMachine = new GameStateMachine();
        gameStateMachine.CreateStates();
        gameStateMachine.Enter(BootstrapState.class);
        gameStateMachine.Enter(BootstrapState.class);
        RegisterServices(diContainer, gameWindow);
    }

    private static void RegisterServices(AllServices diContainer, MainWindow gameWindow) {
        RegisterTickUpdater(diContainer, gameWindow);
        RegisterInputDetector(diContainer, gameWindow);
        RegisterGraphicGatherer(diContainer);
    }

    private static void RegisterTickUpdater(AllServices diContainer, MainWindow window) {
        ITickUpdater tickUpdater = new TickUpdater();
        diContainer.registerSingle(ITickUpdater.class, tickUpdater);
        tickUpdater.RegisterTickable(window);

        tickUpdater.Start();
    }

    private static void RegisterInputDetector(AllServices diContainer, MainWindow gameWindow) {
        IInputDetector inputDetector = new InputDetector();
        diContainer.registerSingle(IInputDetector.class, inputDetector);

        gameWindow.addKeyListener(inputDetector);
        gameWindow.addMouseListener(inputDetector);
    }

    private static void RegisterGraphicGatherer(AllServices diContainer) {
        diContainer.registerSingle(IGraphicGatherer.class, new GraphicGatherer());
    }
}
