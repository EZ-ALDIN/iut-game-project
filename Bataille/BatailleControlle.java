package Bataille;

import org.newdawn.slick.command.Command;
import org.newdawn.slick.command.Command;
import org.newdawn.slick.command.InputProviderListener;
import org.newdawn.slick.state.StateBasedGame;

public class BatailleControlle implements InputProviderListener {
	private BatailleEnnemi ennemi ;
	private BatailleJoeur joueur;
	private StateBasedGame game;
	private BatailleCommande mode = BatailleCommande.NONE;



	
	public BatailleControlle(BatailleJoeur joueur, BatailleEnnemi ennemi, StateBasedGame game) {
		this.joueur = joueur;
		this.ennemi = ennemi;
		this.game = game;
		initAnimationListeners();
	}

	@Override
	public void controlPressed(Command commande) {
		if (this.mode == BatailleCommande.NONE) {
			this.mode = (BatailleCommande) commande;
			attaquer();
		}
	}

	private void attaquer() {
		attaqueJoeur();
		attaqueEnnemi();
	}
	
	private void attaqueJoeur() {
		joueur.attaquer(ennemi);
		//if(ennemi.getBarreVie()<= 0) {
		//	game.enterState(YouWin.YouWin);
		//}
	}
	private void attaqueEnnemi() {
		ennemi.attaquer(joueur);
		//if (joueur.getBarreVie() <= 0) { 
		//	game.enterState(GameOver.GameOver);
		//} 
	}
	
	@Override
	public void controlReleased(Command commande) {

	}
	private void initAnimationListeners() {
		  AnimationListener playerAssignDamage = new AnimationListener() {
		    @Override
		    public void on() {
		    	playerAssignDamage();
		    }
		  };
		  AnimationListener endPlayerAttack = new AnimationListener() {
			    @Override
			    public void on() {
			      endPlayerAttack();
			    }
			  };
		  AnimationListener ennemiAssignDamage = new AnimationListener() {
				    @Override
				    public void on() {
				    	ennemiAssignDamage();
				    }
				  };
		  AnimationListener endEnnemiAttack = new AnimationListener() {
					    @Override
					    public void on() {
					    	endEnnemiAttack();
					    }
					  };
			  this.joueur.addAnimationListener(playerAssignDamage,endPlayerAttack);
			}
	  private void playerAssignDamage() {ennemi.setBarreVie(10); }
	  private void endPlayerAttack() { 	
		  if(ennemi.getBarreVie()<= 0) {
			  game.enterState(YouWin.YouWin);
			  mode = BatailleCommande.NONE;
		  } else { 
			    switch (mode) { 
			    case ATTAQUER: 
			      ennemi.attaquer(joueur); 
			      break; 
			    default: 
			      // Fin de cette étape de combat, réinitialisation
			      mode = BatailleCommande.NONE;
			      break; 
			    } 
			  } 
		  joueur.setBarreVie(10);
		  mode = BatailleCommande.NONE;

	  }
	  private void ennemiAssignDamage() {joueur.setBarreVie(10); }
	  private void endEnnemiAttack() { 
		  if (joueur.getBarreVie() <= 0) {
		    game.enterState(GameOver.GameOver); 
		  }
		  mode = BatailleCommande.NONE;
		  } 
}