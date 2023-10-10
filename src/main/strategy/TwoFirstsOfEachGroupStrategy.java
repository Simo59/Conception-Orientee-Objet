package main.strategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import main.competition.Competitor;
import main.competition.NumberOfTwoCompetitorsSizeException;
import main.competition.League;
import main.competition.Tournament;
import util.MapUtil;

/**
 * Abstract class for the Design Pattern Strategy
 * 
 * @author aymane.ismail.etu
 * @author mohammed.hachour.etu
 * PROJET COO 2022
 */
public abstract class TwoFirstsOfEachGroupStrategy implements MasterStrategy {

	@Override
	public Tournament selectionPhaseFinal(League[] pools) {
		List<Competitor> finalPhaseCompetitors = new ArrayList<Competitor>();
		Map<Competitor, Integer> potentialRetrievals = new HashMap<Competitor, Integer>();
		
		for (League league : pools) {
			Map<Competitor, Integer> resultGroupMap = league.ranking();
			
			Iterator<Competitor> iterator = resultGroupMap.keySet().iterator();
			
			addTwoFirstCompetitors(finalPhaseCompetitors, iterator);

			Competitor thirdCompetitor = iterator.next();
			potentialRetrievals.put(thirdCompetitor, thirdCompetitor.getNbWin());
		}
		
		potentialRetrievals = MapUtil.sortByDescendingValue(potentialRetrievals);

		Iterator<Competitor> iterator = potentialRetrievals.keySet().iterator();
		
		addTwoFirstCompetitors(finalPhaseCompetitors, iterator);
		
		try {
			return new Tournament(finalPhaseCompetitors);
		} catch (NumberOfTwoCompetitorsSizeException e) { 
			throw new RuntimeException(e);
		}
		
	}
	
	private void addTwoFirstCompetitors(List<Competitor> into, Iterator<Competitor> iterator) {
		Competitor firstRetrievalCompetitor = iterator.next();
		into.add(firstRetrievalCompetitor);
		
		Competitor secondRetrievalCompetitor = iterator.next();
		into.add(secondRetrievalCompetitor);
	}

	@Override
	public League[] remplissagePoule(List<Competitor> cps) {
		League[] pools = new League[getNbOfPools()];
		int idx = 0;
		for (int parcoursGroup = 0; parcoursGroup < getNbOfPools(); parcoursGroup++) {
			List<Competitor> poule = new ArrayList<Competitor>();
			for (int x = 0; x < cps.size()/getNbOfPools(); x++) {
				poule.add(cps.get(idx));
				idx++;
			}
			pools[parcoursGroup] = new League(poule);
		}
		return pools;
	}
	

	@Override
	public void checkCorrectNumberOfCompetitor(int nb) throws NumberOfTwoCompetitorsSizeException {
		if (nb != getNbOfCompetitors()) {
			throw new NumberOfTwoCompetitorsSizeException("Need a power of two number size list teams");
		}
	}

	@Override
	public int getNbOfQualifiquations() {
		return 2;
	}

	@Override
	public int getNbOfRetrivials() {
		return 2;
	}
	
}
