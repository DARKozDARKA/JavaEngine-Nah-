package Engine.Graphics.Elements;

import Engine.Data.Vector;

import java.awt.*;

public class GraphicRect extends GraphicObject {
    public int height, weight = 5;

    public GraphicRect() {
        color = Color.BLACK;
    }

    public GraphicRect(int x, int y, int height, int weight) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.weight = weight;
        color = Color.BLACK;
    }

    public GraphicRect(Vector position, Vector size) {
        x = position.x;
        y = position.y;
        weight = size.x;
        height = size.y;
        color = Color.BLACK;
    }

    public GraphicRect(int x, int y, int height, int weight, Color color) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.weight = weight;
        this.color = color;
    }

    @Override
    public void Draw(Graphics graphics) {
        graphics.setColor(color);
        graphics.fillRect(x, y, weight, height);
    }
}
