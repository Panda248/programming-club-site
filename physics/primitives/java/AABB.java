package physics.primitives.java;

//import org.newdawn.slick.geom.Vector2f;
import org.joml.Vector2f;
import physics.rigidbody.java.Rigidbody;

public class AABB {
    private Vector2f center = new Vector2f();
    private Vector2f size = new Vector2f();
    private Vector2f halfSize = new Vector2f();
    private Rigidbody rigidbody = null;

    public AABB(){
        this.halfSize = new Vector2f(size).mul(0.5f);
    }

    public AABB(Vector2f min, Vector2f max){
        this.size = new Vector2f(max).sub(min);
        this.center = new Vector2f(min).add(new Vector2f(size).mul(0.5f));
    }

    public Vector2f getMin(){
        return new Vector2f(this.rigidbody.getPosition()).sub(this.halfSize);
    }

    public Vector2f getMax(){
        return new Vector2f(this.rigidbody.getPosition()).add(this.halfSize);
    }
    public boolean aabbCollide(){
        return true;
    }
}
