package Engine.Graphics.Elements;

import java.util.ArrayList;

public class GraphicPass {
    public GraphicPass() {
        Objects = new ArrayList<>();
    }

    public GraphicPass(ArrayList<GraphicObject> objects) {
        Objects = objects;
    }

    public ArrayList<GraphicObject> Objects;
}
