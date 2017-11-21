import java.awt.Color;
import java.awt.Graphics;

public class AgilUp extends Item
{

	public AgilUp(int x) {
		super(x);
		// TODO Auto-generated constructor stub
	}
	
	public void performAction(Ball b1){
	if (b1.getAgility()<8){
		b1.setAgility(b1.getAgility()+1);
	  }
	}
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.YELLOW);
		super.paint(g);
	}

}
