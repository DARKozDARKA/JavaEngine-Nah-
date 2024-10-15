package Engine.GameStates.States;

import Engine.FakeDIContainer.AllServices;
import Engine.GameStates.GameStateMachine;
import Engine.GameStates.IState;

public class BootstrapState implements IState {

    private final AllServices _diContainer;
    private final GameStateMachine _gameStateMachine;

    public BootstrapState(AllServices diContainer, GameStateMachine gameStateMachine) {

        _diContainer = diContainer;
        _gameStateMachine = gameStateMachine;
    }

    @Override
    public void Enter() {
        _gameStateMachine.Enter(GameLoopState.class);
    }

    @Override
    public void Exit() {

    }


}
