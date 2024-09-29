package GameStates;

import GameStates.States.BootstrapState;

import java.util.Map;
import java.util.HashMap;

public class GameStateMachine {
    private Map<Class<?>, IExitableState> _states;
    private IExitableState _currentState;

    public void CreateStates() {
        Map<Class<?>, IExitableState> states = new HashMap<>();
        states.put(BootstrapState.class, new BootstrapState());
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