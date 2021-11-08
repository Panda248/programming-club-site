package renderer;

import org.newdawn.slick.Graphics;
import physics.primitives.java.Circle;
import physics.primitives.java.Box;


public class Draw {
    Graphics g = new Graphics();
    public void drawBox(Box x)
    {
        g.drawRect(x.getX(),x.getY(),x.getWidth(),x.getHeight());
    }
    public void drawEllipse(Circle x)
    {
        g.drawOval(x.getX(),x.getY(),x.getRadius()*2, x.getRadius()*2);
    }
}
