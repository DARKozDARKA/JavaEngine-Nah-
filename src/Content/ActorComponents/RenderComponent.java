package Content.ActorComponents;

import Engine.Graphics.Elements.GraphicObject;
import Engine.Graphics.Elements.GraphicRect;
import Services.Graphics.IGraphicGatherer;
import Services.TickUpdater.ITickable;

public class RenderComponent extends ActorComponent implements ITickable {

    private final IGraphicGatherer _graphicGatherer;
    private TransformComponent _transform;
    private GraphicRect _graphicObject;

    public RenderComponent(IGraphicGatherer graphicGatherer){
        _graphicGatherer = graphicGatherer;
    }

    @Override
    public void Awake() {
        super.Awake();
        _transform = GetParent().GetComponent(TransformComponent.class);
    }

    @Override
    public void Start() {
        super.Start();

        _graphicObject = new GraphicRect(_transform.Position, _transform.Size);
        _graphicGatherer.RegisterGraphicObject(_graphicObject);
    }

    @Override
    public void Destroy() {
        super.Destroy();
        _graphicGatherer.UnregisterGraphicObject(_graphicObject);
    }

    @Override
    public void Tick(float deltaTime) {
        super.Tick(deltaTime);
        _graphicObject.x = _transform.Position.x;
        _graphicObject.y = _transform.Position.y;
        _graphicObject.weight = _transform.Size.x;
        _graphicObject.height = _transform.Size.y;
    }
}
