package main.competition;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.match.Match;
import main.match.RandomMatch;
import main.observers.Observable;
import util.MapUtil;

/**
 * @author aymane.ismail.etu
 * @author mohammed.hachour.etu
 * PROJET COO 2022
 */

public abstract class Competition extends Observable {

	private final Match match;
	private final List<Competitor> competitors;
	protected Map<Competitor, Integer> rankMap;
	

	/**
	 * @param competitors list
	 * @param match m
	 * Constructor of Competition 
	 */
	public Competition(final List<Competitor> competitors, final Match match) {
		
		this.competitors = competitors;
		
		this.rankMap = new HashMap<Competitor, Integer>();
		for (Competitor competitor : competitors) {
			rankMap.put(competitor, 0);
	    }
		this.match = match;
	}
	

	/**
	 * @param competitors 
	 * Random match
	 */
	public Competition(final List<Competitor> competitors) {
		this(competitors, new RandomMatch());
	}
	

	/**
	 * Play the competition while all match are finished
	 */
	public void play() {
		play(competitors);
	}
	

	protected abstract void play(List<Competitor> competitors);
	
	protected abstract void playMatch(Competitor competitorOne, Competitor competitorTwo);
	
	
	/**
	 * @return sorted map
	 */
	public Map<Competitor, Integer> ranking() {
		return rankMap = MapUtil.sortByDescendingValue(rankMap);
	}
	
	/**
	 * Sort and print the ranking 
	 */
	public void printRanking() {
		
		ranking();

		System.out.println("**RANKING**");
		
		for (Map.Entry<Competitor, Integer> entry : rankMap.entrySet()) {
			System.out.println(entry.getKey().getName() + ": " + entry.getValue().toString() + " pts");
		}
		System.out.println("\n");
	}
	
	/**
	 * @param competitor
	 * Add point to a Competitor in the rankMap
	 */
	public void addPointToTheWinner(Competitor competitor) {
		rankMap.compute(competitor, (k, v) -> v + 1);
	}
	
	// Getters
	
	public int getNbPlayers() {
		return competitors.size();
	}

	protected Match getMatch() {
		return match;
	}
}
