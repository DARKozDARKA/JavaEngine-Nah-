package Content.ActorComponents;

import Engine.Graphics.Elements.GraphicObject;
import Engine.Graphics.Elements.GraphicRect;
import Services.Graphics.IGraphicGatherer;

public class RenderComponent extends ActorComponent {

    private final IGraphicGatherer _graphicGatherer;
    private TransformComponent _transform;
    private GraphicObject _graphicObject;

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
}
