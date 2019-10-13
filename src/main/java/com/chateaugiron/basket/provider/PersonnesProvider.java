package com.chateaugiron.basket.provider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import com.chateaugiron.basket.domain.*;

/**
 * La classe responsable du chargement des différentes joueurs à affecter à un
 * match
 * 
 * @author fscellos
 *
 */
@Component
public class PersonnesProvider {
	
	/** 
	 * Construction des personnes à injecter au solver.
	 * Doit être issu d'une source de données quelconques (fichier ou autre) mais pour l'instant on construit une liste simple en dur
	 * @return
	 */
	public List<Personne> loadAndGetPersonnes() {
		ArrayList<Personne> toSendBack = new ArrayList<Personne>();
		toSendBack.add(new Personne() {{setArbitre(false); setNiveau(3); setNom("Louness");setDisponibleADate(true);}});
		toSendBack.add(new Personne() {{setArbitre(false); setNiveau(3); setNom("Alexis");setDisponibleADate(true);}});
		toSendBack.add(new Personne() {{setArbitre(false); setNiveau(3); setNom("Nolan");setDisponibleADate(true);}});
		toSendBack.add(new Personne() {{setArbitre(false); setNiveau(3); setNom("Titouan");setDisponibleADate(true);}});
		toSendBack.add(new Personne() {{setArbitre(false); setNiveau(3); setNom("Indiss");setDisponibleADate(true);}});
		toSendBack.add(new Personne() {{setArbitre(false); setNiveau(3); setNom("Nael");setDisponibleADate(true);}});
		toSendBack.add(new Personne() {{setArbitre(false); setNiveau(3); setNom("Theo");setDisponibleADate(true);}});
		toSendBack.add(new Personne() {{setArbitre(false); setNiveau(3); setNom("Mael");setDisponibleADate(true);}});
		toSendBack.add(new Personne() {{setArbitre(false); setNiveau(3); setNom("Antonin");setDisponibleADate(true);}});
		toSendBack.add(new Personne() {{setArbitre(false); setNiveau(3); setNom("Loukmane");setDisponibleADate(true);}});		
		return toSendBack;
	}
}
