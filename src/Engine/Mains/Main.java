package Engine.Mains;

import Engine.FakeDIContainer.AllServices;
import Engine.GameStates.GameStateMachine;
import Engine.GameStates.States.BootstrapState;
import Services.Graphics.IGraphicGatherer;
import Engine.StaticData.StaticData;

public class Main {
    public static void main(String[] args) {
        AllServices diContainer = AllServices.GetInstance();
        ServiceRegisterer serviceRegisterer = new ServiceRegisterer();
        RegisterServicesAndMainWindow(serviceRegisterer, diContainer);
        RegisterStateMachine(diContainer);
    }

    private static void RegisterServicesAndMainWindow(ServiceRegisterer serviceRegisterer, AllServices diContainer) {
        serviceRegisterer.RegisterIndependentServices(diContainer);
        MainWindow gameWindow = new MainWindow(StaticData.WINDOW_WIDTH, StaticData.WINDOW_HEIGHT, diContainer.single(IGraphicGatherer.class));
        serviceRegisterer.RegisterWindowDependentServices(diContainer, gameWindow);
    }

    private static void RegisterStateMachine(AllServices diContainer) {
        GameStateMachine gameStateMachine = new GameStateMachine();
        gameStateMachine.RegisterStates(diContainer);
        gameStateMachine.Enter(BootstrapState.class);
    }
}
