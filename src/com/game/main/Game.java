package com.game.main;

import java.awt.Canvas;

public class Game extends Canvas implements Runnable {
	/**
	 * @author infinityDev
	 */
	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 720;
	public static final int HEIGHT = WIDTH /12 * 9;
	
	private Thread thread;
	private boolean isRunning = false;
	
	public Game() {
		new Window(WIDTH, HEIGHT, "Space Game v1.0", this);
	}
	
	public synchronized void start() {
		if(this.isRunning) {
			return;
		}
		else {
			this.thread = new Thread(this);
			this.thread.start();
			this.isRunning = true;
		}
	}
	
	public synchronized void stop() {
		try {
			this.thread.join();
			this.isRunning = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		
		int frames = 0;
		
		while(this.isRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			while(delta >= 1) {
				this.tick();
				delta--;
			}
			
			if(this.isRunning) {
				this.render();
			}
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS : " + frames);
				frames = 0;
			}
		}
		
		this.stop();
	}
	
	private void render() {
		
	}
	
	private void tick() {
		
	}
	
	public static void main(String[] args) {
		new Game();
	}

}
