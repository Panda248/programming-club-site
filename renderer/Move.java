package renderer;

import physics.primitives.java.Box;
import physics.primitives.java.Circle;

public class Move {


   public void shiftBox(Box x, float xShift, float yShift)
    {
        x.setX(x.getX()+xShift);
        x.setY(x.getY()+yShift);
    }
    public void shiftEllipse(Circle x, float xShift, float yShift)
    {
        x.setX(x.getX()+xShift);
        x.setY(x.getY()+yShift);
    }


}
