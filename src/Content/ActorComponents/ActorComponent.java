package Content.ActorComponents;

import Content.Actors.Actor;
import Services.TickUpdater.ITickable;

public class ActorComponent implements ITickable {
    private Actor _parent;
    public ActorComponent(){}
    public final void SetParent(Actor parent){
        _parent = parent;
    }
    public final Actor GetParent(){
        return _parent;
    }
    public void Initialize(){}
    public void Awake(){}
    public void Start(){}
    public void Destroy(){}

    @Override
    public void Tick(float deltaTime) {

    }
}
