package Content.ActorComponents;

import Content.Actors.Actor;

public class ActorComponent {
    private Actor _parent;
    public final void SetParent(Actor parent){
        _parent = parent;
    }
    public final Actor GetParent(){
        return _parent;
    }
    public void Initialize(){}
    public void Awake(){}
    public void Start(){}
}
