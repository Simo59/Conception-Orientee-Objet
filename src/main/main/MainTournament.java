package main.main;

import java.util.Arrays;
import java.util.List;

import main.competition.Competition;
import main.competition.Competitor;
import main.competition.Master;
import main.competition.NumberOfTwoCompetitorsSizeException;
import main.competition.Tournament;
import main.observers.Bookmaker;
import main.observers.Journalist;
import main.strategy.FirstOfEachGroupStrategyFourPools;

public class MainTournament {

	public static void main(String[] args) {

		List<Competitor> competitors = Arrays.asList(new Competitor("Blastoff"), new Competitor("Drift"),
				 new Competitor("Lynx"), new Competitor("Catalyst"),
				 new Competitor("Raven"), new Competitor("Midas"),
				 new Competitor("Lille"), new Competitor("Lyon"),
				 new Competitor("Paris"), new Competitor("Marseille"),
				 new Competitor("Strasbourg"), new Competitor("Lens"),
				 new Competitor("Guingamp"), new Competitor("Roubaix"),
				 new Competitor("Barcelone"), new Competitor("Madrid"));
		
		playAndPrintRankingOfTournament(competitors);
	}
	

	/**
	 * @param competitors
	 * Choisissez une execution avec un Bookmaker avec la ligne en commentaire de la methode addObserver()
	 */
	private static void playAndPrintRankingOfTournament(List<Competitor> competitors) {
		System.out.println("\n---> STARTING OF A TOURNAMENT COMPETITION <---\n");
		try {
			Competition competition = new Tournament(competitors);
			
			competition.addObserver(new Journalist("Pierre Menez"));
			//competition.addObserver(new Bookmaker("Winamax"));
			
			competition.play();
			competition.printRanking();
			
		} catch (NumberOfTwoCompetitorsSizeException e) {
			e.printStackTrace();
		}
	}
	
}