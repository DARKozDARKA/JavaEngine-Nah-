package Engine.GameStates.States;

import Engine.GameStates.IState;
import Services.Graphics.IGraphicGatherer;

public class GameLoopState implements IState {

    private final IGraphicGatherer _graphicGatherer;

    public GameLoopState(IGraphicGatherer graphicGatherer){
        _graphicGatherer = graphicGatherer;
    }

    @Override
    public void Enter() {

    }

    @Override
    public void Exit() {

    }
}
