package main.competition;

import java.util.List;
import java.util.Map;

import main.match.Match;
import main.observers.Observable;
import main.observers.Observer;
import main.strategy.MasterStrategy;

/**
 * @author aymane.ismail.etu
 * @author mohammed.hachour.etu
 * PROJET COO 2022
 * 
 */
public class Master extends Competition implements Observer {

	private Tournament finalPhase;
	private MasterStrategy masterStrategy;
	private Competitor finalGroupWinner;
	private League[] pools;
	
	
	/**
	 * @param competitors list
	 * @param masterStrategy strategy
	 * @throws NumberOfTwoCompetitorsSizeException e
	 */
	public Master(List<Competitor> competitors, MasterStrategy masterStrategy) throws NumberOfTwoCompetitorsSizeException {
		super(competitors);
		this.masterStrategy = masterStrategy;
		this.masterStrategy.checkCorrectNumberOfCompetitor(competitors.size());
	}

	
	/**
	 * Play all matches
	 */
	@Override
	protected void play(List<Competitor> competitors) {
		this.pools = this.masterStrategy.remplissagePoule(competitors);
		this.playGroup(pools);
		this.finalPhase = this.masterStrategy.selectionPhaseFinal(pools);
		this.playFinalGroup(finalPhase);
	}
	
	/**
	 * Play a match
	 */
	@Override
	protected void playMatch(Competitor c1, Competitor c2) {
	}
	
	/**
	 * Method used to play the group phase
	 * @param pools League[]
	 */
	private void playGroup(League[] pools) {
		for (League league : pools) {
			league.addObserver(this);
			league.play();
			Map<Competitor, Integer> rank = league.ranking();
			league.printRanking();
			incrementRankingsToOther(rank);
		}
	}
	
	/**
	 * play the finalPhase
	 * @param finalPhase Tournament
	 */
	private void playFinalGroup(Tournament finalPhase) {
		
		finalPhase.addObserver(this);
		finalPhase.play();
		Map<Competitor, Integer> rank = finalPhase.ranking();
		finalGroupWinner = rank.keySet().iterator().next();
		finalPhase.printRanking();
		incrementRankingsToOther(rank);
		
	}
	
	/**
	 * Increment Ranking
	 * @param other
	 */
	private void incrementRankingsToOther(Map<Competitor, Integer> other) {
        for (Competitor competitor : other.keySet()) {
			this.rankMap.compute(competitor, (k, v) -> v + other.get(k));
        }
	}
	
	/**
	 * Notify
	 */
	@Override
	public void update(Observable arg0, Match arg1) {
		notifyObservers(arg1);
	}

	// Getters
	
	public MasterStrategy getMasterStrategy() {
		return masterStrategy;
	}
	
	public Competitor getFinalPhaseWinner() {
		return finalGroupWinner;
	}
	
}
