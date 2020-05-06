package tennisGame;

import java.awt.Color;
import java.awt.Graphics;

public class AIPaddle implements Paddle{

	double y;
	double yVel;
	boolean upAccel;
	boolean downAccel;
	int player;
	int x;
	Ball b1;
	
	final double GRAVITY = 0.94;
	
	
	public AIPaddle(int player, Ball b) {
		super();
		upAccel = false;
		downAccel = false;
		
		b1 = b;
		
		y = 210;
		yVel = 0;
		

		
		if(player == 1) {
			x = 20;
		}else {
			x = 660;
		}
		
	}

	@Override
	public void draw(Graphics g) {
		
		g.setColor(Color.white);
		g.fillRect(x, (int)y, 20, 80);
		
	}

	@Override
	public void move() {
		y = b1.getY() - 40;
		
		if(y < 0) {
			y = 0;
		}

		if(y > 420) {
			y = 420;
		}
		
	}
	
	public void setUpAccel(boolean input) {
		upAccel = input;
	}
	
	public void setDownAccel(boolean input) {
		downAccel = input;
	}

	@Override
	public int getY() {
		return (int)y;
		
	}

	
	
	
}
