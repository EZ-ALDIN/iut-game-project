package sys;

import jeu.Ennemi;

/**
 * Classe contenant des méthodes pour transmettre des données entre les States du jeu (map, bataille...)
 */
public class InterStateComm {
    /**
     * Variable battleResult : 0 par défaut, 1 = victoire, 2 = défaite
     * Variable battleEnnemy : avec quel ennemi on se bat (numéro de sa position dans la liste)
     */
    private static Ennemi battleEnnemy = null;
    private static int battleResult = 0;

    /**
     * Ecriture BattleEnnemy
     */
    public static void setBattleEnnemy(Ennemi unEnnemi) {
        battleEnnemy = unEnnemi;
    }
    /**
     * Lecture + réinitialisation battleEnnemy
     */
    public static Ennemi readBattleEnnemy() {
        Ennemi unEnnemi = battleEnnemy;
        /// Fonction de reset de battleEnnemy
        return unEnnemi;
    }

    /**
     * Ecriture battleResult
     */
    public static void setBattleVictory () {
        battleResult = 1;
    }
    /**
     * Lecture + réinitialisation battleResult
     */
    public static boolean isBattleVictory () {
        int variableIntermediaire = InterStateComm.battleResult;
        boolean returnedValue = false;
        InterStateComm.battleResult = 0;
        switch (variableIntermediaire) {
            case 0:
                // Pas de valeur à traiter
                break;
            case 1:
                returnedValue = true;
                break;
            case 2:
                returnedValue = false;
                break;
            default:
                System.err.println("InterStateComm : unexpected value in variable battleResult");
                break;
        }
        return returnedValue;
    }
    /**
     * Methode qui declare mort l'ennemi de la dernière bataille
     */
    public static void battleEnnemyDead() {
        if (battleEnnemy != null) {
            battleEnnemy.setMort(true);
            battleEnnemy = null;
        }
        else {
            System.err.println("Pas d'ennemi enregistré pour la bataille");
        }

    }
}
