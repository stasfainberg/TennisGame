package tennisGame;

import java.awt.Color;
import java.awt.Graphics;

public class HumanPaddle implements Paddle{

	double y;
	double yVel;
	boolean upAccel;
	boolean downAccel;
	int player;
	int x;
	
	final double GRAVITY = 0.94;
	
	
	public HumanPaddle(int player) {
		super();
		
		y = 210;
		yVel = 0;
		
		upAccel = false;
		downAccel = false;
		
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
		if(upAccel) {
			yVel -= 2;
		}else if(downAccel) {
			yVel += 2;
		}else if(!upAccel && !downAccel) {
			yVel *= GRAVITY;
		}
		
		
		if(yVel >= 5) {
			yVel = 5;
		}else if(yVel <= -5) {
			yVel = -5;
		}
		
		y += yVel;
		
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
