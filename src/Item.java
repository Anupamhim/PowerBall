
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Item //Creating Item for Bonus
{
	
	private int x,y,dx,radius;
	private StartingPoint sp;
	private boolean createNew=false ;
	public boolean isCreateNew() {
		return createNew;
	}


	public void setCreateNew(boolean createNew) {
		this.createNew = createNew;
	}


	public Item(int x)
	{
		radius = 10;
		this.x = x;
		Random r = new Random();
		y = r.nextInt(400) + radius;
	
		dx = -2;
	}
	
	
	public void Update(StartingPoint sp,Ball b1)
	{
		 x += dx;
		 this.sp =sp;
	  checkForCollision(b1);
	  
	  if( x < 0 - radius)
	  {
		  createNew = true;
		  //Random r = new Random();
		  //x = sp.getWidth() + 2000 + r.nextInt(300);
	  }
	}
	
	private void checkForCollision(Ball b1) {
		double ballX = b1.getX();
		double ballY = b1.getY();
		double ballR = b1.getRadius();
		
		int a = (int) (x - ballX);
		int b = (int) (y - ballY);
		int collide = (int) (radius + ballR);
		
		double c = Math.sqrt(a*a + b*b);
		
		if( c < collide)
		{
			performAction(b1);
			
			createNew = true;
			//x = 0;
			//y  = sp.getHeight()+100;;
		}
		
	}

	protected void performAction(Ball b1) {
		// TODO Auto-generated method stub
		
	}


	public void paint(Graphics g)
	{
		g.setColor(Color.BLUE);
		g.fillOval(x-radius, y-radius, radius*2, radius*2);
		//g.drawRect(x, y, Width, Height);
	}


	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

}
