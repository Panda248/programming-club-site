package physics.primitives.java;


//import components.Component;

public class Collider {
    public float width;
    public float height;
    public float x;
    public float y;
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
    public void setX(int amount)
    {
        this.x = amount;
    }
    public void setY(int amount)
    {
        this.y = amount;
    }
    public void update(float x, float y, float width, float height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public boolean isColliding(Collider collider)
    {
        return isCollidingTop(collider) || isCollidingSide(collider);
    }
    public boolean isCollidingTop(Collider collider)
    {
        return ((this.y + this.height >= collider.y && this.y + this.height <= collider.y + collider.height)
                ||  (this.y >= collider.y && this.y  <= collider.y + collider.getHeight()))
                && ((this.x < collider.getX() || this.x > collider.getX() + collider.getWidth())
                ||  (this.x - this.getWidth() < collider.getX() || this.x - this.getWidth() > collider.getX() + collider.getWidth()));
    }
    public boolean isCollidingSide(Collider collider)
    {
        return ((this.x >= collider.x && this.x <= collider.x + collider.getWidth())
                ||(this.x + this.width >= collider.x && this.x +this.width <= collider.x + collider.getWidth()))
                && ((this.y  < collider.getY() || this.y > collider.getY() - collider.getHeight())
                || (this.y + this.getHeight() < collider.getY() || this.y + this.getHeight() > collider.getY() + collider.getHeight()));
    }
}

