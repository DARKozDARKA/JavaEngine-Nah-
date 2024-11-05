package Content.ActorComponents;

import Engine.Data.Vector;

import java.io.Console;
import java.util.Random;

public class RandomMoverComponent extends ActorComponent {

    private TransformComponent _transformComponent;
    private float _second;

    @Override
    public void Awake() {
        super.Awake();
        _transformComponent = GetParent().GetComponent(TransformComponent.class);
    }

    @Override
    public void Tick(float deltaTime) {
        super.Tick(deltaTime);
        _second += deltaTime;
        if (_second > 1){
            _transformComponent.Position = new Vector((int)(Math.random() * 800), (int)(Math.random() * 600));
            _second = 0;
        }
    }
}
