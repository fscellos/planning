package com.chateaugiron.basket;

import org.optaplanner.core.api.domain.variable.PlanningVariable;

import com.chateaugiron.basket.domain.Personne;

/**
 * La représentation temporaire des éléments qu'on cherche à représenter
 * @author fscellos
 *
 */
//@PlanningEntity
public class MatchBasket {
	
	/**
	 * Une réprésentation simplifiée du slot de temps pour le match
	 */
	private Integer timeSlot;
	
	/**
	 * Le niveau du match qui se tient
	 */
	private int matchLevel;
	
	/**
	 * Les ressources de type Personne pour assurer la tenue du match
	 * Représente les élements à calculer par le solver (en fonction des paramètres du match)
	 */
	private Personne arbitre1;
	private Personne arbitre2;
	private Personne marqueur1;
	private Personne marqueur2;

	@PlanningVariable(valueRangeProviderRefs = { "availableArbitres" })
	public Personne getArbitre1() {
		return arbitre1;
	}

	@PlanningVariable(valueRangeProviderRefs = { "availableArbitres" })
	public Personne getArbitre2() {
		return arbitre2;
	}
	
	@PlanningVariable(valueRangeProviderRefs = { "availableMarqueurs" })
	public Personne getMarqueur1() {
		return marqueur1;
	}

	@PlanningVariable(valueRangeProviderRefs = { "availableMarqueurs" })
	public Personne getMarqueur2() {
		return marqueur2;
	}
}
