package main.match;

import main.competition.Competitor;

/**
 * Random Match class
 * 
 * @author aymane.ismail.etu
 * @author mohammed.hachour.etu
 * PROJET COO 2022
 * 
 */
public class RandomMatch extends Match {
	
	public RandomMatch() {
		super(2);
	}

	@Override
	public Competitor playMatch() {
		int rdm = (int) (Math.random()*getNbPlayers());
		Competitor winner = getPlayers().get(rdm);
		winner.increaseNbWin();
		return lastWinner = winner;
	}

}