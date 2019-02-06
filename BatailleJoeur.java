package bataille;

import org.newdawn.slick.*;

public class BatailleJoeur {
	private Image joueur;
	private int barreVie = 100;
	public void init() throws SlickException {
		this.joueur = new Image("images/hero.png");
	}

	public void render(GameContainer container, Graphics g) {
	    joueur.drawCentered(container.getWidth() * 1 / 4,   container.getHeight() / 2);
	    g.setColor(new Color(255,255,255));
	    g.drawRect(container.getWidth() * 1 / 4 - 80, container.getHeight() / 2 - joueur.getHeight() / 2-30, 100, 20);
	    
	    g.setColor(new Color(255,0,0));
	    g.fillRect(container.getWidth() * 1 / 4 - 80, container.getHeight() / 2 - joueur.getHeight() / 2-30, barreVie, 20);
	}
	
	public void attaquer(BatailleEnnemi batailleEnnemi) {
		batailleEnnemi.setBarreVie(10);
		
	}
	
	public int getBarreVie() {
		return barreVie;
	}
	
	public void setBarreVie(int degat) {
		barreVie= barreVie-degat;
	}
}
