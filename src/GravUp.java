import java.awt.Color;
import java.awt.Graphics;

public class GravUp extends Item
{

	public GravUp(int x) {
		super(x);
		// TODO Auto-generated constructor stub
	}
	
	public void performAction(Ball b1){
	    b1.setGravity(b1.getGravity()+3);
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.RED);
		super.paint(g);
	}

}
