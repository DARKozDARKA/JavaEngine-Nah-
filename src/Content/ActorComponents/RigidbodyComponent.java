package Content.ActorComponents;

import Content.Actors.Actor;
import Engine.Data.Vector;
import Engine.FakeDIContainer.AllServices;
import Services.Factories.IActorFactory;
import Services.TickUpdater.ITickable;

public class RigidbodyComponent extends ActorComponent {
    private TransformComponent _transformComponent;
    private float _second;
    private final float _gravity = 9.8f;
    private final float _airForce = 1000;
    private float _force;
    private float _maxForce = 100;
    private float _mass;

    @Override
    public void Awake() {
        super.Awake();
        _transformComponent = GetParent().GetComponent(TransformComponent.class);
    }

    @Override
    public void Tick(float deltaTime) {
        super.Tick(deltaTime);

        _mass = _transformComponent.Size.x * _transformComponent.Size.y;

        if (_transformComponent.Position.y + _transformComponent.Size.y < 800)
            _transformComponent.Position.y = _transformComponent.Position.y - (int)_force;
        else{
            //IActorFactory actorFactory = AllServices.GetInstance().single(IActorFactory.class);
            //Actor actor = actorFactory.CreateActor(new Vector((int)(Math.random() * 800), (int)(Math.random() * 200)), new Vector((int)(Math.random() * 150), (int)(Math.random() * 150)));
            //actor.AddComponent(new RigidbodyComponent());
            //GetParent().Destroy();
            _transformComponent.Position.y = -300;
            _force = 0;
        }
        _force = Math.clamp(_force - _gravity * deltaTime * _mass / _airForce, -100, _maxForce);
    }
}
