import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class ScorePlus extends Item {
 private StartingPoint appletInfo;
	
 public ScorePlus(int x,StartingPoint appletInfo) {
		super(x);
		// TODO Auto-generated constructor stub
	    this.appletInfo= appletInfo;
	}
public void performAction(Ball b1){
	Random r = new Random();
	appletInfo.setScore(appletInfo.getScore()+500+r.nextInt(2000));
	
	//super.performAction(b1);
}
@Override
	public void paint(Graphics g) {
		g.setColor(Color.BLUE);
		super.paint(g);
	}

}
