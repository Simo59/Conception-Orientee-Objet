package main.match;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import main.competition.Competitor;


/**
 * Abstract class Match
 * 
 * @author aymane.ismail.etu
 * @author mohammed.hachour.etu
 * PROJET COO 2022
 */

public abstract class Match {

	private final List<Competitor> players;
	private final int nbPlayers;
	protected Competitor lastWinner;

	/**
	 * Constructor
	 * @param nbPlayers int
	 */
	public Match(int nbPlayers) {
		this.players = new ArrayList<Competitor>();
		this.nbPlayers = nbPlayers;
	}

	public abstract Competitor playMatch();

	public boolean addPlayer(Competitor competitor) {
		if (players.size() < nbPlayers) {
			return players.add(competitor);
		} else {
			return false;
		}
	}

	/**
	 * @param competitorCollection c
	 * @return true if OK
	 */
	public boolean addAllPlayers(Collection<Competitor> competitorCollection) {
		boolean success = true;
		Iterator<Competitor> iterator = competitorCollection.iterator();
		while (success && iterator.hasNext()) {
			success &= addPlayer(iterator.next());
		}
		return success;
	}
	
	// Clear and remove players
	
	public boolean removePlayer(Competitor competitor) {
		return players.remove(competitor);
	}

	public void clearPlayers() {
		players.clear();
	}
	
	// Getters
	
	public List<Competitor> getPlayers() {
		return players;
	}

	public int getNbPlayers() {
		return nbPlayers;
	}

	public Competitor getLastWinner() {
		return lastWinner;
	}

}
