package Services.Factories;

import Content.Actors.Actor;
import Engine.Data.Vector;
import Engine.FakeDIContainer.IService;

public interface IActorFactory extends IService {
     Actor CreateActor();
     Actor CreateActor(Vector position, Vector size);

}
