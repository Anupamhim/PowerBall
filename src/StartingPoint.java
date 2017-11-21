import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.net.URL;
import java.sql.DriverManager;
import java.util.Random;
import java.sql.Connection;
import javax.swing.*;


public class StartingPoint extends Applet implements Runnable,KeyListener,MouseMotionListener,MouseListener
{
	private Image i;
	private Graphics doubleG;
	Ball b1;
	Platform p[] = new Platform[7];
	Item it[] = new Item[3];
	private int score;
	double cityX=0;
	double cityDx= .3;
	URL url;
	Image city;
	int levelCheck = 0;
	boolean gameOver = false;
	int m = 0;
	boolean mouseIn = false;
	int HighScore = 0;
	Connection con=null;
	
	@Override
	public void init() //For initialization  
	{
		//con= ConnectDB();
		setSize(800, 600);
		addKeyListener(this);
		addMouseMotionListener(this);
		addMouseListener(this);
		try{
			url = getDocumentBase();			
		}
		catch(Exception e){
			
		}
		city = getImage(url, "Image/firstimg.png"); //Backgrounde Image
		
		//Pictures p = new Pictures(this);
	}
	
	@Override
	public void start() // Applet class function for Staring All of the fuctionality 
	{
		
		b1 = new Ball();
		score =0;
		for(int i = 0 ; i < p.length ; i++)
		{
			Random r = new Random();
		
			p[i] = new Platform(i*120 + m, 300);
			m +=3;
		}
		
		for(int i = 0 ; i < it.length ; i++)
		{
			Random r = new Random();
			
			switch(r.nextInt(5)) //  Randoming Item creation 
			{
			case 0:
				it[i]=new GravUp(getWidth() + 2000 * i);
				break;
			case 1:
				it[i]=new GravDown(getWidth() + 2000 * i);
				break;
			case 2:
				it[i]=new AgilUp(getWidth() + 2000 * i);
				break;
			case 3:
				it[i]=new AgilDown(getWidth() + 2000 * i);
				break;
			case 4:
				it[i]=new ScorePlus(getWidth() + 2000 * i,this);
				break;
				
			}
			
			//it[i] = new GravUp(getWidth() + 2000 * i);
		}
		
		Thread thread = new Thread(this);
		thread.start();
	}
	
	@Override
	public void run() // For Running All of the function and Updating value  
	{
		while(true)
		{
			gameOver = b1.getGameOver();
			
			if(levelCheck > 550 )
			{
				Platform.level++;
				levelCheck = 0;
			}
			levelCheck++;
			
			if(cityX > getWidth()*-1)
			{
			cityX -= cityDx;
			}
			else
			{
				cityX=0;
			}
			
			if(!gameOver)
			{
				score++;
			}
			if(gameOver)
			{
				if( score > HighScore)
				{
					HighScore = score;
					//DataBase ob = new DataBase(HighScore);
					//ob.setV();
				}
				
			}
			
			Random r = new Random();
			for (int i=0; i< it.length;i++)
			{
				if(it[i].isCreateNew())  
				//if (it[i].getY()== this.getHeight()+100)
				{
					it[i]= null;
					switch(r.nextInt(5))
					{
					case 0:
						it[i]=new GravUp(getWidth()+10*r.nextInt(500));
						break;
					case 1:
						it[i]=new GravDown(getWidth()+10*r.nextInt(500));
						break;
					case 2:
						it[i]=new AgilUp(getWidth()+10*r.nextInt(500));
						break;
					case 3:
						it[i]=new AgilDown(getWidth()+10*r.nextInt(500));
						break;
					case 4:
						it[i]=new ScorePlus(getWidth()+10*r.nextInt(500),this);
						break;
						
					}
					it[i].setCreateNew(false);
				    
			}
			}
			b1.Update(this);
			
			for(int i = 0 ; i < p.length ; i++)
			{
				p[i].Update(this, b1);
			}
			
			for(int i = 0 ; i < it.length ; i++)
			{
				it[i].Update(this, b1);
			}
			
		  repaint();
		  try {
			Thread.sleep(17);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
	
	@Override
	public void stop() {
		// TODO Auto-generated method stub
		super.stop();
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}
	
	@Override
	public void paint(Graphics g) {
	     
		g.setColor(new Color(15,17,147));
		g.fillRect(0, 0, getWidth(), getHeight());
		g.drawImage(city,(int)cityX, 0, this);
		g.drawImage(city,(int)cityX +getWidth(), 0, this);
		b1.paint(g);
		//b2.paint(g);
		for(int i = 0 ; i < p.length ; i++)
		{
			p[i].paint(g);
		}
		for(int i = 0 ; i < it.length ; i++)
		{
			it[i].paint(g);
		}
		b1.paint(g);
		
		String s = Integer.toString(score);
		Font font = new Font( "Serif",Font.BOLD,32);   
		g.setFont(font);
		g.setColor(Color.BLACK);
		g.drawString("YOUR SCORE : ", getWidth()-450, 50+2);
		g.drawString(s, getWidth()-200+2, 50+2);
		g.setColor(new Color(198,226,255));
		g.drawString(s, getWidth()-200, 50);
		
		if(gameOver)
		{
			
			{
				g.setColor(Color.BLACK);
			    g.drawString("GAME OVER", 270, 290);
			    //HighScore = score;
				//DataBase ob = new DataBase(HighScore);
				//int a;
				//q = if(score)
				//a = ob.getV();
			    g.drawString("High Score :" +HighScore, 270, 390);
			    g.drawRect(240, 300, 250, 55);
			}
			if(mouseIn)
			{
				g.setColor(Color.RED);
			    g.drawString("PLAY AGAIN", 250, 340);
			   
			}
			else
			{
				g.setColor(Color.ORANGE);
			    g.drawString("PLAY AGAIN", 250, 340);
			}
			
		}
		
	}

	   @Override
	public void update(Graphics g) // BackGroun Graphics 
	   {
		   
		   if(i == null)
		   {
			   i = createImage(this.getSize().width,this.getSize().height);
			   doubleG = i.getGraphics();
		   }
		 doubleG.setColor(getBackground());
		 doubleG.fillRect(0, 0, this.getSize().width, this.getSize().height);
		 
		 doubleG.setColor(getForeground());
		 paint(doubleG);
		 
		 g.drawImage(i,0,0,this);
				 
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) //Key Event for Right and left key from the key board
	{
		switch(e.getKeyCode())
		{
		case  KeyEvent.VK_LEFT:
		  b1.moveLeft();
		  break;
		case KeyEvent.VK_RIGHT:
		  b1.moveRight();
		  break;
		  	 
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) // Mouse event for changing color of text 
	{
		
     if(e.getX() > 240 && e.getX() < 490)
     {
	    if(e.getY() > 300 && e.getY() < 355)
	    {
	    	mouseIn = true;
	    }
      }
     if(e.getX() < 240 || e.getX() > 490)
     {
	    
	    mouseIn = false;
	    
      }
		
	}

	@Override
	public void mouseClicked(MouseEvent e) // For playaing the game again clicking event
	{
		if(mouseIn)
		{
			b1 = null;
			b1 = new Ball();
			Platform.level = 1;
			score = 0;
			
			for(int i = 0 ; i < p.length ; i++)
			{
				Random r = new Random();
			
				p[i] = new Platform(i*120 + m, 300);
				m +=3;
			}
			
			for(int i = 0 ; i < it.length ; i++)
			{
				Random r = new Random();
				
				switch(r.nextInt(5))
				{
				case 0:
					it[i]=new GravUp(getWidth() + 2000 * i);
					break;
				case 1:
					it[i]=new GravDown(getWidth() + 2000 * i);
					break;
				case 2:
					it[i]=new AgilUp(getWidth() + 2000 * i);
					break;
				case 3:
					it[i]=new AgilDown(getWidth() + 2000 * i);
					break;
				case 4:
					it[i]=new ScorePlus(getWidth() + 2000 * i,this);
					break;
					
				}
				
				//it[i] = new GravUp(getWidth() + 2000 * i);
			}
			mouseIn = false;
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public int getHighScore()
	{
		return HighScore;
	}
	
}

