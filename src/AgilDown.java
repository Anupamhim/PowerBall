import java.awt.Color;
import java.awt.Graphics;

public class AgilDown extends Item
{

	public AgilDown(int x) {
		super(x);
		// TODO Auto-generated constructor stub
	}
	
	public void performAction(Ball b1){
	if (b1.getAgility()>=2){
		b1.setAgility(b1.getAgility()-1);
	  }
	}
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.GREEN);
		super.paint(g);
	}

}
