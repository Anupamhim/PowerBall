import java.awt.Color;
import java.awt.Graphics;

public class Ball 
{
	private int x = 400;
	private int y = 25;
	private int radius = 40;
	private double dx = 0;
	private double dy = 0;
	
	private double gameDy = -70;
	
	private double gravity = 10;
	private double energyLoss = 1;
	private double dt = .2;
	private double xFriction = .9;	
	private int agility=3; // speed controling in horizontal
	private int maxSpeed=10;
	
	private boolean game_over = false;
	
	
	public Ball()
	{
		
	}
	
	public  Ball(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public int getRadius() {
		return radius;
	}
   public int getX() {
	return x;
}
  public int getY() {
	return y;
}
  public double getDx() {
	return dx;
}
   
  
 public double getDy() {
	return dy;
}
 
 public void setDy(double newDY) 
 {
		this.dy = newDY;
  }
 
 
 public double getGameDy() {
	return gameDy;
}
 public void setGameDy(double gameDy) {
	this.gameDy = gameDy;
}
 
 
 public double getDt() {
	return dt;
}
	public void Update(StartingPoint sp)
	{
	if(x + dx > sp.getWidth()- radius - 1)
	{
		x = sp.getWidth()  - radius - 1;
		dx = - dx; 
	}
	else if( x + dx < (0+radius))
	{
		x = 0 + radius;
		dx = -dx ;
	}
	else
	{
		x += dx;
	}
	
	if( y ==sp.getHeight()- radius-1)
	{
		dx = dx * xFriction;
		if( Math.abs(dy) < .8)
		{
			dy = 0;
			//dx = 0;
		}
	}
	
	if(y - 150> sp.getHeight() - radius - 1)
	{
		game_over = true;
//		y = sp.getHeight() - radius - 1;
//		dy = dy * energyLoss;
//		dy = gameDy;
	}
	else
	{
		dy = dy + gravity * dt;
		
		y +=  dy*dt + .5*gravity*dt*dt;
	}
	}
	
	public void paint(Graphics g)
	{
		g.setColor(Color.RED);
		g.fillOval(x-radius, y-radius, radius, radius);
		
	}
	
	public void moveRight()
	{
		if(dx+agility < maxSpeed)
		{
			dx += agility;
		}
	}
	public void moveLeft()
	{
		if(dx-agility > -maxSpeed)
		{
			dx -= agility;
		}
		
	}

	public int getAgility() {
		return agility;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setAgility(int agility) {
		this.agility = agility;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public int getGravity() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setGravity(int i) {
		// TODO Auto-generated method stub
		
	}

	public boolean getGameOver() {
		// TODO Auto-generated method stub
		return game_over;
	}

}

	


