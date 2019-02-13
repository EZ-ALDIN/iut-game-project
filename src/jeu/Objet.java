package jeu;

import org.newdawn.slick.Animation;
import org.newdawn.slick.geom.Rectangle;
import sys.Point;
import sys.Taille;

import java.util.ArrayList;
import java.util.List;

public class Objet {

    /**
     * Position de l'objet
     */
    private Point position;
    private Taille taille;

    /**
     * Gestion des collisions.
     */
    private Rectangle box;

    /**
     * Detection
     */
    private boolean collision;

    /**
     * Nom de l'objet */
    private String nom;

    /**
     * Annimation de l'objet */
    private List<Animation> animations;

    private int direction;

    /**
     * Construceur
     * @param nom
     * @param p */
    public Objet(String nom, Point p, Taille taille) {
        // --
        this.position = p;
        this.collision = false;
        this.nom = nom;

        this.animations = new ArrayList<Animation>();
        this.direction = 0;
    }
}
