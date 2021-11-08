package renderer;
import physics.primitives.java.*;

public class Gravity {
    private float accel = 10.02f;
    private float terminalVel = 100f;
    public void gravBox(Box box)
    {
        if(box.getYVel() < terminalVel)
        {
            box.setYVel(box.getYVel()*accel);
        }
    }
    public void gravCircle(Circle circle)
    {
        if(circle.getYVel() < terminalVel)
        {
            circle.setYAccel(circle.getYAccel() * accel);
        }
    }
}
