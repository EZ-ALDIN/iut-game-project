package bataille;


import org.newdawn.slick.command.Command;
import org.newdawn.slick.command.InputProviderListener;
import org.newdawn.slick.state.StateBasedGame;

public class BatailleControlle implements InputProviderListener {
	private BatailleEnnemi ennemi ;
	private BatailleJoeur joueur;
	private StateBasedGame game;
	
	public BatailleControlle(BatailleJoeur joueur, BatailleEnnemi ennemi, StateBasedGame game) {
		this.joueur = joueur;
		this.ennemi = ennemi;
		this.game = game;
	}
	
	@Override
	public void controlPressed(Command commande) {
		if (commande == BatailleCommande.ATTAQUER)
			attaquer();
	}

	private void attaquer() {
		attaqueJoeur();
		attaqueEnnemi();
	}
	
	private void attaqueJoeur() {
		joueur.attaquer(ennemi);
		if(ennemi.getBarreVie()<= 0) {
			game.enterState(YouWin.YouWin);
		}
	}
	private void attaqueEnnemi() {
		ennemi.attaquer(joueur);
		if (joueur.getBarreVie() <= 0) { 
			game.enterState(GameOver.GameOver);
		} 
	}
	
	@Override
	public void controlReleased(Command commande) {

	}
	
}