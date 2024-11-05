package Services.Factories;

import Content.ActorComponents.RenderComponent;
import Content.ActorComponents.TransformComponent;
import Content.Actors.Actor;
import Engine.Data.Vector;
import Engine.FakeDIContainer.AllServices;
import Services.Graphics.IGraphicGatherer;
import Services.TickUpdater.ITickUpdater;

public class ActorFactory implements IActorFactory {

    private final AllServices _diContainer;
    private final ITickUpdater _tickUpdater;

    public ActorFactory(AllServices diContainer, ITickUpdater tickUpdater){
        _diContainer = diContainer;
        _tickUpdater = tickUpdater;
    }
    @Override
    public Actor CreateActor() {
        Actor newActor = new Actor();
        newActor.AddComponent(new TransformComponent());
        newActor.AddComponent(new RenderComponent(_diContainer.single(IGraphicGatherer.class)));
        _tickUpdater.RegisterTickable(newActor);
        return newActor;
    }

    @Override
    public Actor CreateActor(Vector position, Vector size) {
        Actor newActor = new Actor();
        TransformComponent transformComponent = newActor.AddComponent(new TransformComponent());
        transformComponent.Position = position;
        transformComponent.Size = size;
        newActor.AddComponent(new RenderComponent(_diContainer.single(IGraphicGatherer.class)));
        _tickUpdater.RegisterTickable(newActor);
        return newActor;
    }
}
