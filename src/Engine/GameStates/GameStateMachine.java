package Engine.GameStates;

import Engine.FakeDIContainer.AllServices;
import Engine.GameStates.States.BootstrapState;
import Engine.GameStates.States.GameLoopState;
import Services.Factories.IActorFactory;
import Services.Graphics.IGraphicGatherer;

import java.util.Map;
import java.util.HashMap;

public class GameStateMachine {
    private Map<Class<?>, IExitableState> _states;
    private IExitableState _currentState;

    public void RegisterStates(AllServices allServices) {
        Map<Class<?>, IExitableState> states = new HashMap<>();
        states.put(BootstrapState.class, new BootstrapState(allServices, this));
        states.put(GameLoopState.class, new GameLoopState(allServices.single(IGraphicGatherer.class), allServices.single(IActorFactory.class)));
        _states = states;
    }

    public <TState extends IState> void Enter(Class<TState> stateClass) {
        TState state = LoadState(stateClass);
        state.Enter();
    }

    public <TState extends IPayloadedState<TPayload>, TPayload> void Enter(Class<TState> stateClass, TPayload payload) {
        TState state = LoadState(stateClass);
        state.Enter(payload);
    }

    private <TState extends IExitableState> TState LoadState(Class<TState> stateClass) {
        if (_currentState != null) {
            _currentState.Exit();
        }
        TState state = GetState(stateClass);
        _currentState = state;
        return state;
    }

    private <TState extends IExitableState> TState GetState(Class<TState> stateClass) {
        return stateClass.cast(_states.get(stateClass));
    }
}