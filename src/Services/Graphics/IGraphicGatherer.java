package Services.Graphics;

import Engine.FakeDIContainer.IService;
import Engine.Graphics.Elements.GraphicObject;

import java.util.ArrayList;

public interface IGraphicGatherer extends IService {
    void RegisterGraphicObject(GraphicObject object);
    ArrayList<GraphicObject> GetGraphicObjects();
}
