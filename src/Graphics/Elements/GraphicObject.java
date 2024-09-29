package Graphics.Elements;

import java.awt.*;

public abstract class GraphicObject {
    public int x, y;
    public Color color;
    public abstract void Draw(Graphics graphics);
}
