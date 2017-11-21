import java.awt.Color;
import java.awt.Graphics;

public class GravDown extends Item
{

	public GravDown(int x) {
		super(x);
		// TODO Auto-generated constructor stub
	}
	
	public void performAction(Ball b1){
		if (b1.getGravity()>3){
	    b1.setGravity(b1.getGravity()-3);
	    if(b1.getGravity()<3){
	    	b1.setGravity(3);
	    }
	   }
	}
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.PINK);
		super.paint(g);
	}

}
