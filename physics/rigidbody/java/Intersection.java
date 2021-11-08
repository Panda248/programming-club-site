package physics.rigidbody.java;

import org.joml.Vector2f;
import physics.primitives.java.AABB;
import physics.primitives.java.Box;
import physics.primitives.java.Circle;
import renderer.Line;

public class Intersection {
    public static boolean pointOnLine(Vector2f point, Line line){
        float dy = line.getEnd().y - line.getStart().y();
        float dx = line.getEnd().x - line.getStart().x();
        float m = dy/dx;

        float b = line.getEnd().y - (m*line.getEnd().x);

        return point.y == m*point.x+b;
    }

    public static boolean pointInCircle(Vector2f point, Circle circle){
        Vector2f center = circle.getCenter();
        Vector2f centerToPoint = new Vector2f(point).sub(center);

        return centerToPoint.lengthSquared() < circle.getRadius() * circle.getRadius();
    }

    public static boolean pointInAABB(Vector2f point, AABB box){
        Vector2f min = box.getMin();
        Vector2f max = box.getMax();

        return point.x <= max.x && min.x <= point.x && point.y <= max.y && min.y <= point.y;
    }

   /* TODO : public static boolean pointInBox(Vector2f point, Box box){


       return ;
   }*/
}
