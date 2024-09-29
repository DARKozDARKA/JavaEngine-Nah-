package GameStates.States;

import GameStates.IState;

public class BootstrapState implements IState {
    @Override
    public void Enter() {
        System.out.println("entered");
    }

    @Override
    public void Exit() {
        System.out.println("left");

    }
}
