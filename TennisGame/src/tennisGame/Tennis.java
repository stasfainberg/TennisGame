package tennisGame;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Tennis extends Applet implements Runnable, KeyListener{

	final int WIDTH = 700;
	final int HEIGTH = 500;
	Thread thread;
	HumanPaddle p1;
	AIPaddle p2;
	Ball b1;
	boolean gameStarted;
	Graphics gfx;
	Image img;
	
	public void init() {
		
		this.resize(WIDTH, HEIGTH);
		this.addKeyListener(this);
		
		gameStarted = false;
		
		p1 = new HumanPaddle(1);
		b1 = new Ball();
		p2 = new AIPaddle(2, b1);
		
		img = createImage(WIDTH, HEIGHT);
		gfx = img.getGraphics();
		
		thread = new Thread(this);
		thread.start();

	}
	
	
	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGTH);
		
		if(b1.getX() < -10 || b1.getX() > 710) {
			g.setColor(Color.red);
			g.drawString("Game Over", 350, 250);
		}else {
			p1.draw(g);
			b1.draw(g);
			p2.draw(g); 

		}
		
		if(!gameStarted) {
			g.setColor(Color.white);
			g.drawString("Tennis", 340, 100);
			g.drawString("Press Enter to Begin...", 310, 130);
			
		}
		
		g.drawImage(img, 0, 0, this);
		
	}
	
	
	public void update(Graphics g) {
		paint(g);
		
	}

	
	
	@Override
	public void run() {
		for(;;) {
			
			if(gameStarted) {
				p1.move();
				p2.move();
				b1.move();
				b1.checkPaddleCollosion(p1, p2);
			}
			
			repaint();
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
	}

	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			p1.setUpAccel(true);
		}else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			p1.setDownAccel(true);
		}else if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			gameStarted = true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			p1.setUpAccel(false);
		}else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			p1.setDownAccel(false);
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
}
