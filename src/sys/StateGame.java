package sys;


import Bataille.Bataille;
import ecrans.EcranMenuChoisirUnNiveau;
import ecrans.EcranMenuChoisirUnNom;
import ecrans.EcranMenuPrincipale;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * class StateGame
 *
 * @author: Diuxx
 */
public class StateGame extends StateBasedGame {



    /**
     * Class constructor
     */
    public StateGame() throws SlickException {
        super("Projet InterStateComm");
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        /*addState(new EcranMenuPrincipale());
        addState(new EcranMenuChoisirUnNiveau());
        addState(new EcranMenuChoisirUnNom());*/ // à décommenter.
        addState(new EcranJeu());
        addState(new Bataille());
    }


}
