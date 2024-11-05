package Engine.GameStates.States;

import Content.ActorComponents.RandomMoverComponent;
import Content.ActorComponents.RigidbodyComponent;
import Content.Actors.Actor;
import Engine.Data.Vector;
import Engine.GameStates.IState;
import Services.Factories.IActorFactory;
import Services.Graphics.IGraphicGatherer;

public class GameLoopState implements IState {

    private final IActorFactory _actorFactory;

    public GameLoopState(IGraphicGatherer graphicGatherer, IActorFactory actorFactory){
        _actorFactory = actorFactory;
    }

    @Override
    public void Enter() {
        for (int i = 0; i < 10000; i++){
            Actor actor = _actorFactory.CreateActor(new Vector((int)(Math.random() * 800), (int)(Math.random() * 200)), new Vector((int)(Math.random() * 10), (int)(Math.random() * 25)));
            actor.AddComponent(new RigidbodyComponent());
        }

    }

    @Override
    public void Exit() {

    }
}
