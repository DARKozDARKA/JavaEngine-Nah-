package GameStates;

public interface IPayloadedState<TPayload> extends IExitableState {
    void Enter(TPayload payload);
}