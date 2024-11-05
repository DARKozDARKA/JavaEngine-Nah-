package Services.Graphics;

import Engine.Graphics.Elements.GraphicObject;

import java.util.ArrayList;

public class GraphicGatherer implements IGraphicGatherer {

    private ArrayList<GraphicObject> _objects = new ArrayList<>();

    @Override
    public void RegisterGraphicObject(GraphicObject object) {
        _objects.add(object);
    }

    @Override
    public void UnregisterGraphicObject(GraphicObject object) {
        _objects.remove(object);
    }

    @Override
    public ArrayList<GraphicObject> GetGraphicObjects() {
        return _objects;
    }
}
