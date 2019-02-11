package Bataille;

import org.newdawn.slick.*;

public class BatailleEnnemi {
	private Image ennemi;
	private int barreVie = 100;

	public void init() throws SlickException {
		this.ennemi = new Image("image/ennemi.png");
	}

	public void render(GameContainer container, Graphics g) {
		this.ennemi.drawCentered(container.getWidth() * 3 / 4, container.getHeight() / 2);
		
		g.setColor(new Color(255,255,255));
	    g.drawRect(container.getWidth() * 3 / 4 - 50, container.getHeight() / 2 - ennemi.getHeight() / 2-30, 100, 20);
		
	    g.setColor(new Color(255,0,0));
	    g.fillRect(container.getWidth() * 3 / 4 - 50, container.getHeight() / 2 - ennemi.getHeight() / 2-30, barreVie, 20);
	    
	}
	
	
	public void attaquer(BatailleJoeur batailleJoeur) {
		//batailleJoeur.setBarreVie(10);
	}

	public Image getEnnemi() {
		return this.ennemi;
	}

	
	public int getBarreVie() {
		return barreVie;
	}
	
	public void setBarreVie(int degat) {
		barreVie= barreVie-degat;
	}
}
