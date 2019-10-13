package com.chateaugiron.basket.domain;

/**
 * Cette classe représente les ressources devant être affectées à un match (au nombre de 4, deux arbitres, deux marqueurs)
 * Les propriétés reprennent les éléments intervenant dans le calcul
 * @author fscellos
 *
 */
public class Personne {

	/**
	 * Nom du joueur
	 */
	private String nom;
	
	/**
	 * Le niveau du joueur. On utilise ici un entier pour simplifier les comparaisons lors de l'écriture des règles.
	 * U7 : 0
	 * U9 : 1
	 * U11 : 2
	 * U13 : 3
	 * U15 : 4
	 * U17 : 5
	 * U20 : 6
	 * Senior : 7
	 */
	private int niveauJoueur;
	
	/**
	 * Indique si le joueur est disponible lors du chargement des facts (le jour des matchs)
	 * + simple dans un premier temps que les infos travaille samedi/travaille dimanche et blessé
	 */
	private boolean disponibleADate;
	
	/**
	 * Indique si le joueur est siffleur ou pas
	 */
	private boolean arbitre;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNiveau() {
		return niveauJoueur;
	}

	public void setNiveau(int niveau) {
		this.niveauJoueur = niveau;
	}

	public boolean isDisponibleADate() {
		return disponibleADate;
	}

	public void setDisponibleADate(boolean disponibleADate) {
		this.disponibleADate = disponibleADate;
	}

	public boolean isArbitre() {
		return arbitre;
	}

	public void setArbitre(boolean arbitre) {
		this.arbitre = arbitre;
	}
	
}
