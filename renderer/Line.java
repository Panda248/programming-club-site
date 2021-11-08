package renderer;
import org.joml.Vector2f;
import org.joml.Vector3f;

import java.util.Vector;

public class Line {
    private Vector2f from;
    private Vector2f to;
    private Vector3f color;
    private int lifetime;

    public Line(Vector2f from, Vector2f to) {
        this.from = from;
        this.to = to;

    }

    public Line(Vector2f from, Vector2f to, Vector3f color, int lifetime) {
        this.from = from;
        this.to = to;
        this.color = color;
        this.lifetime = lifetime;
    }

    public int beginFrame(){
        this.lifetime--;
        return this.lifetime;
    }

    public Vector2f getFrom() {
        return from;
    }

    public Vector2f getTo() {
        return to;
    }

    public Vector3f getColor() {
        return color;
    }

    public int getLifetime() {
        return lifetime;
    }

    public Vector2f getStart(){
        return this.from;
    }

    public Vector2f getEnd(){
        return this.to;
    }
}
