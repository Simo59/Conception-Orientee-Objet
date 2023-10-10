package main.competition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author aymane.ismail.etu
 * @author mohammed.hachour.etu
 * PROJET COO 2022
 */
public class Tournament extends Competition {

	/**
	 * Constructor
	 * @param competitors list
	 * @throws NumberOfTwoCompetitorsSizeException e
	 */
	public Tournament(List<Competitor> competitors) throws NumberOfTwoCompetitorsSizeException {
		super(competitors);
		if ((competitors.size() & (competitors.size() - 1)) != 0) {
			throw new NumberOfTwoCompetitorsSizeException("Need a power of two number size list teams");
		}
	}
	
	private List<Competitor> queue;
	
	/**
	 * Play all matches
	 */
	@Override
	protected void play(List<Competitor> competitors) {
		int tour = 1;
		List<Competitor> currentPhase = new ArrayList<Competitor>(competitors);
		this.queue = new ArrayList<Competitor>();
		while(currentPhase.size() != 1) {
			System.out.println("--> TOUR "+tour+" <--");
			for (int i = 0; i < currentPhase.size(); i+=2) {
				playMatch(currentPhase.get(i), currentPhase.get(i+1));
			}
			currentPhase = this.queue;
			this.queue = new ArrayList<Competitor>();
			System.out.println();
			tour++;
		}
	}

	/**
	 * Play a match
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
		this.queue.add(winner);
	}

}

