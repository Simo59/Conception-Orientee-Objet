package main.competition;

import java.util.List;

import main.match.Match;

/**
 * @author aymane.ismail.etu
 * @author mohammed.hachour.etu
 * PROJET COO 2022
 */

public class League extends Competition {

	/**
	 * @param competitors
	 * Constructor of League 
	 */
	public League(List<Competitor> competitors) {
		super(competitors);
	}
	
	/**
	 * Constructor of League
	 * @param competitors List of Competitor
	 * @param match Match
	 */
	public League(List<Competitor> competitors, Match match) {
		super(competitors, match);
	}

	/**
	 * Play all matches
	 */
	@Override
	protected void play(List<Competitor> competitors) {
		for (Competitor c1 : competitors) {
			for (Competitor c2 : competitors) {
				if (c1 != c2) {
					playMatch(c1, c2);
				}
			}
		}
	}

	/**
	 * Play a match and print the winner
	 */
	@Override
	protected void playMatch(Competitor c1, Competitor c2) {
		getMatch().clearPlayers();
		getMatch().addPlayer(c1);
		getMatch().addPlayer(c2);
		Competitor winner = getMatch().playMatch();
		addPointToTheWinner(winner);
		System.out.println(c1.getName() +" vs " + c2.getName() + " --> " + winner.getName() + " wins !");
		notifyObservers(getMatch());
		System.out.println();
	}

}
