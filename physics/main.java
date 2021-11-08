package physics;

import org.newdawn.slick.*;
import physics.primitives.java.Box;
import physics.primitives.java.Circle;
import renderer.Gravity;
import renderer.Move;
import renderer.Draw;

import java.util.logging.Level;
import java.util.logging.Logger;



public class main extends BasicGame
{
    private Draw graphics = new Draw();
    private Move drip = new Move();
    Circle y;
    Box x;
    Box z;
    Gravity grav;

    public main(String gamename)
    {
        super(gamename);
    }

    @Override
    public void init(GameContainer gc) throws SlickException {
        grav = new Gravity();
        x = new Box(100f,20f, 50f, 50f);
        z = new Box(100f,240f,50f,50f);
        z.createCollider();
        x.createCollider();
    }

    @Override
    public void update(GameContainer gc, int i) throws SlickException {
        grav.gravBox(x);
        x.setYVel(x.getYAccel());

        /*x.setXVel(x.getAccel());
        x.setAccel((x.getAccel()*1.06f));

         */
        x.collider.update(x.getX(),x.getY(),x.getWidth(),x.getHeight());
        x.bounce(z.collider);
        System.out.println(x.collider.isColliding(z.collider));
    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
        graphics.drawBox(x);
        graphics.drawBox(z);
        drip.shiftBox(x, x.getXVel(), x.getYVel());

    }

    public static void main(String[] args)
    {
        try
        {
            AppGameContainer appgc;
            appgc = new AppGameContainer(new main("Physics Engine"));
            appgc.setDisplayMode(640, 480, false);
            appgc.setTargetFrameRate(60);
            appgc.start();

        }
        catch (SlickException ex)
        {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}