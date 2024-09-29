package Services.Graphics;

import FakeDIContainer.IService;
import Graphics.Elements.GraphicObject;
import Graphics.Elements.GraphicPass;

import java.util.ArrayList;

public interface IGraphicGatherer extends IService {
    void RegisterGraphicObject(GraphicObject object);
    ArrayList<GraphicObject> GetGraphicObjects();
}
