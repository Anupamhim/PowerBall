import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.util.Random;

public class Platform {
	
	int x,y,Width,Height;
	int dx;
	Image plat;
	URL url;
	static int level = 1;
	int u = 5;
	
	public Platform()
	{
		dx = -1;
		x = 500;
		y = 300;
		Width = 120;
		Height = 40;
		plat=Pictures.platform;
	}
	
	public Platform(int x, int y)
	{
		dx = -1;
		this.x = x;
		this.y = y;
		Width = 120;
		Height = 40;
		
	}
	
	public void Update(StartingPoint sp,Ball b1)
	{
		Random r = new Random();
		 x += - level;
	  checkForCollision(b1);
	  
	  if( x < 0 - Width)
	  {
		  y = sp.getHeight()- 200 - r.nextInt(200);
		  x = sp.getWidth() + r.nextInt(300);
	  }
	}
	
	private void checkForCollision(Ball b1) {
		double ballX = b1.getX();
		double ballY = b1.getY();
		int ballR = b1.getRadius();
		
		if(  ballY + ballR > y && ballY + ballR < y + Height)
		{
			if(ballX >= x &&  ballX < x + Width)
			{
				 double newDY = b1.getGameDy();
				 b1.setY(y - ballR);
				 b1.setDy(newDY);
			}
		 
		}
		
	}

	public void paint(Graphics g)
	{
		g.setColor(Color.BLUE);
		g.fillRect(x, y, Width, Height);
		//g.drawRect(x, y, Width, Height);
	  // g.drawImage(plat, x, y, Pictures.sp);
	}

}
