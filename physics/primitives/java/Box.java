package physics.primitives.java;


import org.newdawn.slick.Graphics;
import org.w3c.dom.css.Rect;
import org.joml.Vector2f;
import physics.rigidbody.java.Rigidbody;
import java.util.Vector;

public class Box {
    private Vector2f size = new Vector2f();
    private Vector2f halfSize = new Vector2f();
    private float width;
    private float height;
    private float x;
    private float y;
    private float xVel = 0f;
    private float yVel = 0f;
    private float xAccel = 1f;
    private float yAccel = 1f;
    private boolean right;
    private boolean up;
    public Collider collider;
    private Rigidbody rigidbody = null;

    public float getWidth()
    {
        return this.width;
    }
    public float getHeight()
    {
        return this.height;
    }
    public float getX()
    {
        return this.x;
    }
    public float getY()
    {
        return this.y;
    }
    public float getXVel()
    {
        return this.xVel;
    }
    public float getYVel()
    {
        return this.yVel;
    }
    public float getXAccel()
    {
        return this.xAccel;
    }
    public float getYAccel()
    {
        return this.yAccel;
    }
    public void setX(float amount)
    {
        this.x = amount;
    }
    public void setY(float amount)
    {
        this.y = amount;
    }
    public void setXAccel(float amount)
    {
        this.xAccel = amount;
    }
    public void setYAccel(float amount) {this.yAccel = amount;}
    public void setXVel( float amount)
    {
        this.xVel = amount;
    }
    public void setYVel(float amount)
    {
        this.yVel = amount;
    }

    public Box(){
        this.halfSize = new Vector2f(size).mul(0.5f);
    }
    public Box(float x, float y, float width, float height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public Box(Vector2f min, Vector2f max){
        this.size = new Vector2f(max).sub(min);
        this.halfSize = new Vector2f(max).sub(min);
    }

    public void createCollider()
    {
        collider = new Collider();
        collider.width = this.width;
        collider.height = this.height;
        collider.x = this.x;
        collider.y = this.y;
    }
    public void bounce(Collider collidee)
    {
        if(collider.isColliding(collidee)) {
            if (collider.isCollidingSide(collidee)) {
                this.x = collidee.getX() - collidee.getWidth()-1;
                this.xAccel *= -0.2f;
                this.xVel *= -.1f;

            }
            else if (collider.isCollidingTop(collidee)) {
                this.y = collidee.getY() - collidee.getHeight() - 1;
                this.yAccel *= -0.2f;
                this.yVel *= -.1f;
            }
        }
    }


    public Vector2f getMin(){
        return new Vector2f(this.rigidbody.getPosition()).sub(this.halfSize);
    }

    public Vector2f getMax(){
        return new Vector2f(this.rigidbody.getPosition()).add(this.halfSize);
    }

    public Vector2f[] getVertices(){
        Vector2f min = getMin();
        Vector2f max = getMax();

        Vector2f[] vertices = {new Vector2f(min.x, min.y), new Vector2f(min.x, max.y), new Vector2f(max.x, min.y), new Vector2f(max.x, max.y)};

       /*if (rigidbody.getRotation() != 0.0f){
           for (Vector2f vert : vertices){
                //TODO : implement rotation
               JMath.rotate(vert, this.rigidbody.getPosition(), this.rigidbody.getRotation());
          }
       }*/
        return vertices;
    }
}
