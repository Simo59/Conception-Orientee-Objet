package main.main;

import java.util.Arrays;
import java.util.List;

import main.competition.Competition;
import main.competition.Competitor;
import main.competition.Master;
import main.competition.NumberOfTwoCompetitorsSizeException;
import main.observers.Bookmaker;
import main.observers.Journalist;
import main.strategy.FirstOfEachGroupStrategyFourPools;
import main.strategy.FirstOfEachGroupStrategyTwoPools;
import main.strategy.TwoFirstsOfEachGroupStrategyWithThirds;

public class MainMaster {

	public static void main(String[] args) {

		List<Competitor> competitors = Arrays.asList(new Competitor("Blastoff"), new Competitor("Drift"),
				 new Competitor("Lynx"), new Competitor("Catalyst"),
				 new Competitor("Raven"), new Competitor("Midas"),
				 new Competitor("Lille"), new Competitor("Lyon"));
		
		playAndPrintRankingOfMaster(competitors);
		
	}
	

	/**
	 * @param competitors c
	 * Choisissez une execution avec un Journalist avec la ligne en commentaire de la methode addObserver()
	 */
	private static void playAndPrintRankingOfMaster(List<Competitor> competitors) {
		System.out.println("\n---> STARTING OF A MASTER COMPETITION <---\n");
		try {
			Competition competition = new Master(competitors, new FirstOfEachGroupStrategyFourPools());
			
			//competition.addObserver(new Journalist("Pierre Menez"));
			competition.addObserver(new Bookmaker("Winamax"));
			
			competition.play();
			competition.printRanking();
			
		} catch (NumberOfTwoCompetitorsSizeException e) {
			e.printStackTrace();
		}
	}
	


}