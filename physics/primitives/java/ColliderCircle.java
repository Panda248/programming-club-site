package physics.primitives.java;

import physics.rigidbody.java.Intersection;

public class ColliderCircle {
    private float radius;
    private float x;
    private float y;

    public float getRadius()
    {
        return this.radius;
    }
    public float getX()
    {
        return this.x;
    }
    public float getY()
    {
        return this.y;
    }
    public void setX(float amount)
    {
        this.x = amount;
    }
    public void setY(float amount)
    {
        this.y = amount;
    }
    public void setRadius(float amount)
    {
        this.radius = amount;
    }
    public boolean isColliding()
    {
        //if()
        //{
        return true;
        //}
    }
}
