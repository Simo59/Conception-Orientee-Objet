package main.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import main.competition.Competitor;
import main.competition.NumberOfTwoCompetitorsSizeException;
import main.competition.League;
import main.competition.Tournament;

/**
 * Abstract class for the Design Pattern Strategy
 * 
 * @author aymane.ismail.etu
 * @author mohammed.hachour.etu
 * PROJET COO 2022
 * 
 */

public abstract class FirstOfEachGroupStrategy implements MasterStrategy {

	@Override
	public Tournament selectionPhaseFinal(League[] pools) {
		List<Competitor> finalPhaseCompetitors = new ArrayList<Competitor>();
		
		for (League league : pools) {
			Map<Competitor, Integer> resultGroupMap = league.ranking();
			
			Competitor firstCompetitor = resultGroupMap.keySet().iterator().next();
			
			finalPhaseCompetitors.add(firstCompetitor);
		}
		
		try {
			return new Tournament(finalPhaseCompetitors);
		} catch (NumberOfTwoCompetitorsSizeException e) {
			throw new RuntimeException("InadequateNumberOfCompetitorsException was not suppose to came here, \"this\" is it well coded ?", e);
		}
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
			throw new NumberOfTwoCompetitorsSizeException(String.format("%d is not the correct number of competitors which should be %d", nb, getNbOfCompetitors()));
		}
	}

	@Override
	public int getNbOfQualifiquations() {
		return 1;
	}

	@Override
	public int getNbOfRetrivials() {
		return 0;
	}
	
}
