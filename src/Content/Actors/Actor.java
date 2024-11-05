package Content.Actors;

import Content.ActorComponents.ActorComponent;
import Services.TickUpdater.ITickable;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class Actor implements ITickable {

    private Map<Type, ActorComponent> _components = new HashMap<>();
    private Boolean _awakened = false;
    private Boolean _started = false;

    public void Awake(){
        for (ActorComponent component : _components.values()) {
            component.Awake();
        }
        _awakened = true;
    }

    public void Start(){
        for (ActorComponent component : _components.values()) {
            component.Start();
        }
        _started = true;
    }

    public void Destroy(){
        for (ActorComponent component : _components.values()) {
            component.Destroy();
        }
    }

    public <T extends ActorComponent> T GetComponent(Class<T> type) {
        return type.cast(_components.get(type));
    }

    public <T extends ActorComponent> T AddComponent(T component) {
        try {
            _components.put(component.getClass(), component);
            component.SetParent(this);
            component.Initialize();
            if (!_awakened) {
                component.Awake();
            }
            if (!_started) {
                component.Start();
            }
            return component;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void Tick(float deltaTime) {
        for (ActorComponent component : _components.values()) {
            component.Tick(deltaTime);
        }
    }
}
